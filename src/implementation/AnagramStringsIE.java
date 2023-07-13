package implementation;

import java.util.*;


class AnagramStringsIE{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(anagramStringsIE(s,t));
    }

    static int anagramStringsIE(String s, String t){
    		int count = 0;
    		if(s.length()!=t.length()) return count;
    		int cntS[] = new int[26];
    		int cntT[] = new int[26];
    		Arrays.fill(cntS, 0);
    		Arrays.fill(cntT, 0);
    		for(char c:s.toCharArray()) {
    			int ind = c-'a';
    			cntS[ind]++;
    		}
    		for(char c:t.toCharArray()) {
    			int ind = c-'a';
    			cntT[ind]++;
    		}
    		for(int i=0;i<26;i++) {
    			if(cntT[i]>cntS[i]) count += cntT[i] - cntS[i];
    		}
    		return count;
      }
}

