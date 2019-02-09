package com.compare.main;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class WordAccuracy {
	public void getSentences(String paragraph1, String paragraph2){
		
		
		BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
		List<String> sentenceList1 = getSentenceList(iterator, paragraph1);
		List<String> sentenceList2 = getSentenceList(iterator, paragraph2);
		
		for(int i = 0; i< sentenceList1.size() && i < sentenceList2.size(); i++ ){
			if(sentenceList1.get(i).equals(sentenceList2.get(i))){
				
			}else{
				
			}
		}
		
	}
	
	public void getWords(String sentence1, String sentence2){
		
		
		BreakIterator iterator = BreakIterator.getWordInstance();
		List<String> wordList1 = getSentenceList(iterator, sentence1);
		List<String> wordList2 = getSentenceList(iterator, sentence2);
		
		for(int i = 0; i< wordList1.size() && i < wordList2.size(); i++ ){
			if(wordList1.get(i).equals(wordList2.get(i))){
				
			}else{
				
			}
		}
		
	}

	public int getAccuracy(String paragraph1, String paragraph2){
		int percentage = 0;
		paragraph1 = paragraph1.trim().replaceAll("\\s+", " ");
		paragraph2 = paragraph2.trim().replaceAll("\\s+", " ");
		percentage = (int) (100 - (float) LevenshteinDistance(paragraph1, paragraph2) * 100 / (float) (paragraph1.length() + paragraph2.length()));
		return percentage;

	}
	
	public static int LevenshteinDistance(String s0, String s1) {
		int len0 = s0.length() + 1;
		int len1 = s1.length() + 1;
		int[] cost = new int[len0];
		int[] newcost = new int[len0];
		for (int i = 0; i < len0; i++)
			cost[i] = i;
		for (int j = 1; j < len1; j++) {
			newcost[0] = j - 1;
			for (int i = 1; i < len0; i++) {
				int match = (s0.charAt(i - 1) == s1.charAt(j - 1)) ? 0 : 1;
				int cost_replace = cost[i - 1] + match;
				int cost_insert = cost[i] + 1;
				int cost_delete = newcost[i - 1] + 1;
				newcost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace);
			}
			int[] swap = cost;
			cost = newcost;
			newcost = swap;
		}
		return cost[len0 - 1];
	}
	
	private static List<String> getSentenceList(BreakIterator bi, String source){
		List<String> senList = new ArrayList<String>();
		  bi.setText(source);

	        int lastIndex = bi.first();
	        while (lastIndex != BreakIterator.DONE) {
	            int firstIndex = lastIndex;
	            lastIndex = bi.next();

	            if (lastIndex != BreakIterator.DONE) {
	                String sentence = source.substring(firstIndex, lastIndex);
	                System.out.println("sentence = " + sentence);
	                senList.add(sentence);
	            }
	        }
		return senList;
		
	}
	private static int count(BreakIterator bi, String source) {
        int counter = 0;
        bi.setText(source);

        int lastIndex = bi.first();
        while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = bi.next();

            if (lastIndex != BreakIterator.DONE) {
                String sentence = source.substring(firstIndex, lastIndex);
                System.out.println("sentence = " + sentence);
                counter++;
            }
        }
        return counter;
    }
	
	public static void main(String[] args){
		String paragraph = "Many a time, a software application is required to generate reports in Microsoft Excel file format. Sometimes, an application is even expected to receive Excel files as input data. For example, an application developed for the Finance department of a company will be required to generate all their outputs in Excel.";
		String paragraph2 = "Many a time, a software application is required to generate reports in Microsoft Excel file format. Sometimes, an application is even expected to receive Excel files as input data. For example, an application developed for the Finance department of a company will be required to generate all their outputs in.";
		/*BreakIterator iterator = BreakIterator.getWordInstance();
		int sentences = count(iterator, paragraph);*/
		WordAccuracy wa = new WordAccuracy();
		int per = wa.getAccuracy(paragraph, paragraph2);
		
		
		System.out.println(per);
	}
}
