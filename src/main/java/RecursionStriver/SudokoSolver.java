package RecursionStriver;

public class SudokoSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solve(board);

        for (int i = 0; i < board.length; i++) {         // Loop through each row
            for (int j = 0; j < board[i].length; j++) {    // Loop through each column in the row
                System.out.print(board[i][j] + " ");       // Print the character followed by a space
            }
            System.out.println();                          // Newline after each row
        }

    }

    private static boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if(board[i][j] == '.')
                {
                    for (char k = 0; k < 9; k++) {

                        if(isValid(board, i, j, k))
                            return true;
                        else
                            board[i][j] ='.';

                    }
                    return false;
                }

            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char k) {
        for (int i = 0; i < 9; i++) {


            if (board[i][col] == k || board[row][i]==k)
                return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==k)
                return false;

        }
        return true;

    }
}
