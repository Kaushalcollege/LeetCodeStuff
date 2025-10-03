/**
 * @param {number[][]} graph
 * @return {number[][]}
 */
var allPathsSourceTarget = function(graph) {
    class Edge {
        constructor(src, dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Create adjacency list with Edge objects
    const g = graph.map((neighbors, i) => neighbors.map(j => new Edge(i, j)));

    const res = [];
    const v = Array(g.length).fill(false);

    const dfs = (curr, path) => {
        path.push(curr);
        if (curr === g.length - 1) {
            res.push([...path]); // add a copy of the current path
            path.pop();
            return;
        }

        for (const e of g[curr]) {
            if (!v[e.dest]) {
                v[curr] = true;
                dfs(e.dest, path);
                v[curr] = false;
            }
        }

        path.pop(); // backtrack
    };

    dfs(0, []);
    return res;
};
