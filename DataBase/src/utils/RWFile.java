package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RWFile {

	public static void write(String file, String script) {

		BufferedWriter bw;
		FileWriter fw;

		try {

			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(script);
			bw.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static String read(File file) {
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
			
		} catch (FileNotFoundException e) {

		}
		String ret = "";
		
		try {
			
			while (sc.hasNext()) {
				ret += sc.next();
			}
			
		} catch (NullPointerException ex) {

		}

		return ret;
	}
}