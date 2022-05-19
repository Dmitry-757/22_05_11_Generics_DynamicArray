package org.dng;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int[] arr1 = new int[5];

        arr1[0]=1;
        arr1[1]=2;
        arr1[2]=3;
        arr1[3]=4;

        System.arraycopy(arr1, 0, arr1, 1, 4);
        System.out.println(Arrays.toString(arr1));

    }
}
