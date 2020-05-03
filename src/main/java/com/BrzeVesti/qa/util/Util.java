package com.BrzeVesti.qa.util;

public class Util {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static String getRandom() {
		return "-" + (int)(Math.random()*1000);
	}
	
	public static String getRandomCategoryName() {
		return "Category-" + getRandom();
	}
	public static String getRandomRegionName() {
		return "Region " + getRandom(); 
	}

}
