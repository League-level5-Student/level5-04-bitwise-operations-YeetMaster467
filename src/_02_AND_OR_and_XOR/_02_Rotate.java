package _02_AND_OR_and_XOR;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Goal: Implement left and right rotate methods.
 * 
 * Inherently Java doesn't have an instruction to perform left or right
 * rotates (though there are rotate functions in the Integer class).
 * 
 * A rotate is when a bit is shifted outside the width of the variable and is
 * placed on the other side. Here is an example of a right rotate on int 7
 * by 1:
 *      00000000 00000000 00000000 00000111   // original value of 7
 *      10000000 00000000 00000000 00000011   // rotate right by 1
 * 
 * Normally when the number 7 is right shifted by 1, the rightmost '1' is
 * discarded and the result looks like this:
 *      00000000 00000000 00000000 00000011   // 7 >> 1 (last '1' is discarded)
 * For a right rotate the number is not discarded and it's placed on the left,
 * the most significant bit (bit 31).
 * 
 * The same goes for a left rotate:
 *      11111111 11111111 11111111 11111000   // original value of -8
 *      11111111 11111111 11111111 11110001   // rotate left by 1
 */
public class _02_Rotate {
    
    int rotateLeft(int value, int rotateAmount) {
    	
    	System.out.println("Running Rotate Left");
    	
    	int num = 0b1;
    	
    	
    	for (int i = 0; i < rotateAmount; i++) {
    		System.out.println(Integer.toBinaryString(value));
    		int num2 = value >> 63;
    		num2 = num2 & num;
    		value = value << 1;
    		value = num2 | value;
    		System.out.println(Integer.toBinaryString(num2));
    	}
    	
        return value;
    }
    
    int rotateRight(int value, int rotateAmount) {

    	int num = 0b1;
    	
    	// might be able to use modulo %%
    	
    	for (int i = 0; i < rotateAmount; i++) {
    		//System.out.println(Integer.toBinaryString(value));
    		int num2 = num & value;
    		value = value >> 1;
    		num2 = num2 << 63;
    		//System.out.println(Integer.toBinaryString(num2));
    		int num3 = ~(num << 63);
    		value = num3 & value;
    		//System.out.println(Integer.toBinaryString(num3));
    		value = num2 | value;
    		
    	}
    	
    	/* for (int i = 0; i < rotateAmount; i++) {
    		binStr = Integer.toBinaryString(value);
    		
    		System.out.println(binStr);
    		if (binStr.charAt(binStr.length() - 1) == 1) {
    			value = value >> 1;
    			binStr = Integer.toBinaryString(value);
    			binStr.replaceFirst("0", "1");
    			value = 0b0 + Integer.parseInt(binStr);
    		} else {
    			value = value >> 1;
    			binStr = Integer.toBinaryString(value);
    		} 
    	} */
    	
    	return value;
    }
    
   @Test
    void testRotateLeft() {
        int i = -8;

        int result = rotateLeft(i, 1);
        System.out.println("Left rotate tests");
        System.out.println("Expected: " + Integer.toBinaryString(-15));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(-15, result);
        
        result = rotateLeft(i, 3);
        System.out.println();
        System.out.println("Expected: " + Integer.toBinaryString(-57));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(-57, result);
    }
    
    @Test
    void testRotateRight() {
        int i = 7;
        
        int result = rotateRight(i, 1);
        System.out.println("\nRight rotate tests");
        System.out.println("Expected: " + Integer.toBinaryString(-2147483645));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(-2147483645, result);
        
        result = rotateRight(i, 16);
        System.out.println();
        System.out.println("Expected: " + Integer.toBinaryString(458752));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(458752, result);
    }
}
