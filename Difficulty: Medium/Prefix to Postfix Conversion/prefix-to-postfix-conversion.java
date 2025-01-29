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
            String ans = obj.preToPost(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToPost(String pre_exp) {
        // code here
        Stack<String> stack = new Stack<>();
        int len = pre_exp.length();
        for(int i = len - 1; i >= 0; i--) {
            char c = pre_exp.charAt(i);
            if(isOperator(c)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                
                String temp = op1 + op2 + c;
                stack.push(temp);
            }
            else {
                stack.push(c + "");
            }
        }
        
        return stack.peek();
    }
    
    static boolean isOperator(char c) {
        if(c == '+' || c == '-' || c == '/' || c == '*' || c == '^' || c == '%') {
            return true;
        }
        return false;
    }
}
