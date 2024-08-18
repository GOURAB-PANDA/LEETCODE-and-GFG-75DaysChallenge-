//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int[] ans = ob.sumClosest(arr, k);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] sumClosest(int[] arr, int k) {
        // code here
        int n = arr.length;
        int ans[] = new int[2];
        int p1=0,p2=0;
        int min = Integer.MAX_VALUE;
        
        int left =0, right = n-1;
        while(left < right){
            int sum = arr[left] + arr[right];
            int diff = Math.abs(sum-k);
            
        if(diff<min){
            min = diff;
            p1 = left;
            p2 = right;
        }
        if(sum < k){
            left++;
        }
        else{
            right--;
        }
        ans[0] = arr[p1];
        ans[1] = arr[p2];
        }
        return ans;
    }
}