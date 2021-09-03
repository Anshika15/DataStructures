import java.io.*;
import java.util.*;

public class Main {
    
    // farr -> frequency array of each word.

	public static int solution(String[] words, int[] farr, int[] score, int idx) {
		//write your code here
		
		if(idx == words.length)
		{
		    return 0;
		}
		
		int sno = 0 + solution(words, farr, score, idx+1); // if word not included
		
		// if word wants to get included
		/*
		    2 possibilities:-
		        i) word can be included.
		        ii) word can't e included --> if freq of a word is less we can't include that word
		*/
		
		
		int sword = 0;
		String str = words[idx];
		boolean flag = true;
		
		for(char ch : str.toCharArray())
		{
		    if(farr[ch - 'a'] == 0){
		        flag = false;
		    }
		    
		    farr[ch - 'a']--;
		    sword += score[ch - 'a'];
		}
		
		int syes = 0;
		
		if(flag)
		{
		    syes = sword + solution(words, farr, score, idx+1); 
		}
		
		for(char ch : str.toCharArray()) // backtrack
		{
		    farr[ch - 'a']++;
		}
		
		return Math.max(sno, syes);
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		System.out.println(solution(words, farr, score, 0));

	}
}
