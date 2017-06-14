package utils;

import java.util.Scanner;

public class Scan {
	public static final Scanner sc = new Scanner (System.in);
	
	public static void close () {
		Scan.sc.close ();
	}
}
