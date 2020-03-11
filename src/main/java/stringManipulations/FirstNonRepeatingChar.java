package stringManipulations;

import java.util.HashMap;

public class FirstNonRepeatingChar {

    static int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        System.out.println(count.toString());

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "goodProgram";

        int index = firstUniqChar(str);

        System.out.println("First non-repeated char in a string at index  : " + index);
    }

}
