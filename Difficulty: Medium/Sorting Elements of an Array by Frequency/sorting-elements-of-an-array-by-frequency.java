//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num,0)+ 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int num : arr){
            list.add(num);
        }
        Collections.sort(list, (a,b) -> {
            int frA = map.get(a);
            int frB = map.get(b);
            if(frA != frB){
                return frB - frA;
            }
            else{
                return a-b;
            }
        });
          return new ArrayList<>(list);
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends