//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        int len = post_exp.length();
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            char c = post_exp.charAt(i);
            if(isOperator(c)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                
                String temp = c + op2 + op1;
                stack.push(temp);
            }
            else {
                stack.push(c + "");
            }
        }
        
        StringBuilder result = new StringBuilder();
        for(String str : stack) {
            result.append(str);
        }
        
        return result.toString();
    }
    
    static boolean isOperator(char c) {
        if(c == '+' || c == '-' || c == '/' || c == '*' || c == '^' || c == '%') {
            return true;
        }
        return false;
    }
}
