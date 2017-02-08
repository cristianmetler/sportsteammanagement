package com.fortech.stm.persistence;

import java.util.Arrays;

public class EncryptionUtils {
	public static String encryptString(String encryptedString) {
		
		char [] array =encryptedString.toCharArray();
		char c = array[0];

		for (int i=0;i<array.length-1;i++) {
			array[i]=array[i+1];
		}
		
		array[array.length-1]=c;
		
		
		return String.valueOf(array);
	}
	
	public static String decryptString(String decryptedString) {
		char [] array = decryptedString.toCharArray();
		char c = array[array.length - 1];

		for (int i= array.length-1;i>=1;i--) {
			array[i]=array[i-1];
		}
		
		array[0]=c;
		
		return String.valueOf(array);
	}
}
