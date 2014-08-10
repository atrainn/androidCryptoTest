
package com.example.anthony.cryptotest;
import java.util.*;
import java.net.*;
import java.io.*;


public class getDoge {
	public static String getVal() throws IOException
	{
		//Building url
		String s = "https://block.io/api/v1/get_current_price/?api_key=8467-e6b6-f79b-e1ba&price_base=USD";
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
		String[] splitString = rawVals.split("\"price\"\\: \"");

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



