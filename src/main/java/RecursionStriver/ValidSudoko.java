package RecursionStriver;

public class ValidSudoko {

    // Checks if the given board is a valid Sudoku board
    public boolean isValidSudoku(char[][] board) {
        // Check each row for duplicates.
        for (int row = 0; row < 9; row++) {
            boolean[] seen = new boolean[10]; // Index 1-9 used for digits.
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c != '.') { // Only process filled cells.
                    int num = c - '0'; // Convert char digit to integer.
                    if (seen[num]) {
                        return false; // Duplicate found in the row.
                    }
                    seen[num] = true;
                }
            }
        }

        // Check each column for duplicates.
        for (int col = 0; col < 9; col++) {
            boolean[] seen = new boolean[10];
            for (int row = 0; row < 9; row++) {
                char c = board[row][col];
                if (c != '.') {
                    int num = c - '0';
                    if (seen[num]) {
                        return false; // Duplicate found in the column.
                    }
                    seen[num] = true;
                }
            }
        }

        // Check each 3x3 sub-box for duplicates.
        // There are 9 sub-boxes; block index 0 to 8.
        for (int block = 0; block < 9; block++) {
            boolean[] seen = new boolean[10];
            // Calculate starting row and column for this block.
            int boxRowStart = 3 * (block / 3);
            int boxColStart = 3 * (block % 3);
            for (int i = 0; i < 3; i++) {         // Loop through rows within the block.
                for (int j = 0; j < 3; j++) {     // Loop through columns within the block.
                    char c = board[boxRowStart + i][boxColStart + j];
                    if (c != '.') {
                        int num = c - '0';
                        if (seen[num]) {
                            return false; // Duplicate found in the sub-box.
                        }
                        seen[num] = true;
                    }
                }
            }
        }
        return true; // If no duplicates are found, the board is valid.
    }

    // For testing the validity of a board.
    public static <ValidSudokuChecker> void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '1', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '1', '7', '9'}
        };

        ValidSudoko checker = new ValidSudoko();
        boolean valid = checker.isValidSudoku(board);
        System.out.println("The board is " + (valid ? "valid" : "invalid") + ".");
    }
}
