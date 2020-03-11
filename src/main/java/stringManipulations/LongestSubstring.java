package stringManipulations;

import java.util.HashSet;

public class LongestSubstring {

    static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;

        int sPtr = 0, maxLen = 0, endPtr = 0;
        HashSet<Character> hSet = new HashSet<>();

        while (endPtr < s.length()) {
            if(!hSet.contains(s.charAt(endPtr))) {
                hSet.add(s.charAt(endPtr++));
                //endPtr++;
                maxLen = Math.max(maxLen, hSet.size());
            } else {
                hSet.remove(s.charAt(sPtr++));
                //sPtr++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int maxLength = lengthOfLongestSubstring("abcdaba");

        System.out.println("length of longest substring : " + maxLength);
    }

}
