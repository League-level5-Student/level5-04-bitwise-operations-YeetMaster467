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
    	
    	/*
    	for (int i = 0; i < 8; i++) {
    		//System.out.println(binStr.charAt(binStr.length() - 1));
        	byte b2 = (byte) (b >> 7 - i);
        	b2 = (byte) (b2 & 0b1);
        	//binStr = decimalToBinary(b);
        	System.out.print(b2);
    	}
    	*/
    	System.out.print((b & 0b10000000) >> 7);
    	System.out.print((b & 0b01000000) >> 6);
    	System.out.print((b & 0b00100000) >> 5);
    	System.out.print((b & 0b00010000) >> 4);
    	System.out.print((b & 0b00001000) >> 3);
    	System.out.print((b & 0b00000100) >> 2);
    	System.out.print((b & 0b00000010) >> 1);
    	System.out.print((b & 0b00000001) >> 0);
    }

    public static void printShortBinary(short s) {
        // Create 2 byte variables

        // Use bit shifting and masking (&) to save the first
        // 8 bits of s in one byte, and the second 8 bits of
        // s in the other byte

        // Call printByteBinary twice using the two bytes
        // Make sure they are in the correct order
    	
    	printByteBinary((byte) ((s & 0xff00) >> 8));
    	System.out.print(" ");
    	printByteBinary((byte) ((s & 0x00ff) >> 0));
    }

    public static void printIntBinary(int i) {
        // Create 2 short variables

        // Use bit shifting and masking (&) to save the first
        // 16 bits of i in one short, and the second 16 bits of
        // i in the other short

        // Call printShortBinary twice using the two short variables
        // Make sure they are in the correct order
    	printShortBinary((short) ((i & 0xffff0000) >> 16));
    	System.out.print(" ");
    	printShortBinary((short) ((i & 0x0000ffff) >> 0));
    }

    public static void printLongBinary(long l) {
        // Use the same method as before to complete this method
    	printIntBinary((int) (l >> 32));
    	System.out.print(" ");
    	printIntBinary((int) l);
    }

    public static void main(String[] args) {
       // printByteBinary((byte) 100);
       // System.out.println();
       // printByteBinary((byte) -69);
    	//printShortBinary((short) 164);
    	//System.out.println(" ");
    	//printShortBinary((short) 12000);
    	//printIntBinary(361134);
    	//System.out.println(" ");
    	//printIntBinary(-31);
    	printLongBinary(512830630128L);
    }
    
    
}
