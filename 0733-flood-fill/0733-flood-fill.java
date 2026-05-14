class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;

        boolean[][] vis4 = new boolean[m][n];
        int ogColor = image[sr][sc];

        bfs (image, vis4, sr, sc, m, n, newColor, ogColor);

        return image;
    }

    private void bfs (int[][] img, boolean[][] v, int x, int y, int m, int n, int nC, int og) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});
        v[x][y] = true;
        img[x][y] = nC;

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nc >= 0 && nr >= 0 && nc < n && nr < m && img[nr][nc] == og && !v[nr][nc]) {
                    v[nr][nc] = true;
                    img[nr][nc] = nC;
                    q.add(new int[]{nr, nc});
                }
            }
        }

    }
}