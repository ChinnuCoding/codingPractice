package stringManipulations;

import java.util.Stack;

public class ReverseString {

    // Recursive function to reverse given character array
    private static void reverse(char A[], int l, int h) {
        if (l < h) {
            char ch = A[l];
            A[l] = A[h];
            A[h] = ch;

            reverse(A, l + 1, h - 1);
        }
    }

    // Recursive function to reverse a string in Java
    public static String reverse(String str) {
        // base case: if string is null or empty
        if (str == null || str.equals(""))
            return str;

        // convert string into a character array
        char[] A = str.toCharArray();

        // reverse character array
        reverse(A, 0, A.length - 1);

        // convert character array into the string
        return String.copyValueOf(A);
    }

    // Function to reverse a string in Java using a stack and character array
    public static String reverseUsingStack(String str)
    {
        // base case: if string is null or empty
        if (str == null || str.equals(""))
            return str;

        // create an empty stack of characters
        Stack<Character> stack = new Stack<Character>();

        // push every character of the given string into the stack
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++)
            stack.push(ch[i]);

        // start from index 0
        int k = 0;

        // pop characters from the stack until it is empty
        while (!stack.isEmpty())
        {
            // assign each popped character back to the character array
            ch[k++] = stack.pop();
        }

        // convert the character array into string and return it
        return String.copyValueOf(ch);
    }

    // Function to reverse a string in Java using a stack and StringBuilder
    public static String reverseUsingStringBuffer(String str)
    {
        // base case: if string is null or empty
        if (str == null || str.equals(""))
            return str;

        // create an empty stack of characters
        Stack<Character> stack = new Stack<Character>();

        // push every character of the given string into the stack
        for (int i = 0; i < str.length(); i++)
            stack.push(str.charAt(i));

        // pop characters from the stack and append them into StringBuilder
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        // convert StringBuilder to String and return
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Reverse me!";

        // string is immutable
        str = reverse(str);

        System.out.println("Reversed string is: " + str);
    }

}
