package org.dng;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Мои файлы
 * Step Шамбала
 * JAVA113
 * Язык программирования Java
 * ДЗ
 * 1 Домашнее задание No 7.4Курс:«Язык программирования Java» ТЕМА: GENERICS
 * Написать класс-контейнер, реализующий логику работы одномерного безразмерного динамического массива.
 * Имя класса MyArrayList.
 * Структура данных – массив. Типы хранимых данных – объекты любых классов (исполь-зовать шаблонное программирование).
 * Все открытые методы должны содержать javadoc. Все открытые методы должны быть протестированы.
 * В классе должно быть три поля:
 * ■ссылка на инкапсулированный массив (можно назвать data);
 * ■текущее количество существующих элементов в массиве (int size);
 * ■текущая емкость массива (, по умолчанию 10).
 * <p>
 * Задание 1 Создать два конструктора.
 * ■С параметром типа int. Задающего начальную емкость массива. Принимает один параметр (задает capacity),
 * выделяет память под массив (size = 0).
 * ■По умолчанию (без параметров). Который выделяет память под массив на 10 элементов, равных нулю (capacity = 10, size = 0).
 * Переиспользовать конструктор с параметрами для уменьшения кода.
 * <p>
 * Задание 2
 * Реализовать методы:
 * ■геттеры для size. Сеттера для size не должно быть!
 * ■переопределить метод toString и реализовать строковое представление  элементов массива через пробел.
 * ■ensureCapacity – закрытый метод! проверяет, достаточно ли резерва памяти для хранения указанного в параметре количества элементов.
 * Если значение параметра меньше текущего capacity, то ничего не происходит.
 * Если значение параметра больше текущего capacity, то массив пересоздает-ся, памяти выделяется в 1,5 раза + 1 элемент больше.
 * Существующие элементы переносятся в новый массив.  Существующие элементы не должны быть потеряны.
 * <p>
 * Задание 3
 * Реализовать методы:
 * ■pushBack (добавление элемента в конец массива. Должна быть проверка, достаточно ли памяти!
 * Если памяти не достаточно увеличить емкость массива данных);
 * ■popFront (удаление первого элемента из массива);
 * ■pushFront (добавление нового элемента в начало массива);
 * ■insert (вставка нового элемента в массив по указанному индексу, с проверкой на выход за пределы массива);
 * ■removeAt (удаление одного элемента по указанному индексу. Должна быть проверка на допустимость индекса);
 * ■remove (удаление одного элемента, значение которого совпадает со значением переданного параметра);
 * ■removeAll (удаление всех элементов, значения которых совпадает со значением переданного параметра);
 * ■popBack (удаление последнего элемента из массива);
 * ■сlear (обнуление массива – всем элементам массива по индексам от 0 до size-1 присвоить значение null, полю sizeприсвоить значение 0).
 * <p>
 * Задание 4
 * Реализовать методы:
 * ■isEmpty (метод возвращает true, если size = 0, и false  в  обратном случае);
 * ■trimToSize (метод подгоняет значение capacity под size, естественно с перевыделением памяти);
 * ■indexOf (линейный поиск слева направо первого вхождения в массив указанного значения.
 * В результате работы вернуть индекс найденного элемента, а eсли ничего не найдено, вернуть -1);
 * ■lastIndexOf (линейный поиск справа налево вхождения в массив указанного значения.
 * В результате работы вернуть индекс найденного элемента, а eсли ничего не найдено, вернуть -1).
 * <p>
 * Задание 5
 * Реализовать методы:
 * ■reverse (изменение порядка следования элементов в массиве на противоположный);
 * ■shuffle (случайное перемешивание элементов массива).
 * <p>
 * Задание 6
 * Реализовать методы:
 * ■equals (в качестве параметра передается ссылка на другой объект класса MyArrayList.
 * Метод сравнивает массивы не только по количеству элементов, но и по их содержимому);
 * ■getElementAt (возврат копии элемента массива по указанному индексу, с проверкой на выход за пределы массива);
 * ■переопределить метод clone – метод создает точную копию MyArrayList и возвращает ссылку на эту копию (неглубокое копирование).
 */
