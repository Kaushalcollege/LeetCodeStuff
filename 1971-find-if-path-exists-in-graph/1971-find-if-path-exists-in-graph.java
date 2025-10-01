class Solution {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        /*
            -- We are given a bi-directional graph with n vertices.
            -- labelled from [0, n-1].
            -- edges[i] = {ui, vi}
                | -- denotes bi-directional edge between ui vertex and vi vertex.

            -- Every vertex pair is connected by atmost one edge and no vertex has an edge to itself.
            -- Required to just find if there exists a pth from the src-vtx to dest-vtx.

            -- The question is, how exactly should we approach this problem?
            -- We can find the direct links from the src-vtx to the dest-vtx by simple looping.
            -- But how do we find connections?
            -- Constraints:
                    | -- 1 <= n <= 2 * 10^5
                    | -- 0 <= edges.length <= 2 * 10^5
                    | -- edges[i].length == 2
                    | -- 0 <= ui, vi <= n - 1
                    | -- ui != vi
                    | -- 0 <= src-vtx, dest-vtx <= n - 1

            -- from this, we can figure out that the time complexity should be O(n). -- most optimal solution.
            -- how can we brute force?
            -- Let us first build an adjacency list.
        */

        List<Edge>[] graph = new ArrayList[n];

        // Initializing empty ArrayLists in every index.
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for (int[] e : edges){
            graph[e[0]].add(new Edge(e[0], e[1]));
            graph[e[1]].add(new Edge(e[1], e[0]));
        }

        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited);

    }

    private boolean dfs(List<Edge>[] g, int src, int dest, boolean[] v){
        if (src == dest) return true;
        if (v[src]) return false;

        v[src] = true;

        for (Edge e : g[src]) {
            if (dfs(g, e.dest, dest, v)) {
                return true;
            }
        }
        return false;
    }
}