import java.util.*;

class Solution {
    public static class Edge {
        int src;
        int dest;
        int time;

        public Edge(int src, int dest, int time) {
            this.src = src;
            this.dest = dest;
            this.time = time;
        }
    }

    public int countPaths(int n, int[][] roads) {
        // Build adjacency list using a separate creation() method
        List<Edge>[] graph = creation(n, roads);

        long[] dist = new long[n]; // shortest time to each node
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n]; // number of ways to reach each node
        ways[0] = 1;

        int MOD = 1_000_000_007;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, 0}); // {currentTime, node}

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long time = curr[0];
            int node = (int) curr[1];

            if (time > dist[node]) continue; // skip outdated entry

            for (Edge e : graph[node]) {
                int next = e.dest;
                long newTime = time + e.time;

                if (newTime < dist[next]) {
                    dist[next] = newTime;
                    ways[next] = ways[node]; // new shortest path found
                    pq.add(new long[]{newTime, next});
                } else if (newTime == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % MOD; // additional shortest path
                }
            }
        }

        return (int) ways[n - 1];
    }

    // Separate method to create adjacency list
    private List<Edge>[] creation(int n, int[][] roads) {
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] road : roads) {
            int u = road[0], v = road[1], t = road[2];
            graph[u].add(new Edge(u, v, t));
            graph[v].add(new Edge(v, u, t)); // bidirectional
        }
        return graph;
    }
}
