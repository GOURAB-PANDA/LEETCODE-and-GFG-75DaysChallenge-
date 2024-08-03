//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int n = mat.length;  // Number of people (rows)
        int m = mat[0].length;  // Number of people (columns)
        int index = -1;  // Index to store potential celebrity
        int cnt1 = 0;  // Counter for row condition (no knowing others)
        int cnt2 = 0;  // Counter for column condition (known by others)

        // Iterate through each person
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt1 += mat[i][j];  // Count how many people i knows
                cnt2 += mat[j][i];  // Count how many people know i
            }
            
            // Check if person i is a celebrity
            if (cnt1 == 0 && cnt2 == n - 1) {
                index = i;
            }
            
            // Reset counters for next person
            cnt1 = 0;
            cnt2 = 0;
        }
        
        // Return index of celebrity or -1 if no celebrity is found
        return index;
    }
}