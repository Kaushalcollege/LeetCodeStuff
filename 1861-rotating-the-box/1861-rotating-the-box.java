class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] res = new char[n][m];

        // First transpose the matrix.

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                res[y][x] = boxGrid[x][y];
            }
        }

        // Next reverse it.
        for (int x = 0; x < n; x++) {
            int l = 0, r = m - 1;

            while (l < r) {
                res[x][l] = (char)(res[x][l] ^ res[x][r]);
                res[x][r] = (char)(res[x][l] ^ res[x][r]);
                res[x][l] = (char)(res[x][l] ^ res[x][r]);
                l++;
                r--;
            }
        }

        // for (char[] a : res) System.out.println(Arrays.toString(a));
        // Lastly, do a move all zeros to the last approach.

        for (int x = 0; x < m; x++) {
            int e = n - 1;

            for (int y = n - 1; y >= 0; y--) {
                if (res[y][x] == '*') {
                    e = y - 1;
                } 
                else if (res[y][x] == '#') {
                    if (e != y) {
                        res[e][x] = (char)(res[e][x] ^ res[y][x]);
                        res[y][x] = (char)(res[e][x] ^ res[y][x]);
                        res[e][x] = (char)(res[e][x] ^ res[y][x]);
                    }
                    e--;
                }
            }
        }

        for (char[] a : res) System.out.println(Arrays.toString(a));

        // return new char[0][0];
        return res;
    }
}