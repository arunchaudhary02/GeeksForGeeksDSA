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
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
        
        // Stack to store intermediate results (operands and expressions)
        Stack<String> stack = new Stack<>();

        // Traverse the postfix expression character by character
        for (int i = 0; i < exp.length(); i++) {
            char currentChar = exp.charAt(i);

            // If the character is an operand, push it onto the stack
            if (isOperand(currentChar)) {
                stack.push(currentChar + ""); // Convert char to String before pushing
            } 
            // If the character is an operator, pop two elements from the stack
            else {
                // Pop the top two operands from the stack
                String operand1 = stack.pop(); // Right operand
                String operand2 = stack.pop(); // Left operand

                // Form a new infix expression with parentheses and push it back
                String infix = "(" + operand2 + currentChar + operand1 + ")";
                stack.push(infix);
            }
        }

        // The final element in the stack is the required infix expression
        return stack.peek();
        
    }
    
    // Function to check if a character is an operand
    static boolean isOperand(char x) {
        // Returns true if the character is a letter (either lowercase or uppercase)
        return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z');
    }
}
