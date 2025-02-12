package Recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        List<List<String>> ans = new ArrayList<>();

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, board, leftRow, upperDiagonal, lowerDiagonal, ans, n);

        // Print solutions
        for (List<String> solution : ans) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    private static void solve(int col, char[][] board, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(constructBoard(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[(n - 1) + col - row] == 0) {
                // Place the queen
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[(n - 1) + col - row] = 1;

                solve(col + 1, board, leftRow, upperDiagonal, lowerDiagonal, ans, n);

                // Backtrack
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[(n - 1) + col - row] = 0;
            }
        }
    }

    private static List<String> constructBoard(char[][] board) {
        List<String> boardRes = new ArrayList<>();
        for (char[] row : board) {
            boardRes.add(new String(row));
        }
        return boardRes;
    }
}
