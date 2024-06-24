//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check if brackets are balanced or not.
    static boolean ispar(String x) {
        // Initialize a stack to keep track of opening brackets.
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the input string.
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            
            // If the character is an opening bracket, push it onto the stack.
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // If the stack is empty when encountering a closing bracket, return false.
                if (stack.isEmpty()) {
                    return false;
                }
                
                // Check if the top of the stack matches the corresponding opening bracket.
                char top = stack.peek();
                if ((top == '(' && ch == ')') || 
                    (top == '{' && ch == '}') || 
                    (top == '[' && ch == ']')) {
                    stack.pop();
                } else {
                    return false; // Mismatched bracket.
                }
            }
        }
        
        // If the stack is empty at the end, all brackets were balanced.
        return stack.isEmpty();
    }
}

