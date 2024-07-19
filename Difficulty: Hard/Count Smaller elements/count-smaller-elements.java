//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] constructLowerArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        
        // Step 1: Create a sorted copy of the array and map elements to their ranks
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rankMap.put(sortedArr[i], i + 1); // rank starts from 1
        }
        
        // Step 2: Use a BIT to count the number of smaller elements on the right
        int[] BIT = new int[n + 1]; // BIT array of size n+1 (1-based indexing)
        
        // Step 3: Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            int rank = rankMap.get(arr[i]);
            ans[i] = query(BIT, rank - 1); // get the count of elements smaller than current element
            update(BIT, rank, 1); // insert the current element into the BIT
        }
        
        return ans;
    }
    
    // Function to update the BIT
    private void update(int[] BIT, int index, int value) {
        while (index < BIT.length) {
            BIT[index] += value;
            index += index & -index; // move to the next index
        }
    }
    
    // Function to query the BIT
    private int query(int[] BIT, int index) {
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= index & -index; // move to the parent index
        }
        return sum;
    }
}
