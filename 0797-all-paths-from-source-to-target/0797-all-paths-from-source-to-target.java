class Solution {
    public static class Edge{
        int src;
        int dest;

        public Edge (int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<Edge>[] g = creation(graph);

        List<List<Integer>> res = new ArrayList<>();
        boolean[] v = new boolean[g.length];

        dfs(g, v, 0, new ArrayList<>(), res, g.length - 1); // fixed: added path param + semicolon
        return res;
    }
    private ArrayList<Edge>[] creation (int[][] graph){
        ArrayList<Edge>[] g = new ArrayList[graph.length];

        for (int i = 0; i < graph.length; i++){
            g[i] = new ArrayList<Edge>();
            for (int j = 0; j < graph[i].length; j++){
                g[i].add(new Edge(i, graph[i][j]));
            }
        }

        return g;
    }

    private void dfs (ArrayList<Edge>[] g, boolean[] v, int curr, List<Integer> path, List<List<Integer>> res, int tar){
        path.add(curr);
        if (curr == tar) {
            res.add(new ArrayList<>(path)); // fix: must add copy of path
            path.remove(path.size() - 1);
            return;
        }
        for (int i = 0; i < g[curr].size(); i++){ // fix: use g not graph
            Edge e = g[curr].get(i);

            if (!v[e.dest]){
                v[curr] = true;
                dfs(g, v, e.dest, path, res, tar); // fix: correct params
                v[curr] = false;
            }
        }
        path.remove(path.size() - 1); // fix: backtrack
    }
}
