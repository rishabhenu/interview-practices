package org.example.swap;

public class SwapTwoNumbers {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.printf("Initially a = %s and b = %s\n", a, b);

        a += b;
        b = (a - b);
        a = (a - b);

        System.out.printf("Now a = %s and b = %s\n", a, b);
    }

}
