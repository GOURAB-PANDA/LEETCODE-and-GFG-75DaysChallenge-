class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);  // Start from the source node
        helper(graph, 0, graph.length - 1, path, ans);
        return ans;
    }

    private void helper(int[][] graph, int src, int dest, List<Integer> path, List<List<Integer>> ans) {
        if (src == dest) {
            ans.add(new ArrayList<>(path));  // Add a copy of the current path to the answer
            return;
        }

        for (int next : graph[src]) {
            path.add(next);  // Add the next node to the current path
            helper(graph, next, dest, path, ans);
            path.remove(path.size() - 1);  // Remove the last node to backtrack
        }
    }
}