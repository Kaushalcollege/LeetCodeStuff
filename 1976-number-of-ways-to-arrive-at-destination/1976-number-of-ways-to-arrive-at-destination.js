/**
 * @param {number} n
 * @param {number[][]} roads
 * @return {number}
 */
var countPaths = function(n, roads) {
    class Edge {
        constructor(src, dest, time) {
            this.src = src;
            this.dest = dest;
            this.time = time;
        }
    }

    const graph = creation(n, roads);
    const dist = Array(n).fill(Number.MAX_SAFE_INTEGER);
    dist[0] = 0;
    const ways = Array(n).fill(0);
    ways[0] = 1;
    const MOD = 1_000_000_007;

    const pq = [[0, 0]]; // [currentTime, node]

    while (pq.length > 0) {
        // Min-heap behavior using sort (for simplicity)
        pq.sort((a, b) => a[0] - b[0]);
        const [time, node] = pq.shift();
        if (time > dist[node]) continue;

        for (const e of graph[node]) {
            const newTime = time + e.time;
            if (newTime < dist[e.dest]) {
                dist[e.dest] = newTime;
                ways[e.dest] = ways[node];
                pq.push([newTime, e.dest]);
            } else if (newTime === dist[e.dest]) {
                ways[e.dest] = (ways[e.dest] + ways[node]) % MOD;
            }
        }
    }

    return ways[n - 1] % MOD;

    // Separate function to create adjacency list
    function creation(n, roads) {
        const graph = Array.from({ length: n }, () => []);
        for (const [u, v, t] of roads) {
            graph[u].push(new Edge(u, v, t));
            graph[v].push(new Edge(v, u, t)); // bidirectional
        }
        return graph;
    }
};
