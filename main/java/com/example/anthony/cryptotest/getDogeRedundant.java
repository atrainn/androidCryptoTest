package com.example.anthony.cryptotest;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class getDogeRedundant {

	public static String getVal() throws IOException
	{
		//Building url
		String s = "http://pubapi.cryptsy.com/api.php?method=singlemarketdata&marketid=182";
		URL url = new URL(s);
		//Reads from URL
		Scanner scan = new Scanner(url.openStream());
		String str = new String();
		while (scan.hasNext())
			str += scan.nextLine();
		scan.close();
		
		return str;

	}
	
	public static String currentVal() throws IOException{
		String cleanedVal;
		String rawVals = getVal();
		String[] splitString = rawVals.split("\"Sell\",\"price\"\\:\"");
		
		String trimVal = splitString[1];
		String[] trimString = trimVal.split("\"");
		return trimString[0];
	}
	
	public static String milVal() throws IOException{
		double milDogeDouble = Double.parseDouble(currentVal());
		String totalMil = String.valueOf(milDogeDouble*1000000);
		return totalMil;
	}
}


