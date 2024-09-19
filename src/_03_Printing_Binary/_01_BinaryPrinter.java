package _03_Printing_Binary;

public class _01_BinaryPrinter {
    /*
     * Complete the methods below so they print the passed in parameter in binary.
     * Do not use the Integer.toBinaryString method!
     * Use the main method to test your methods.
     */


    public static void printByteBinary(byte b) {
        // We first want to print the bit in the one's place

        // Shift b seven bits to the right

        // Use the & operator to "mask" the bit in the one's place
        // This can be done by "anding" (&) it with the value of 1

        // Print the result using System.out.print (NOT System.out.println)

        //Use this method to print the remaining 7 bits of b
    	//String binStr = decimalToBinary(b);
    	
    	for (int i = 0; i < 8; i++) {
    		//System.out.println(binStr.charAt(binStr.length() - 1));
        	byte b2 = (byte) (b >> 7 - i);
        	b2 = (byte) (b2 & 0b1);
        	//binStr = decimalToBinary(b);
        	System.out.print(b2);
    	}
    }

    public static void printShortBinary(short s) {
        // Create 2 byte variables

        // Use bit shifting and masking (&) to save the first
        // 8 bits of s in one byte, and the second 8 bits of
        // s in the other byte

        // Call printByteBinary twice using the two bytes
        // Make sure they are in the correct order
    	
    	String binStr = decimalToBinary(s);
    	
    	byte b1 = (byte) (0b0 + Byte.parseByte((String) binStr.subSequence(0, 3)));
    	byte b2 = (byte) (0b0 + Byte.parseByte((String) binStr.subSequence(4, 7)));
    	
    	printByteBinary(b1);
    	System.out.print(" ");
    	printByteBinary(b2);
    	
    }

    public void printIntBinary(int i) {
        // Create 2 short variables

        // Use bit shifting and masking (&) to save the first
        // 16 bits of i in one short, and the second 16 bits of
        // i in the other short

        // Call printShortBinary twice using the two short variables
        // Make sure they are in the correct order
    }

    public void printLongBinary(long l) {
        // Use the same method as before to complete this method
    }

    public static void main(String[] args) {
       // printByteBinary((byte) 100);
       // System.out.println();
       // printByteBinary((byte) -69);
    	printShortBinary((short) 164);
    }
    
    public static String decimalToBinary(int decimalNum) {
    	String binaryStr = "";
    	
    	do {
    		
    		int quotient = decimalNum >>> 1;
    		
    		if (decimalNum % 2 != 0) {
    			binaryStr = '1' + binaryStr;
    		} else {
    			binaryStr = '0' + binaryStr;
    		}
    		
    		decimalNum = quotient;
    		
    	} while(decimalNum != 0);
    	
    	return binaryStr;
    }
    
}
