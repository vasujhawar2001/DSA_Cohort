package com.vasu;

public class CustomMethods {
    public static void main(String[] args) {

        // binary number
        long num = 110110111;

        // call method by passing the binary number
        int decimal = convertBinaryToDecimal(num);

        System.out.println("Binary to Decimal");
        System.out.println(num + " = " + decimal);
    }

    public static int convertBinaryToDecimal(long num) {
        int decimalNumber = 0, i = 0;
        long remainder;

        while (num != 0) {
            remainder = num % 10;
            num /= 10;
            decimalNumber += remainder * Math.pow(2, i);
            ++i;
        }

        return decimalNumber;
    }
    public static void parseIntFunc(){
        // binary number
        String binary = "01011011";

        // convert to decimal
        int decimal = Integer.parseInt(binary, 2);
        System.out.println(binary + " in binary = " + decimal + " in decimal.");
    }

    public static long convertDecimalToBinary(int n) {

        long binaryNumber = 0;
        int remainder, i = 1, step = 1;

        while (n!=0) {
            remainder = n % 2;
            System.out.println("Step " + step++ + ": " + n + "/2");

            System.out.println("Quotient = " + n/2 + ", Remainder = " + remainder);
            n /= 2;

            binaryNumber += remainder * i;
            i *= 10;
        }

        return binaryNumber;
    }

    public static void ToBinaryStringFunc(){
        // decimal number
        int decimal = 91;

        // convert decimal to binary
        String binary = Integer.toBinaryString(decimal);
        System.out.println(decimal + " in decimal = " + binary + " in binary.");
    }


}
