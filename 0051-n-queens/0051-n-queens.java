import java.util.*;

class Solution {

    List<String> t = new ArrayList<>();
    List<List<String>> sol = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        f(0, board);
        return sol;
    }

    private void f(int row, boolean[][] b) {
        if (row == b.length) {
            sol.add(new ArrayList<>(t)); // IMPORTANT: copy
            return;
        }

        for (int col = 0; col < b.length; col++) {
            if (safe(b, row, col)) {
                b[row][col] = true;

                // build exactly ONE row string
                StringBuilder rowStr = new StringBuilder();
                for (int j = 0; j < b.length; j++) {
                    rowStr.append(j == col ? 'Q' : '.');
                }

                t.add(rowStr.toString());
                f(row + 1, b);
                t.remove(t.size() - 1); // backtrack

                b[row][col] = false;
            }
        }
    }

    private boolean safe(boolean[][] b, int row, int col) {
        // vertical
        for (int i = 0; i < row; i++) {
            if (b[i][col]) return false;
        }

        // left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (b[i][j]) return false;
        }

        // right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < b.length; i--, j++) {
            if (b[i][j]) return false;
        }

        return true;
    }
}
