package com.momo;

import edu.duke.*;

public class WordLengths {
	private FileResource resource;
	private int[] counts;

	public WordLengths(FileResource resource, int[] counts) {
		this.resource = resource;
		this.counts = counts;
	}

	public void countWordLengths() {
		int flag = 0;
		int wdlg = 0;
		String[] sb = new String[31]; 
		for(int i = 0; i < sb.length; i++){
			sb[i] = "";
		}
		for(String word: resource.words()){
			System.out.println(word);
			if(!Character.isLetter(word.charAt(0)) && !Character.isDigit (word.charAt(0))){
				flag++;
			}
			if(!Character.isLetter(word.charAt(word.length()-1)) && !Character.isDigit (word.charAt(word.length()-1))){
				flag++;
			}
			wdlg = word.length()-flag;
			if(wdlg > (counts.length - 1) && counts.length > 1){
				wdlg = counts.length - 1;
			}
			counts[wdlg]++;
			sb[wdlg] = sb[wdlg] + word + " ";
			flag = 0;
			
		}
		for(int i = 0; i < counts.length; i++)
		{
			if(counts[i] != 0){
				System.out.println(counts[i] + "words of length " + i + ":" + sb[i] );
			}
		}
	}

	public int indexOfMax(int[] counts) {
		int maxCount = 0;
		int maxLength = 0;
		for(int i = 0; i < counts.length; i++){
			if(counts[i] > maxCount){
				maxCount = counts[i] ;
				maxLength = i;
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		//FileResource resource = new FileResource("data/errors.txt");
		FileResource resource = new FileResource("data/romeo.txt");
		int[] counts = new int[31];
		int maxFr = 0;
		for(int i = 0; i < counts.length; i++){
			counts[i]= 0;
		}
		WordLengths wl = new WordLengths(resource, counts);
		wl.countWordLengths();
		maxFr = wl.indexOfMax(counts);
		System.out.println("最频繁出现的长度为：" + maxFr);

	}
}
