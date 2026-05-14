class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;

        boolean[][] vis4 = new boolean[m][n];
        int ogColor = image[sr][sc];

        dfs (image, vis4, sr, sc, m, n, newColor, ogColor);

        return image;
    }

    private void dfs (int[][] img, boolean[][] v, int x, int y, int m, int n, int nC, int og) {
        if (x < 0 || y < 0 || x >= m || y >= n || img[x][y] != og || v[x][y]) return;

        v[x][y] = true;
        img[x][y] = nC;

        // Up.
        dfs (img, v, x - 1, y, m, n, nC, og);
        // Down.
        dfs (img, v, x + 1, y, m, n, nC, og);
        // right.
        dfs (img, v, x, y + 1, m, n, nC, og);
        // left.
        dfs (img, v, x, y - 1, m, n, nC, og);
    }
}