import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    // Edge class to represent a directed edge in the graph
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;
        int numVertices = m * n;

        // 1. Build the graph with "uphill" edges to search from the oceans inward.
        ArrayList<Edge>[] reversedGraph = createReversedGraph(heights);

        // Visited arrays for each ocean search
        boolean[] pacificReachable = new boolean[numVertices];
        boolean[] atlanticReachable = new boolean[numVertices];

        // 2. Start DFS from all Pacific border cells
        for (int r = 0; r < m; r++) {
            graphDfs(r * n, reversedGraph, pacificReachable); // Left border
        }
        for (int c = 0; c < n; c++) {
            graphDfs(c, reversedGraph, pacificReachable); // Top border
        }

        // 3. Start DFS from all Atlantic border cells
        for (int r = 0; r < m; r++) {
            graphDfs(r * n + (n - 1), reversedGraph, atlanticReachable); // Right border
        }
        for (int c = 0; c < n; c++) {
            graphDfs((m - 1) * n + c, reversedGraph, atlanticReachable); // Bottom border
        }

        // 4. Find the intersection of reachable cells
        for (int i = 0; i < numVertices; i++) {
            if (pacificReachable[i] && atlanticReachable[i]) {
                int r = i / n; // Convert 1D index back to row
                int c = i % n; // Convert 1D index back to col
                result.add(Arrays.asList(r, c));
            }
        }

        return result;
    }
    
    /**
     * Performing a Depth First Search on an explicit graph.
     */
    private void graphDfs(int u, ArrayList<Edge>[] graph, boolean[] reachable) {
        if (reachable[u]) {
            return;
        }
        reachable[u] = true;

        for (Edge edge : graph[u]) {
            int v = edge.dest;
            if (!reachable[v]) {
                graphDfs(v, graph, reachable);
            }
        }
    }

    /**
     * Create an explicit graph (adjacency list) where edges represent "uphill" flow.
     */
    private ArrayList<Edge>[] createReversedGraph(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int numVertices = m * n;

        ArrayList<Edge>[] graph = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] dr = {-1, 1, 0, 0}; // Directions: N, S, E, W
        int[] dc = {0, 0, 1, -1};

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int srcVertex = r * n + c;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        // If water can flow from neighbor (nr, nc) to current (r, c),
                        // add a reversed "uphill" edge for our search.
                        if (heights[nr][nc] >= heights[r][c]) {
                            int destVertex = nr * n + nc;
                            graph[srcVertex].add(new Edge(srcVertex, destVertex));
                        }
                    }
                }
            }
        }
        return graph;
    }
}