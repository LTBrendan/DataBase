package utils;

import java.util.Scanner;

/**
 * This class only manage a Scanner used for all the program
 */
public class Scan {
	//the scanner used  by the program
	public static final Scanner sc = new Scanner (System.in);
	
	/**
	 * This method close the scanner
	 */
	public static void close () {
		Scan.sc.close ();
	}
}
