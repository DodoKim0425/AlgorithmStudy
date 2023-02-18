package com.dodo.algoStudyPersonal.forBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1759 {

	public static int l;
	public static int c;
	public static StringBuilder sb=new StringBuilder();
	public static ArrayList<Character> charList;
	
	public static void main(String[] args) {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    
	    char[] chars = null;
	    charList=new ArrayList<Character>();
	    
	    try {
	        String firstLine=br.readLine();
	        String secondLine=br.readLine();
	        StringTokenizer st=new StringTokenizer(firstLine);
	        l=Integer.parseInt(st.nextToken());
	        c=Integer.parseInt(st.nextToken());
	        secondLine=secondLine.replace(" ", "");
	        chars=secondLine.toCharArray();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    for(int i=0;i<chars.length;i++)
	        charList.add(chars[i]);
	    Collections.sort(charList);
	    
	    char[] word=new char[l];
	    
	    combination(0, 0, word, 0, 0);
	    System.out.println(sb);
	}
	
	public static void combination(int depth, int start, char[] word, int vowels, int consonants) {
	    if(l==depth) {
	    	if(vowels>=1&&consonants>=2) {//최소 1개 모음과 2개 자음
	    		for(int i=0;i<word.length;i++)
	    			sb.append(word[i]);
	    		sb.append("\n");
	    	}
	    	
	        return;
	    }else {
	        for(int i=start;i<c;i++) {
	            word[depth]=charList.get(i);
	            if(
	            		word[depth]=='a'||
	            		word[depth]=='e'||
	            		word[depth]=='i'||
	            		word[depth]=='o'||
	            		word[depth]=='u'
	            	) {
	            	combination(depth+1, i+1, word, vowels+1, consonants);
	            }else {
	            	combination(depth+1, i+1, word, vowels, consonants+1);
	            }
	            
	        }
	    }
	}
}