//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    void helper(int board[][],ArrayList<ArrayList<Integer>> res,int row) {
        
        if(row == board.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0;i<board[0].length;i++) {
                for(int j = 0;j<board.length;j++) {
                    if(board[i][j] == 1) {
                        temp.add(j+1);
                    }
                }
            }
            res.add(temp);
            return;
        }
        
        int col = board[0].length;
        for(int i = 0;i<col;i++) {
            if(isSafe(board,row,i)) {
                board[row][i] = 1;
                helper(board,res,row+1);
                board[row][i] = 0;
            }
        }
    }
    boolean isSafe(int board[][],int row,int col) {
        //UP
        for(int i = row-1;i>=0;i--) {
            if(board[i][col] == 1) {
                return false;
            }
        }
        //UP Right
        for(int i = row-1,j = col+1;i>=0 && j<board.length;i--,j++) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        for(int i = row-1,j = col-1;i>=0 && j>=0 ;i--,j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int board[][] = new int[n][n];
        helper(board,res,0);
        return res;
    }
    }