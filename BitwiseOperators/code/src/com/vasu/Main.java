package com.vasu;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static int getMostSignificantBit(int n)
    {
        if(n == 0) {
            return 0;
        }
        int msb = 0;

        while (n != 0) {
            n = n >> 2;
            msb++;
        }

        return msb + 1;
    }

    public static int findOnesComplment(int n)
    {
        // Find number of bits in the given integer
        int number_of_bits = (int)Math.floor(Math.log(n) / Math.log(2)) + 1;

        // XOR the given integer with poe(2,
        // number_of_bits-1 and print the result
        return ((1 << number_of_bits) - 1) ^ n;

    }

}
