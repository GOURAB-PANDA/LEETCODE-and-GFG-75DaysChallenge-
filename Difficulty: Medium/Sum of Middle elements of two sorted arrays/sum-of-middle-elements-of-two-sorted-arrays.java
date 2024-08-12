//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int n = arr1.length + arr2.length;
        int res[] = new int[n];
        int i=0, j=0, k=0;
      while(i< arr1.length && j<arr2.length){
          if(arr1[i] <= arr2[j]){
              res[k++] = arr1[i++];
          }
          else{
              res[k++] = arr2[j++];
          }
      }
        while(i < arr1.length){
            res[k++] = arr1[i++];
        }
        while(j < arr2.length){
            res[k++] = arr2[j++];
        }
        int m = n/2;
        int m1 = n/2-1;
        return res[m] + res[m1];
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends