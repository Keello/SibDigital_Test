package com.example.demo.services;

public class MyHandler {

    public int[] textPrepare(String text){
        String strArr[] = text.split(",");
        int numArr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        return numArr;
    }

    public int[] bubbleSort(int[] array){
        for (int i = array.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

}
