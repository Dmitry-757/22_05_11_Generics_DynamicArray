package org.dng;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {


    private static MyArrayList<Integer> myArrayList;

    //@BeforeAll
    @BeforeEach
    void setUp() {
        myArrayList = new MyArrayList<>(8);
        myArrayList.pushBack(0);
        myArrayList.pushBack(1);
        myArrayList.pushBack(2);
        myArrayList.pushBack(3);
        myArrayList.pushBack(4);
    }


    @Test
    void MyArrayListConstructor(){
        MyArrayList<Integer> actual = new MyArrayList<>();

        MyArrayList<Integer> expected = new MyArrayList<>(10);

        Object[] arr = new Object[10];
        try {
            Field fieldDataArray = expected.getClass().getDeclaredField("dataArray");
            fieldDataArray.setAccessible(true);
            fieldDataArray.set(expected, arr);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals(expected, actual);
    }

    @Test
    void MyArrayListConstructorWithParams(){
        MyArrayList<Integer> actual = new MyArrayList<>(5);

        MyArrayList<Integer> expected = new MyArrayList<>(5);

        Object[] arr = new Object[5];
        try {
            Field fieldDataArray = expected.getClass().getDeclaredField("dataArray");
            fieldDataArray.setAccessible(true);
            fieldDataArray.set(expected, arr);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


        assertEquals(expected, actual);
    }

    @Test
    void getSize() {
        Assertions.assertEquals(myArrayList.getSize(),5);
    }

    @Test
    void testToString() {
//        System.out.println(myArrayList.toString());
        assertEquals("0 1 2 3 4 ", myArrayList.toString());
    }

    @Test
    void pushBack() {
        /**
         * equality defined as:
         * return capacity == that.capacity &&
         *       pointerOnLastElement == that.pointerOnLastElement &&
         *       Arrays.equals(dataArray, that.dataArray);
         * so, needed to compare capacity, pointerOnLastElement and dataArray
        */
        myArrayList.pushBack(5);
        myArrayList.pushBack(6);

        MyArrayList<Integer> expected = new MyArrayList<>(myArrayList.getCapacity());
        Object[] arr = new Object[myArrayList.getCapacity()];
        try {
            Field fieldDataArray = expected.getClass().getDeclaredField("dataArray");
            fieldDataArray.setAccessible(true);
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 3;
            arr[4] = 4;
            arr[5] = 5;
            arr[6] = 6;

            fieldDataArray.set(expected, arr);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field fieldPointerOnLastElement = expected.getClass().getDeclaredField("pointerOnLastElement");
            fieldPointerOnLastElement.setAccessible(true);
            fieldPointerOnLastElement.set(expected, 6);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


        assertEquals(expected, myArrayList);

    }

    @Test
    void pushFront() {
        /**
         * equality defined as:
         * return capacity == that.capacity &&
         *       pointerOnLastElement == that.pointerOnLastElement &&
         *       Arrays.equals(dataArray, that.dataArray);
         * so, needed to compare capacity, pointerOnLastElement and dataArray
         */
        myArrayList.pushFront(-1);
        myArrayList.pushFront(-2);

        MyArrayList<Integer> expected = new MyArrayList<>(myArrayList.getCapacity());
        Object[] arr = new Object[myArrayList.getCapacity()];
        try {
            Field fieldDataArray = expected.getClass().getDeclaredField("dataArray");
            fieldDataArray.setAccessible(true);
            arr[0] = -2;
            arr[1] = -1;
            arr[2] = 0;
            arr[3] = 1;
            arr[4] = 2;
            arr[5] = 3;
            arr[6] = 4;

            fieldDataArray.set(expected, arr);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field fieldPointerOnLastElement = expected.getClass().getDeclaredField("pointerOnLastElement");
            fieldPointerOnLastElement.setAccessible(true);
            fieldPointerOnLastElement.set(expected, 6);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals(expected, myArrayList);
    }

    @Test
    void insert() {
        /**
         * equality defined as:
         * return capacity == that.capacity &&
         *       pointerOnLastElement == that.pointerOnLastElement &&
         *       Arrays.equals(dataArray, that.dataArray);
         * so, needed to compare capacity, pointerOnLastElement and dataArray
         */
        myArrayList.insert(99,2);

        MyArrayList<Integer> expected = new MyArrayList<>(myArrayList.getCapacity());
        Object[] arr = new Object[myArrayList.getCapacity()];
        try {
            Field fieldDataArray = expected.getClass().getDeclaredField("dataArray");
            fieldDataArray.setAccessible(true);
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 99;
            arr[3] = 2;
            arr[4] = 3;
            arr[5] = 4;

            fieldDataArray.set(expected, arr);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field fieldPointerOnLastElement = expected.getClass().getDeclaredField("pointerOnLastElement");
            fieldPointerOnLastElement.setAccessible(true);
            fieldPointerOnLastElement.set(expected, 5);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        assertEquals(expected, myArrayList);
    }


    @Test
    void popFront() {
        /**
         * equality defined as:
         * return capacity == that.capacity &&
         *       pointerOnLastElement == that.pointerOnLastElement &&
         *       Arrays.equals(dataArray, that.dataArray);
         * so, needed to compare capacity, pointerOnLastElement and dataArray
         */
        myArrayList.popFront();

        MyArrayList<Integer> expected = new MyArrayList<>(myArrayList.getCapacity());
        Object[] arr = new Object[myArrayList.getCapacity()];
        try {
            Field fieldDataArray = expected.getClass().getDeclaredField("dataArray");
            fieldDataArray.setAccessible(true);
            arr[0] = 1;
            arr[1] = 2;
            arr[2] = 3;
            arr[3] = 4;

            fieldDataArray.set(expected, arr);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field fieldPointerOnLastElement = expected.getClass().getDeclaredField("pointerOnLastElement");
            fieldPointerOnLastElement.setAccessible(true);
            fieldPointerOnLastElement.set(expected, 3);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals(expected, myArrayList);
    }

    @Test
    void popBack() {
        /**
         *  original dataArray is:[0 1 2 3 4 null null null]
         *  original capacity = 8
         *  original pointerOnLastElement = 4
         * equality defined as:
         * return capacity == that.capacity &&
         *       pointerOnLastElement == that.pointerOnLastElement &&
         *       Arrays.equals(dataArray, that.dataArray);
         * so, needed to compare capacity, pointerOnLastElement and dataArray
         */
        myArrayList.popBack();

        MyArrayList<Integer> expected = new MyArrayList<>(myArrayList.getCapacity());
        Object[] arr = new Object[myArrayList.getCapacity()];
        try {
            Field fieldDataArray = expected.getClass().getDeclaredField("dataArray");
            fieldDataArray.setAccessible(true);
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 3;

            fieldDataArray.set(expected, arr);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field fieldPointerOnLastElement = expected.getClass().getDeclaredField("pointerOnLastElement");
            fieldPointerOnLastElement.setAccessible(true);
            fieldPointerOnLastElement.set(expected, 3);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals(expected, myArrayList);
    }

    @Test
    void removeAt() {
        /**
         *  original dataArray is:[0 1 2 3 4 null null null]
         *  original capacity = 8
         *  original pointerOnLastElement = 4
         * equality defined as:
         * return capacity == that.capacity &&
         *       pointerOnLastElement == that.pointerOnLastElement &&
         *       Arrays.equals(dataArray, that.dataArray);
         * so, needed to compare capacity, pointerOnLastElement and dataArray
         */
        myArrayList.removeAt(2);

        MyArrayList<Integer> expected = new MyArrayList<>(myArrayList.getCapacity());
        Object[] arr = new Object[myArrayList.getCapacity()];
        try {
            Field fieldDataArray = expected.getClass().getDeclaredField("dataArray");
            fieldDataArray.setAccessible(true);
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 3;
            arr[3] = 4;

            fieldDataArray.set(expected, arr);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field fieldPointerOnLastElement = expected.getClass().getDeclaredField("pointerOnLastElement");
            fieldPointerOnLastElement.setAccessible(true);
            fieldPointerOnLastElement.set(expected, 3);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals(expected, myArrayList);
    }

    @Test
    void remove() {
        /**
         *  original dataArray is:[0 1 2 3 4 null null null]
         *  original capacity = 8
         *  original pointerOnLastElement = 4
         * equality defined as:
         * return capacity == that.capacity &&
         *       pointerOnLastElement == that.pointerOnLastElement &&
         *       Arrays.equals(dataArray, that.dataArray);
         * so, needed to compare capacity, pointerOnLastElement and dataArray
         */
        myArrayList.pushBack(3);
        // now original dataArray is:[0 1 2 3 4 3 null null]
        myArrayList.remove(3);
        // now original dataArray is:[0 1 2 4 3 null null null]

        MyArrayList<Integer> expected = new MyArrayList<>(myArrayList.getCapacity());
        Object[] arr = new Object[myArrayList.getCapacity()];
        try {
            Field fieldDataArray = expected.getClass().getDeclaredField("dataArray");
            fieldDataArray.setAccessible(true);
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 4;
            arr[4] = 3;

            fieldDataArray.set(expected, arr);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field fieldPointerOnLastElement = expected.getClass().getDeclaredField("pointerOnLastElement");
            fieldPointerOnLastElement.setAccessible(true);
            fieldPointerOnLastElement.set(expected, 4);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals(expected, myArrayList);
    }

    @Test
    void removeAll() {
        /**
         *  original dataArray is:[0 1 2 3 4 null null null]
         *  original capacity = 8
         *  original pointerOnLastElement = 4
         * equality defined as:
         * return capacity == that.capacity &&
         *       pointerOnLastElement == that.pointerOnLastElement &&
         *       Arrays.equals(dataArray, that.dataArray);
         * so, needed to compare capacity, pointerOnLastElement and dataArray
         */
        myArrayList.pushBack(3);
        // now original dataArray is:[0 1 2 3 4 3 null null]
        myArrayList.removeAll(3);
        // now original dataArray is:[0 1 2 4 null null null null]

        MyArrayList<Integer> expected = new MyArrayList<>(myArrayList.getCapacity());
        Object[] arr = new Object[myArrayList.getCapacity()];
        try {
            Field fieldDataArray = expected.getClass().getDeclaredField("dataArray");
            fieldDataArray.setAccessible(true);
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 4;

            fieldDataArray.set(expected, arr);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field fieldPointerOnLastElement = expected.getClass().getDeclaredField("pointerOnLastElement");
            fieldPointerOnLastElement.setAccessible(true);
            fieldPointerOnLastElement.set(expected, 3);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals(expected, myArrayList);
    }

    @Test
    void clear() {
        myArrayList.clear();

        assertEquals(0, myArrayList.getSize());
        boolean existsNotNullItems = true;
        try {
            Field fieldDataArray = myArrayList.getClass().getDeclaredField("dataArray");
            fieldDataArray.setAccessible(true);

            boolean allItemsAreNull = true;
            Object[] dataArray = (Object[]) fieldDataArray.get(myArrayList);
            for (Object o:dataArray) {
                if(o!=null) {
                    allItemsAreNull = false;
                    break;
                }
            }
            existsNotNullItems = !allItemsAreNull;

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        assertFalse(existsNotNullItems);



    }

    @Test
    void isEmpty() {
        myArrayList.clear();

        assertTrue(myArrayList.isEmpty());

    }

    @Test
    void trimToSize() {
        myArrayList.trimToSize();
        assertEquals(5, myArrayList.getCapacity());
        assertEquals(myArrayList.getSize(), myArrayList.getCapacity());
    }

    @Test
    void indexOf() {
        //original dataArray is:[0 1 2 3 4 null null null]
        myArrayList.pushBack(3);
        //original dataArray is:[0 1 2 3 4 3 null null]
        assertEquals(3, myArrayList.indexOf(3));
    }

    @Test
    void lastIndexOf() {
        //original dataArray is:[0 1 2 3 4 null null null]
        myArrayList.pushBack(3);
        //original dataArray is:[0 1 2 3 4 3 null null]
        assertEquals(5, myArrayList.lastIndexOf(3));
    }

    @Test
    void reverse() {
        //original dataArray is:[0 1 2 3 4 null null null]
        myArrayList.reverse();
        assertEquals("4 3 2 1 0 ", myArrayList.toString());
    }


    @Test
    void getElementAt() {
        //original dataArray is:[0 1 2 3 4 null null null]
        try {
            assertEquals(0, myArrayList.getElementAt(0));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testEquals() {
        /**
         equals (в качестве параметра передается ссылка на другой объект класса MyArrayList.
         Метод сравнивает массивы не только по количеству элементов, но и по их содержимому);
         original dataArray is:[0 1 2 3 4 null null null]
         */

        //lets compare equal arrays
        MyArrayList<Integer>  myArrayList2 = new MyArrayList<>(8);
        myArrayList2.pushBack(0);
        myArrayList2.pushBack(1);
        myArrayList2.pushBack(2);
        myArrayList2.pushBack(3);
        myArrayList2.pushBack(4);

        assertTrue(myArrayList.equals(myArrayList2));

        //lets make myArrayList2 not equal to myArrayList (add extra element)
        myArrayList2.pushBack(4);
        assertNotEquals(true, myArrayList.equals(myArrayList2));

        //lets make myArrayList2 not equal to myArrayList (change one of elements)
        myArrayList2 = new MyArrayList<>(8);
        myArrayList2.pushBack(0);
        myArrayList2.pushBack(1);
        myArrayList2.pushBack(2);
        myArrayList2.pushBack(3);
        myArrayList2.pushBack(5);

        assertNotEquals(true, myArrayList.equals(myArrayList2));

    }


    @Test
    void testClone() {
        /**
         переопределить метод clone – метод создает точную копию MyArrayList и возвращает ссылку на эту копию (неглубокое копирование).
         */
        MyArrayList clone = myArrayList.clone();
        assertEquals(myArrayList, clone);
    }

}