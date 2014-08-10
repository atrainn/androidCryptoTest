package com.example.anthony.cryptotest;

import java.util.*;
import java.net.*;
import java.io.*;

public class updateValues {
	//1 = Bitcoin
	//2 = Doge
	//3 = MillionDoge
	public static String updateVal(String coin) throws IOException {
		//Variable
		String coinVal="0";
		if (coin.equals("2")){
				coinVal = getDoge.currentVal();
			}
		
		else if (coin.equals("3")){
				coinVal = getDoge.milVal();
        }
		return coinVal;
		
		}
	}


