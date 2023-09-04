package com.vasu;

public class UsingBitwise {
// Using BITWISE OPERATIONS we get O(1) Time complexity
    public static void main(String[] args) {
	// write your code here
        System.out.println(decToBinary(135));
    }
    public static String decToBinary(int n) {
        StringBuilder result = new StringBuilder();
        // Size of an integer is assumed to be 32 bits
        //This loop gives O(1) Time complexity as i range does not depend on n, and is constant.
        for (int i = 31; i >= 0; i--) {
            int k = n >> i;
            result.append(((k & 1) > 0) ? "1" : "0");
        }
        return result.toString();
    }

    public static int binaryToDecimal(String number) {
        int result = 0;
        int length = number.length();
        for(int idx = 0 ; idx < length; idx++) {
            char val = number.charAt(idx);
            if(val == '1') {
                result |= (1 << (length - idx - 1)) ;
            }
        }
        return result;
    }
}
