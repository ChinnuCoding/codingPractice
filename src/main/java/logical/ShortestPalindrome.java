package logical;

public class ShortestPalindrome {

    static String shortestPalindrome(String s) {
        int i=0;
        int j=s.length()-1;

        while(j>=0){
            if(s.charAt(i)==s.charAt(j)){
                i++;
            }
            j--;
        }

        if(i==s.length())
            return s;

        System.out.println("I value : " + i);

        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, i));

        System.out.println("Prefix : " + prefix + " suffix : " + suffix + " mid : " + mid);

        return prefix+mid+suffix;
    }

    public static void main(String[] args) {
        String str = "aab";

        System.out.println(".... : " + str.substring(0,0));

        String shortestPalindrome = shortestPalindrome(str);

        System.out.println("Length of shortest palindrome : " + shortestPalindrome);
    }

}
