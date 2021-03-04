/*
https://www.geeksforgeeks.org/convert-alternate-characters-string-upper-case/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
	    int T=sc.nextInt();
	    for(int m=1;m<=T;m++){
	        String X=sc.next();
            System.out.println(change(X));
	    }
	}
	
	public static String change(String X){
		String newX="";
		for(int i=0;i<X.length();i++){
			if(Character.isUpperCase(X.charAt(i)))
				newX+=Character.toLowerCase(X.charAt(i));
	        else
	        	newX+=Character.toUpperCase(X.charAt(i));
	    }    	
    	return newX;
	}
}