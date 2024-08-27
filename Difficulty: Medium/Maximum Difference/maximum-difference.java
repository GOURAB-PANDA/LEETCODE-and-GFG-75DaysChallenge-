//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
        int[] nsl = getNSL(arr);
        int[] nsr = getNSR(arr);
        
        int maxDiff = 0;
        for(int i = 0; i<arr.length; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nsl[i] - nsr[i]));
        }
        return maxDiff;
    }
    
    private int[] getNSL(int[] arr) {
        int[] nsl = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<arr.length; i++) {
            while (!s.isEmpty() && s.peek() >= arr[i]) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                nsl[i] = 0;
            } else {
                nsl[i] = s.peek();
            }
            s.push(arr[i]);
        }
        return nsl;
    }
    
    private int[] getNSR(int[] arr) {
        int[] nsr = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        
        for(int i = arr.length-1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() >= arr[i]) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                nsr[i] = 0;
            } else {
                nsr[i] = s.peek();
            }
            s.push(arr[i]);
        }
        return nsr;
    }
}
