package com.momo;

public class CaesarCipher {
	private int key;
	private String alphabetUp;
	private String alphabetLow;	
	private String shiftedAlphabetUp;
	private String shiftedAlphabetLow;
	
	public CaesarCipher(int key){
		this.key = key;
		alphabetUp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		alphabetLow = "abcdefghijklmnopqrstuvwxyz";	
		shiftedAlphabetUp = alphabetUp.substring(key) + alphabetUp.substring(0,key);
		shiftedAlphabetLow = alphabetLow.substring(key) + alphabetLow.substring(0,key);
		
	}
	
	public String encrypt(String input){
		StringBuilder encrypted =  new StringBuilder(input);
		
		for(int i = 0; i < encrypted.length(); i++){
			char currChar = encrypted.charAt(i);
			if(Character.isUpperCase(currChar)){
				int idx = alphabetUp.indexOf(currChar);
				if(idx != -1){
					char newChar = shiftedAlphabetUp.charAt(idx);
					encrypted.setCharAt(i, newChar);
				}
			}else{
				int idx = alphabetLow.indexOf(currChar);
				if(idx != -1){
					char newChar = shiftedAlphabetLow.charAt(idx);
					encrypted.setCharAt(i, newChar);
				}
			}
		}
		return encrypted.toString();
	}
	
	public int getKey(String s){
		int[] freqs = countLetters(s);
		int maxDex = maxIndex(freqs);
		int dkey = maxDex - 4;
		if(dkey < 0){
			dkey = 26 + dkey;
		}
		return dkey;
	}
	
	private int maxIndex(int[] vals) {
		int maxDex = 0;
		for(int k =0; k < vals.length; k++){
			if(vals[k] > vals[maxDex]){
				maxDex = k;
			}
		}
		return maxDex;
	}

	public int[] countLetters(String message){
		String alph = "abcdefghijklmnopqrstuvwxyz";
		int[] counts = new int[26];
		for(int k = 0; k < message.length();k++){
			char ch = Character.toLowerCase(message.charAt(k));
			int dex = alph.indexOf(ch);
			if(dex!=-1){
				counts[dex]+=1;
			}
		}
		return counts;
	}
		
	public static void main(String[] args){
		int key = 8;
		CaesarCipher cc = new CaesarCipher(key);		
		String message = "Can you imagine life WITHOUT the internet AND computers in your pocket? What is the encrypted string?";
		System.out.println("未处理的信息：" + message);
		//encryption
		String encrypted = cc.encrypt(message);
		System.out.println("加密后：" + encrypted);
		//decryption
		int dKey = cc.getKey(encrypted);
		CaesarCipher dcc = new CaesarCipher(dKey);	
		String decrypted = dcc.encrypt(encrypted);
		System.out.println("解密后" + decrypted);

	}
}
