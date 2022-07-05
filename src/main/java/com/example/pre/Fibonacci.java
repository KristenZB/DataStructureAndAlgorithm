package com.example.pre;

public class Fibonacci {

    public static long basicFibonacci(int num) {
        if (num <= 1) {
            return num;
        }
        return basicFibonacci(num - 1) + basicFibonacci(num - 2);
    }

    public static long improvedFibonacci(int num) {
        if (num <= 1) {
            return num;
        }
        long first = 0;
        long second = 1;
        long sum = num;
        for (int i = 0; i < num - 1; i ++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }
}
