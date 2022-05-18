package org.dng;

import java.util.OptionalInt;
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
 *      выделяет память под массив (size = 0).
 * ■По умолчанию (без параметров). Который выделяет память под массив на 10 элементов, равных нулю (capacity = 10, size = 0).
 *      Переиспользовать конструктор с параметрами для уменьшения кода.
 * <p>
 * Задание 2
 * Реализовать методы:
 * ■геттеры для size. Сеттера для size не должно быть!
 * ■переопределить метод toString и реализовать строковое представление  элементов массива через пробел.
 * ■ensureCapacity – закрытый метод! проверяет, достаточно ли резерва памяти для хранения указанного в параметре количества элементов.
 *      Если значение параметра меньше текущего capacity, то ничего не происходит.
 *      Если значение параметра больше текущего capacity, то массив пересоздает-ся, памяти выделяется в 1,5 раза + 1 элемент больше.
 *      Существующие элементы переносятся в новый массив.  Существующие элементы не должны быть потеряны.
 * <p>
 * Задание 3
 * Реализовать методы:
 * ■pushBack (добавление элемента в конец массива. Должна быть проверка, достаточно ли памяти!
 *      Если памяти не достаточно увеличить емкость массива данных);
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
 *      В результате работы вернуть индекс найденного элемента, а eсли ничего не найдено, вернуть -1);
 * ■lastIndexOf (линейный поиск справа налево вхождения в массив указанного значения.
 *      В результате работы вернуть индекс найденного элемента, а eсли ничего не найдено, вернуть -1).
 * <p>
 * Задание 5
 * Реализовать методы:
 * ■reverse (изменение порядка следования элементов в массиве на противоположный);
 * ■shuffle (случайное перемешивание элементов массива).
 * <p>
 * Задание 6
 * Реализовать методы:
 * ■equals (в качестве параметра передается ссылка на другой объект класса MyArrayList.
 *      Метод сравнивает массивы не только по количеству элементов, но и по их содержимому);
 * ■getElementAt (возврат копии элемента массива по указанному индексу, с проверкой на выход за пределы массива);
 * ■переопределить метод clone – метод создает точную копию MyArrayList и возвращает ссылку на эту копию (неглубокое копирование).
 */
public class MyArrayList <T> {
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
        return pointerOnLastElement+1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object o:dataArray) {
            sb.append(o.toString()+" ");
        }
        return sb.toString();
    }

    /**
     * ensureCapacity – закрытый метод!
     * проверяет, достаточно ли резерва памяти для хранения указанного в параметре количества элементов.
     * Если значение параметра меньше текущего capacity, то ничего не происходит. Если значение параметра больше текущего capacity,
     * то массив пересоздает-ся, памяти выделяется в 1,5 раза + 1 элемент больше. Существующие элементы переносятся в новый массив.
     * Существующие элементы не должны быть потеряны.
     * @param num - number of elements which we need to storage in array
     */
    private void ensureCapacity(int num){
        capacity = dataArray.length;
        if (capacity < num) {
            int newSize = (int)(capacity * 1.5) + 1 ;
            Object[] newArray = new Object[newSize];
            System.arraycopy(dataArray, 0, newArray, 0, capacity);
            dataArray = newArray;
            capacity = dataArray.length;
        }
    }

    /**
     * add item to end of array
     * @param item - item for adding
     */
    public void pushBack(T item) {
        ensureCapacity(pointerOnLastElement + 1 + 1);//current size = pointerOnLastElement+1 and need one place for new item
        dataArray[pointerOnLastElement+1] = item;
        pointerOnLastElement++;
    }


    public void set(int idx, T item) {
        if ((0 < idx) && (idx <= pointerOnLastElement)) {
            dataArray[idx] = item;
        }
    }


    public void remove(int idx) {
        Object[] newArray = new Object[dataArray.length - 1];
        if (idx > 0) {
            System.arraycopy(dataArray, 0, newArray, 0, idx);
        }
        System.arraycopy(dataArray, idx + 1, newArray, idx, pointerOnLastElement - idx - 1);
        dataArray = newArray;
        pointerOnLastElement--;

        if (CONDITION4CUT < (dataArray.length - pointerOnLastElement)) {
            newArray = new Object[pointerOnLastElement];
            System.arraycopy(dataArray, 0, newArray, 0, pointerOnLastElement);
            dataArray = newArray;
        }
        newArray = null;
    }

    public void show(String oper) {
        System.out.println("***** " + oper + " ****");
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

    public boolean isValuePresent(T topic) {
        return Stream.of(dataArray)
                .filter(v -> v != null)
                .anyMatch(v -> (v.equals(topic)));
    }

    public int getIndexOfVal(T topic) {
        OptionalInt result = OptionalInt.of(-1);
        if (isValuePresent(topic)) {
            result =
                    IntStream
                            .range(0, dataArray.length)
                            .filter(i -> dataArray[i].equals(topic))
                            .findFirst();
        }
//        return result.getAsInt();
        return result.orElse(-1);
    }


}
