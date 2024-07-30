//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends



class Solution {
    private void help(int[][] matrix, int n, int i, int j, ArrayList<String> ans, String temp) {
        if (i < 0 || j < 0 || i == n || j == n || matrix[i][j] == 0) return;
        if (i == n - 1 && j == n - 1) {
            ans.add(temp);
            return;
        }
        matrix[i][j] = 0; // Mark as visited
        help(matrix, n, i + 1, j, ans, temp + 'D');
        help(matrix, n, i - 1, j, ans, temp + 'U');
        help(matrix, n, i, j + 1, ans, temp + 'R');
        help(matrix, n, i, j - 1, ans, temp + 'L');
        matrix[i][j] = 1; // Unmark as visited
    }

    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans = new ArrayList<>();
        if (mat == null || mat.length == 0 || mat[0][0] == 0 || mat[mat.length - 1][mat.length - 1] == 0) {
            return ans; // Early exit if starting or ending cell is blocked
        }
        help(mat, mat.length, 0, 0, ans, "");
        return ans;
    }
}
