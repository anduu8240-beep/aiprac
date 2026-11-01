
public class SudokuSolver {

    static int[][] sudoku = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    // Check whether a number can be placed
    static boolean isSafe(int row, int col, int num) {

        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == num ||
                sudoku[i][col] == num)
                return false;
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[startRow + i][startCol + j] == num)
                    return false;
            }
        }

        return true;
    }

    // Solve Sudoku using Backtracking
    static boolean solve() {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (sudoku[row][col] == 0) {

                    for (int num = 1; num <= 9; num++) {

                        if (isSafe(row, col, num)) {

                            sudoku[row][col] = num;

                            if (solve())
                                return true;

                            // Backtrack
                            sudoku[row][col] = 0;
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    // Display Sudoku
    static void printSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("Original Sudoku:");
        printSudoku();

        if (solve()) {
            System.out.println("\nSolved Sudoku:");
            printSudoku();
        } else {
            System.out.println("No solution exists!");
        }
    }
}