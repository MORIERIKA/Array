package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Array <Integer>array = new Array(5);
        for (int i=0;i<5;i++){
            array.addLast(i);
        }

        array.addFirst(5);
        System.out.println(array.toString());
        System.out.println(array.getCapacity());
    }
}
