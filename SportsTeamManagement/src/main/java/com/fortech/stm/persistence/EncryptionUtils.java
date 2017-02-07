package com.fortech.stm.persistence;

public class EncryptionUtils {
	public static String encryptString(String encryptedString) {
		byte[] binary = encryptedString.getBytes();
		for (int i=0;i<binary.length;i++) {
			binary[i] = (byte) (binary[i] >> 4);
		}
		return (binary.toString());
	}
	
	public static String decryptString(String decryptedString) {
		byte[] binary = decryptedString.getBytes();
		for (int i=0;i<binary.length;i++) {
			binary[i] = (byte) (binary[i] << 4);
		}
		return (binary.toString());
	}
}
