package _00_Binary_Conversion;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

/*
 * Goal: Learn how to convert binary to decimal
 * 
 * EXAMPLE: Convert 0 1 0 1 1 0 from binary to decimal
 * 
 * 1. Start from the right most digit of the binary number and assign
 *    that bit the value of 1.
 * 
 *          0   1   0   1   1   0
 *                              1
 * 2. As you move to the left, assign the next digit a value that is
 *    double the previous digit.
 *          0   1   0   1   1   0
 *         32  16   8   4   2   1
 *
 * 3. For every 1 in the binary number, add all of the corresponding values
 *    together.
 *          0   1   0   1   1   0
 *         32  16   8   4   2   1
 *          ----------------------
 *         0 + 16 + 0 + 4 + 2 + 0 = 22
 * 
 *   010110 in binary is equal to 22 in decimal!
 */
public class _02_BinaryToDecimal {
    int convertBinaryStringToDecimalInt(String b) {
    	String binStr = new StringBuilder(b).reverse().toString();
    	int[] arr = new int[binStr.length()];
    	int num = 0;
    	int total = 0;
    	for (int i = 0; i < binStr.length(); i++) {
    		if (i == 0) {
    			if (Integer.parseInt(binStr.charAt(i)+"") == 1) {
    				arr[i] = 1;
    			}
    			num = 1;
    		} else {
    			if (Integer.parseInt(binStr.charAt(i)+"") == 1) {
    				arr[i] = num*2;
    			}
    			num = num*2;
    		}
    	}
    	for (int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i] + " ");
    		total += arr[i];
    	}
        return total;
    }

    @Test
    public void TestBinToDec() {
        String binStr = "010110";
        int expected = 22;
        assertEquals(expected, convertBinaryStringToDecimalInt(binStr));
        
        binStr = "11110000";
        expected = 240;
        assertEquals(expected, convertBinaryStringToDecimalInt(binStr));
        
        binStr = "10100101";
        expected = 165;
        assertEquals(expected, convertBinaryStringToDecimalInt(binStr));
        
    }
}
