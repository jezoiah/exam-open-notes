// ==== 2D ARRAYS (MATRICES) ====
// WHAT: Array of arrays - rows and columns
// WHEN: Grids, tables, matrices, game boards
// HOW: Type[][] name = new Type[rows][cols];

public class TwoDimArrays {
    public static void main(String[] args) {
        
        // ==== DECLARATION AND INITIALIZATION ====
        // WHAT: Create grid with fixed dimensions
        // WHEN: Known size grid needed
        // HOW: new Type[rows][columns]
        
        int[][] matrix = new int[3][4];  // 3 rows, 4 columns
        
        // ==== INITIALIZE WITH VALUES ====
        int[][] grid = {
            {1, 2, 3, 4},      // row 0
            {5, 6, 7, 8},      // row 1
            {9, 10, 11, 12}    // row 2
        };
        
        // ==== ACCESS ELEMENTS ====
        // WHAT: Get/set value at specific row, column
        // WHEN: Access grid position
        // HOW: array[row][column] (0-indexed)
        
        int element = grid[1][2];  // row 1, col 2 = 7
        System.out.println("grid[1][2] = " + element);
        
        grid[0][0] = 100;  // Modify top-left
        System.out.println("After change: grid[0][0] = " + grid[0][0]);
        
        // ==== GET DIMENSIONS ====
        // WHAT: Number of rows and columns
        // WHEN: Loop bounds
        // HOW: array.length (rows), array[0].length (cols)
        
        int rows = grid.length;           // 3
        int cols = grid[0].length;        // 4 (assumes rectangular)
        
        System.out.println("\nDimensions: " + rows + " x " + cols);
        
        // ==== TRAVERSE WITH NESTED LOOPS ====
        // WHAT: Visit every element
        // WHEN: Process entire grid
        // HOW: outer loop rows, inner loop columns
        
        System.out.println("\n=== Grid Contents ===");
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + "\t");
            }
            System.out.println();  // New line after each row
        }
        
        // ==== ROW-MAJOR vs COLUMN-MAJOR ====
        // Row-major: traverse across row, then down (normal)
        // Column-major: traverse down column, then across
        
        System.out.println("\n=== Column by Column ===");
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
        
        // ==== JAGGED ARRAYS ====
        // WHAT: Rows can have different lengths
        // WHEN: Triangular data, varying row sizes
        // HOW: new int[rows][] then each row separately
        
        int[][] jagged = new int[3][];
        jagged[0] = new int[2];  // row 0 has 2 elements
        jagged[1] = new int[4];  // row 1 has 4 elements
        jagged[2] = new int[3];  // row 2 has 3 elements
        
        System.out.println("\n=== Jagged Array ===");
        for (int r = 0; r < jagged.length; r++) {
            System.out.print("Row " + r + " (" + jagged[r].length + " elements): ");
            for (int c = 0; c < jagged[r].length; c++) {
                System.out.print(jagged[r][c] + " ");
            }
            System.out.println();
        }
        
        // ==== SUM ALL ELEMENTS ====
        int total = 0;
        for (int[] row : grid) {
            for (int val : row) {
                total += val;
            }
        }
        System.out.println("\nSum of all elements: " + total);
        
        // ==== ROW SUMS ====
        System.out.println("\n=== Row Sums ===");
        for (int r = 0; r < grid.length; r++) {
            int rowSum = 0;
            for (int c = 0; c < grid[r].length; c++) {
                rowSum += grid[r][c];
            }
            System.out.println("Row " + r + " sum: " + rowSum);
        }
        
        // ==== COLUMN SUMS ====
        System.out.println("\n=== Column Sums ===");
        for (int c = 0; c < grid[0].length; c++) {
            int colSum = 0;
            for (int r = 0; r < grid.length; r++) {
                colSum += grid[r][c];
            }
            System.out.println("Col " + c + " sum: " + colSum);
        }
        
        // ==== FIND MAX ELEMENT ====
        int max = grid[0][0];
        int maxRow = 0, maxCol = 0;
        
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] > max) {
                    max = grid[r][c];
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
        System.out.println("\nMax value: " + max + " at [" + maxRow + "][" + maxCol + "]");
        
        // ==== DIAGONAL (SQUARE MATRIX ONLY) ====
        System.out.println("\n=== Main Diagonal ===");
        for (int i = 0; i < grid.length && i < grid[0].length; i++) {
            System.out.print(grid[i][i] + " ");
        }
        
        // ==== TRANSPOSE (rows become columns) ====
        // New matrix with swapped dimensions
        int[][] transpose = new int[grid[0].length][grid.length];
        
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                transpose[c][r] = grid[r][c];
            }
        }
        
        System.out.println("\n\n=== Transposed Matrix ===");
        for (int r = 0; r < transpose.length; r++) {
            for (int c = 0; c < transpose[r].length; c++) {
                System.out.print(transpose[r][c] + "\t");
            }
            System.out.println();
        }
        
        // ==== STRING 2D ARRAY ====
        String[][] seating = {
            {"Alice", "Bob", "Carol"},
            {"David", "Emma", "Frank"},
            {"Grace", "Henry", "Ivy"}
        };
        
        System.out.println("\n=== Seating Chart ===");
        for (int r = 0; r < seating.length; r++) {
            System.out.print("Row " + r + ": ");
            for (int c = 0; c < seating[r].length; c++) {
                System.out.print(seating[r][c] + " ");
            }
            System.out.println();
        }
        
        // ==== SEARCH IN 2D ARRAY ====
        String target = "Emma";
        boolean found = false;
        int foundRow = -1, foundCol = -1;
        
        for (int r = 0; r < seating.length && !found; r++) {
            for (int c = 0; c < seating[r].length; c++) {
                if (seating[r][c].equals(target)) {
                    found = true;
                    foundRow = r;
                    foundCol = c;
                    break;
                }
            }
        }
        
        if (found) {
            System.out.println("\nFound " + target + " at [" + foundRow + "][" + foundCol + "]");
        }
        
        // ==== INITIALIZE WITH LOOPS ====
        int[][] multiplication = new int[5][5];
        for (int r = 0; r < multiplication.length; r++) {
            for (int c = 0; c < multiplication[r].length; c++) {
                multiplication[r][c] = (r + 1) * (c + 1);
            }
        }
        
        System.out.println("\n=== Multiplication Table (1-5) ===");
        for (int r = 0; r < multiplication.length; r++) {
            for (int c = 0; c < multiplication[r].length; c++) {
                System.out.printf("%2d ", multiplication[r][c]);
            }
            System.out.println();
        }
    }
}
