class Solution {
    // A helper class to store a cell's coordinates and its height.
    // We need this to add cells to the Priority Queue.
    // It implements Comparable to make the Priority Queue a Min-Heap based on height.
    class Cell implements Comparable<Cell> {
        int row;
        int col;
        int height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public int compareTo(Cell other) {
            return this.height - other.height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        /*
            -- We are given a 2D array of order m x n, representing the height of each unit cell in 2D elevation map.
            -- What is the criteria even that it can hold of water?
            -- So my initial idea is to use a nested for-loop starting from i = 1, j = 1 to i = m - 2, j = n - 2.
            -- from her we have to check minimum height of (up, down, right and left) of each cell.
            -- And then add that to the total.

            -- But that will not work.
            -- Instead we will be working with diamonds.
            -- let us work with example 1: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
            -- It looks something like this: -
            --      1   4   3   1   3   2

                    3   2   1   3   2   4

                    2   3   3   2   3   1

            -- The diamonds are :-
            --      1   4   3   1   3   2           4               3               3

                    3   2   1   3   2   4 ==>   3   2   1   ,   2   1   3   ,   3   2   4
    
                    2   3   3   2   3   1           3               3               3


            -- In the diamond 1, the highest height is 4 and lowest is 1. and volCount = 0.
            -- But the mid - point of the diamond is 2, so this diamond will not be filled first.
            -- In diamond 2, the difference between the mid-point and min of all four sides is 1, so volCount += 1.
            -- the mid-point will be updated to 2. so new diamond 2:
            --          3
                    2   2   3
                        3
            -- In diamond 3, the difference between the mid-point and min of all four sides is 1, so volCount += 1.
            -- the mid-point will be updated to 3. so new diamond 3:
            --          3
                    3   3   4
                        3
            -- Coming back to diamond 2 and 1, volCount += 2.

        */
        // Handle edge cases where trapping water is impossible.
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        
        // Use a Priority Queue to always process the cell with the minimum height on the boundary.
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        
        // A 'visited' matrix to avoid reprocessing cells.
        boolean[][] visited = new boolean[m][n];
        
        // 1. Start with the "sea wall": Add all border cells to the Priority Queue.
        // Water can't be trapped on the border, it just flows off the map.
        // These cells are the initial boundary.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    visited[i][j] = true;
                    pq.offer(new Cell(i, j, heightMap[i][j]));
                }
            }
        }
        
        int totalWater = 0;
        
        // Directions for exploring neighbors (Up, Down, Left, Right)
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 2. Process cells, always starting from the lowest point on our current "wall".
        while (!pq.isEmpty()) {
            // Get the cell with the minimum height from our current boundary.
            Cell current = pq.poll();
            
            // Explore its unvisited neighbors.
            for (int[] dir : dirs) {
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];

                // Check if the neighbor is within bounds and not visited yet.
                if (newRow > 0 && newRow < m - 1 && newCol > 0 && newCol < n - 1 && !visited[newRow][newCol]) {
                    
                    visited[newRow][newCol] = true; // Mark as visited.

                    // 3. Calculate trapped water.
                    // The `current.height` acts as the wall height for the new cell.
                    // If the new cell is lower than the wall, it traps water.
                    int trappedWater = Math.max(0, current.height - heightMap[newRow][newCol]);
                    totalWater += trappedWater;
                    
                    // 4. Add the new cell to the boundary (the Priority Queue).
                    // Its effective height for holding back more water is its own height,
                    // or the height of the wall that just contained it, whichever is greater.
                    pq.offer(new Cell(newRow, newCol, Math.max(heightMap[newRow][newCol], current.height)));
                }
            }
        }
        
        return totalWater;
    }
}