public class MyArrayList<T> {
    private final int INIT_SIZE = 10;
    private final int RESIZE_QUANTITY = 2;
    private final int CONDITION4CUT = 2;
    private int pointerOnLastElement = 0; //pointerOnLastElement
    private int capacity = INIT_SIZE; //current size of array
    //    private Object[] dataArray = new Object[INIT_SIZE];
    private Object[] dataArray;

    //**** Constructors ****
    public MyArrayList() {
        dataArray = new Object[INIT_SIZE];
        capacity = dataArray.length;
    }

    public MyArrayList(int capacity) {
        dataArray = new Object[capacity];
        capacity = dataArray.length;
    }
    //**********************

    //*** Getters **********
    public int getSize() {
        return pointerOnLastElement + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object o : dataArray) {
            sb.append(o.toString() + " ");
        }
        return sb.toString();
    }

    /**
     * ensureCapacity – закрытый метод!
     * проверяет, достаточно ли резерва памяти для хранения указанного в параметре количества элементов.
     * Если значение параметра меньше текущего capacity, то ничего не происходит. Если значение параметра больше текущего capacity,
     * то массив пересоздает-ся, памяти выделяется в 1,5 раза + 1 элемент больше. Существующие элементы переносятся в новый массив.
     * Существующие элементы не должны быть потеряны.
     *
     * @param num - number of elements which we need to storage in array
     */
    private void ensureCapacity(int num) {
        capacity = dataArray.length;
        if (capacity < num) {
            int newSize = (int) (capacity * 1.5) + 1;
            Object[] newArray = new Object[newSize];
            System.arraycopy(dataArray, 0, newArray, 0, capacity);
            dataArray = newArray;
            capacity = dataArray.length;
        }
    }

    /**
     * add item to end of array
     *
     * @param item - item for adding
     */
    public void pushBack(T item) {
//        ensureCapacity(pointerOnLastElement + 1 + 1);//current size = pointerOnLastElement+1 and need one place for new item
//        if (pointerOnLastElement == 0 )
//            dataArray[pointerOnLastElement + 1] = item;
//        else
//            dataArray[pointerOnLastElement + 1] = item;
//
//        pointerOnLastElement++;
        if ((pointerOnLastElement == 0 )&&(dataArray[0]==null))
            insert(item, 0);
        else
            insert(item, pointerOnLastElement+1);
//            dataArray[pointerOnLastElement + 1] = item;

    }

    /**
     * add item to start of array
     *
     * @param item - item for adding
     */
    public void pushFront(T item) {
        insert(item, 0);
    }

    /**
     * insert item to array at index idx
     * return true if success or false if idx is in out of bounds of array
     *
     * @param item
     * @param idx
     */
    public boolean insert(T item, int idx) {
        boolean success = false;
        ensureCapacity(pointerOnLastElement + 1 + 1);//current size = pointerOnLastElement+1 and need one place for new item
        if (idx == 0) {
            if(dataArray[0]==null){
                dataArray[0] = item;
                success = true;
            }
            else {
                System.arraycopy(dataArray, 0, dataArray, 1, pointerOnLastElement + 1);
                dataArray[0] = item;
                pointerOnLastElement++;
                success = true;
            }
        } else if (idx <= pointerOnLastElement) {
            System.arraycopy(dataArray, idx + 1, dataArray, idx + 1, pointerOnLastElement + 1 - idx);
            dataArray[idx] = item;
            pointerOnLastElement++;
            success = true;
        } else if (idx == pointerOnLastElement+1) {
            dataArray[idx] = item;
            pointerOnLastElement++;
            success = true;
        }
        return success;
    }

    /**
     * remove item from start of array
     */
    public boolean popFront() {
        return removeAt(0);
    }

    public boolean popBack() {
        return removeAt(pointerOnLastElement);
    }

    /**
     * remove element at position idx (first position has index 0 )
     *
     * @param idx - index of erasing element of array
     */
    public boolean removeAt(int idx) {
        boolean success = false;

        if ((idx == 0) && (dataArray[0] != null)) {//remove first element
            System.arraycopy(dataArray, 1, dataArray, 0, pointerOnLastElement);
            dataArray[pointerOnLastElement] = null;
            pointerOnLastElement--;
            success = true;
        } else if (idx == pointerOnLastElement) {
            dataArray[idx] = null;
            pointerOnLastElement--;
            success = true;
        } else if ((idx > 0) && (idx <= pointerOnLastElement)) {
            System.arraycopy(dataArray, idx + 1, dataArray, idx + 0, pointerOnLastElement - idx);
            pointerOnLastElement--;
            success = true;
        }

//        if (CONDITION4CUT < (dataArray.length - pointerOnLastElement)) {
//            Object[] newArray = new Object[dataArray.length - 1];
//            newArray = new Object[pointerOnLastElement];
//            System.arraycopy(dataArray, 0, newArray, 0, pointerOnLastElement);
//            dataArray = newArray;
//            newArray = null;//???? does this operator needs for releasing of memory?
//        }
        return success;
    }

    /**
     * remove from array element which is equal to item
     * and return true if array contains value or false in other case
     *
     * @param item
     */
    public boolean remove(T item) {
        boolean success = false;
        int idx = indexOf(item);
        if (idx != -1) {
            removeAt(idx);
            success = true;
        }
        return success;
    }

    /**
     * remove from array all elements which are equal to item
     * and return true if array contains value or false in other case
     *
     * @param item
     */
    public boolean removeAll(T item) {
        boolean success = false;
        for (int i = 0; i < pointerOnLastElement; i++) {
            if (dataArray[i].equals(item)) {
                removeAt(i);
                success = true;
            }
        }
        return success;
    }


    public void clear() {
        dataArray = new Object[capacity];
        pointerOnLastElement = 0;
    }

    //task is not correct - pointerOnLastElement is zero may be in case when array contains one element with index 0
    // so, i add condition - element with index 0 must be null
    public boolean isEmpty() {
        return ((pointerOnLastElement == 0) && (dataArray[0] == null));
    }

    /**
     * trim array to amount of not-null elements
     */
    public void trimToSize() {
        dataArray = new Object[pointerOnLastElement + 1];
        capacity = dataArray.length;
    }

    /**
     * search item in array from 0-index to last index
     *
     * @param item - item for searching
     * @return in successful searching return index of item, in other case return -1
     */
    public int indexOf(Object item) {
        for (int i = 0; i < pointerOnLastElement; i++) {
            if (dataArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * search item in array from last index to 0-index
     *
     * @param item - item for searching
     * @return in successful searching return index of item, in other case return -1
     */
    public int lastIndexOf(Object item) {
        for (int i = pointerOnLastElement; i <= 0; i--) {
            if (dataArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }


    public boolean isItemPresent(T item) {
        return Stream.of(dataArray)
                .filter(v -> v != null)
                .anyMatch(v -> (v.equals(item)));
    }

    public int indexOfItem(T item) {
        OptionalInt result = OptionalInt.of(-1);
            result =
                    IntStream
                            .range(0, dataArray.length)
                            .filter(i -> dataArray[i].equals(item))
                            .findFirst();
        return result.orElse(-1);
    }


    //task 5

    /**
     * revers array
     */
    public void reverse(){
//        for (int i = 0; i <= ((pointerOnLastElement+1)/2); i++) {
        Object tmpItem;
        for (int i = 0; i < (pointerOnLastElement/2); i++) {
            tmpItem = dataArray[i];
            dataArray[i] = dataArray[pointerOnLastElement-i];
            dataArray[pointerOnLastElement-i] = tmpItem;
        }
    }

    /**
     * revers array using stream
     */
    public void reverseByStream(){
        Collections.reverse(Arrays.asList(dataArray));
    }


    public void shuffle(){

    }

    public void set(int idx, T item) {
        if ((0 < idx) && (idx <= pointerOnLastElement)) {
            dataArray[idx] = item;
        }
    }


    public void show() {
        System.out.println("*********");
        for (Object i : dataArray) {
            System.out.println(i);
        }
        System.out.println("*********");
    }

    //we will send a copy of the array outside, not the arrey itself - in order not to violate the principle of Encapsulation and "Open Closed Principle"  ))
    public Object[] getArr() {
        Object[] newArray = new Object[dataArray.length];
        System.arraycopy(dataArray, 0, newArray, 0, dataArray.length);
        return newArray;
    }

    public int getArrLenght() {
        return dataArray.length;
    }

    public T getItem(int idx) {
        return (T) dataArray[idx];
    }


}
