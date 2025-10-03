class Solution {
    public int trapRainWater(int[][] heightMap) {
        /*
            -- We are given a 2D array of order m x n, representing the height of each unit cell in 2D elevation map.
            -- What is the criteria even that it can hold of water?
            -- So my initial idea is to use a nested for-loop starting from i = 1, j = 1 to i = m - 2, j = n - 2.
            -- from her we have to check minimum height of (up, down, right and left) of each cell.
            -- Ad then add that to the total.
        */

        // int volume = 0;

        // for (int i = 1; i < heightMap.length - 1; i++){
        //     for (int j = 1; j < heightMap[0].length - 1; j++){
        //         int up = heightMap[i - 1][j], down = heightMap[i + 1][j], right = heightMap[i][j + 1], left = heightMap[i][j - 1];
        //         volume += Math.min(Math.min(up, down), Math.min(right, left));
        //     }
        // }
        // return volume;

        /*
            -- That clearly was not the answer.
        */

        int m = heightMap.length;
        if (m == 0) return 0;
        int n = heightMap[0].length;
        if (n == 0) return 0;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // Add all boundary cells to pq
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int res = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1], h = cell[2];

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) continue;
                visited[nx][ny] = true;

                // If neighbor is lower, trap water
                res += Math.max(0, h - heightMap[nx][ny]);

                // Update boundary: water level is max of neighbor height and current boundary
                pq.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], h)});
            }
        }

        return res;
    }
}