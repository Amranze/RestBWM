package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    long mongo = 1480517105707L;
	    SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
		String asGmt = df.format(new Date(mongo)) + " GMT";
	    System.out.println(asGmt);
	    System.out.print(new Date());
	}

}
