package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class TestFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		final String FILENAME = "C:\\test\\0.35mV.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		        System.out.println(line.substring(19));
		    }
		    String everything = sb.toString();
		    //System.out.println(everything);
		}
	}

}
