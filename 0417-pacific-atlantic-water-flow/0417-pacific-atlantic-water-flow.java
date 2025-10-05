// import java.util.ArrayList;
// import java.util.List;

// class Solution {

//     /**
//      * Represents a directed edge in the graph, from a source vertex (src)
//      * to a destination vertex (dest).
//      */
//     static class Edge {
//         int src;
//         int dest;

//         Edge(int s, int d) {
//             this.src = s;
//             this.dest = d;
//         }
//     }

//     /**
//      * Creates an explicit graph (adjacency list) from the heights grid.
//      * The graph represents the "downhill" flow of water.
//      * @param heights The m x n grid of cell heights.
//      * @return An array of ArrayLists representing the adjacency list.
//      */
//     public ArrayList<Edge>[] create(int[][] heights) {
//         if (heights == null || heights.length == 0) {
//             return new ArrayList[0];
//         }

//         int m = heights.length;
//         int n = heights[0].length;
//         int numVertices = m * n;
        
//         // The adjacency list
//         ArrayList<Edge>[] graph = new ArrayList[numVertices];
//         for (int i = 0; i < numVertices; i++) {
//             graph[i] = new ArrayList<>();
//         }

//         // Directions for neighbors: North, South, East, West
//         int[] dr = {-1, 1, 0, 0}; // for rows
//         int[] dc = {0, 0, 1, -1}; // for columns

//         // Iterate over every cell to build the edges
//         for (int r = 0; r < m; r++) {
//             for (int c = 0; c < n; c++) {
//                 // Map the 2D grid coordinate (r, c) to a 1D vertex index
//                 int src = r * n + c;

//                 // Check all 4 neighbors
//                 for (int i = 0; i < 4; i++) {
//                     int nr = r + dr[i]; // neighbor row
//                     int nc = c + dc[i]; // neighbor col

//                     // Check if the neighbor is within the grid bounds
//                     if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
//                         // Check if water can flow from the current cell to the neighbor
//                         if (heights[r][c] >= heights[nr][nc]) {
//                             int dest = nr * n + nc;
//                             graph[src].add(new Edge(src, dest));
//                         }
//                     }
//                 }
//             }
//         }
//         return graph;
//     }


//     public List<List<Integer>> pacificAtlantic(int[][] heights) {
//         /*
//             -- This is a perfect example of implicit graph representation.
//             -- Here each cell represents a vertex.
//             -- We should consider an infinite amount of rain.
//             -- The idea and problem statement is understood, but how do we implement?
//             -- There are multiple ways the rainwater can flow.
//             -- DFS will help us here. Search for the path to the ocean.
//             -- First thing to accomplish is to create an explicit graph represtion using adjacency list.
//         */
        
//         List<List<Integer>> res = new ArrayList<>();

//         if (heights == null || heights.length == 0 || heights[0].length == 0) {
//             return res;
//         }

//         int m = heights.length;
//         int n = heights[0].length;
//         int k = m * n;

//         ArrayList<Edge>[] g = create(heights);

//         //Identify which vertices are ocean borders
//         boolean[] p = new boolean[k];
//         boolean[] a = new boolean[k];
//         for (int r = 0; r < m; r++) {
//             for (int c = 0; c < n; c++) {
//                 int vertexId = r * n + c;
//                 if (r == 0 || c == 0) {
//                     p[vertexId] = true;
//                 }
//                 if (r == m - 1 || c == n - 1) {
//                     a[vertexId] = true;
//                 }
//             }
//         }

//         // For each vertex, check if it can reach both oceans
//         for (int i = 0; i < k; i++) {
//             // We need a fresh `visited` array for each starting cell's search
//             boolean reachesPacific = dfs(i, g, p, new boolean[k]);
//             boolean reachesAtlantic = dfs(i, g, a, new boolean[k]);

//             if (reachesPacific && reachesAtlantic) {
//                 int r = i / n; // Convert 1D index back to row, because src = r * n + c, quotient is r.
//                 int c = i % n; // Convert 1D index back to col, because src = r * n + c, remainder is c.
//                 res.add(Arrays.asList(r, c));
//             }
//         }
        
//         return res;
//     }

//     /**
//      * Searches for a path from a starting vertex to any target ocean vertex.
//      * @param current The current vertex in the search.
//      * @param graph The adjacency list.
//      * @param isOcean An array marking the target ocean vertices.
//      * @param visited An array to track visited vertices to prevent cycles.
//      * @return true if a path to the ocean is found, false otherwise.
//      */
//     private boolean dfs(int current, ArrayList<Edge>[] graph, boolean[] isOcean, boolean[] visited) {
//         // If we've already been here in this specific search, stop.
//         if (visited[current]) {
//             return false;
//         }
//         // If the current node is an ocean node, we found a path!
//         if (isOcean[current]) {
//             return true;
//         }

//         visited[current] = true;

//         // Explore neighbors
//         for (Edge edge : graph[current]) {
//             if (dfs(edge.dest, graph, isOcean, visited)) {
//                 return true; // Path found, no need to check other neighbors
//             }
//         }

//         return false; // No path found from this vertex
//     }
// }

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    static class Edge {
        int src;
        int dest;
        Edge(int s, int d) { this.src = s; this.dest = d; }
    }

    /**
     * Creates a graph where edges represent "uphill" flow.
     * This allows us to start from the oceans and traverse inward.
     */
    public ArrayList<Edge>[] createUphillGraph(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int numVertices = m * n;
        
        ArrayList<Edge>[] graph = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int src = r * n + c;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        // If the neighbor is TALLER or EQUAL, add an uphill edge
                        // from the current cell TO the neighbor.
                        if (heights[nr][nc] >= heights[r][c]) {
                            int dest = nr * n + nc;
                            graph[src].add(new Edge(src, dest));
                        }
                    }
                }
            }
        }
        return graph;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }

        int m = heights.length;
        int n = heights[0].length;
        int numVertices = m * n;

        // 1. Create the explicit UPHILL graph
        ArrayList<Edge>[] uphillGraph = createUphillGraph(heights);

        // 2. Create reachable arrays for each ocean
        boolean[] pacificReachable = new boolean[numVertices];
        boolean[] atlanticReachable = new boolean[numVertices];

        // 3. Start traversal from Pacific border cells
        for (int r = 0; r < m; r++) {
            dfs(r * n, uphillGraph, pacificReachable); // Left border
        }
        for (int c = 0; c < n; c++) {
            dfs(c, uphillGraph, pacificReachable); // Top border
        }

        // 4. Start traversal from Atlantic border cells
        for (int r = 0; r < m; r++) {
            dfs(r * n + (n - 1), uphillGraph, atlanticReachable); // Right border
        }
        for (int c = 0; c < n; c++) {
            dfs((m - 1) * n + c, uphillGraph, atlanticReachable); // Bottom border
        }

        // 5. Find the intersection of cells reachable from both oceans
        for (int i = 0; i < numVertices; i++) {
            if (pacificReachable[i] && atlanticReachable[i]) {
                int r = i / n;
                int c = i % n;
                res.add(Arrays.asList(r, c));
            }
        }
        return res;
    }

    /**
     * Traverses the graph from a starting vertex, marking all reachable
     * vertices in the `reachable` array.
     */
    private void dfs(int current, ArrayList<Edge>[] graph, boolean[] reachable) {
        if (reachable[current]) {
            return;
        }
        reachable[current] = true;

        for (Edge edge : graph[current]) {
            dfs(edge.dest, graph, reachable);
        }
    }
}