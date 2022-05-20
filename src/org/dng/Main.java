package org.dng;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        int[] arr1 = new int[5];
//
//        arr1[0]=1;
//        arr1[1]=2;
//        arr1[2]=3;
//        arr1[3]=4;
//
//        System.arraycopy(arr1, 0, arr1, 1, 4);
//        System.out.println(Arrays.toString(arr1));

        MyArrayList<Integer> myArrayList = new MyArrayList<>(6);
        myArrayList.pushBack(0);
        myArrayList.pushBack(1);
        myArrayList.pushBack(2);
        myArrayList.pushBack(3);
        myArrayList.pushBack(4);

        System.out.println("reverse");
        myArrayList.show();
        myArrayList.reverse();
        myArrayList.show();

        System.out.println("reverse by stream");
        //myArrayList.show();
        myArrayList.reverseByStream();
        myArrayList.show();

//        System.out.println("popFront");
//        myArrayList.popFront();
//        myArrayList.show();
//
//        System.out.println();
//        System.out.println("popBack");
//        myArrayList.popBack();
//        myArrayList.show();

        System.out.println("shuffle");
        myArrayList.shuffle();
        myArrayList.show();

        System.out.println("shuffle");
        myArrayList.shuffle();
        myArrayList.show();


    }
}
