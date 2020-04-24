import static java.lang.System.*;

public class GameOfLife {
    public static int[][] grid;
    public static int rows;
    public static int columns;

    public static void main(String[] args) {
        GameOfLife  grid = new GameOfLife();
        int[][] currentGen = grid.currentGen();
        int[][] nextGen = grid.nextGen();
        out.println("Current Generation");
        printResults(currentGen);
        out.print("\n");
        out.println("Next Generation");
        printResults(nextGen);
    }

    private static void printResults(int[][] results) {
        for (int[] result : results) {
            for (int i : result) {
                if (i == 0) {
                    out.print ("+"); //Dead Cell
                } else {
                    out.print ("#"); //Live Cell
                }
            }
            out.println ( );
        }
    }

    // Constructor creates a state of the grid with random values
    public GameOfLife() {
        int height = 10;
        int width = 10;
        grid = new int[width][height];
        for (int i = 0; i< width; i++) {
            for (int j = 0; j< height; j++) {
                grid[i][j] = (int) Math.round(Math.random());
            }
        }
        rows = grid.length;
        columns = grid[0].length;
    }

    //Returns the current generation
    public static int[][] currentGen() {
        return grid;    // return Returns two dimensional array representing current state
    }

    //Returns the next generation
    public static int[][] nextGen() {
        int[][] futureGen = new int[grid.length][grid[0].length];
        int rows = grid.length;
        int columns = grid[0].length;

        // iterate through two dimensional array
        for (int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                futureGen[i][j] = getNextState(i,j);
            }
        }
        return futureGen;  // return Returns two dimensional array representing next state
    }

  /** i == Row index of the grid
   * j == Column index of the grid
   * Gets next state for a particular cell.
   * Get living neighbors.
   * If any live cell with fewer than two live neighbors dies and return 0 if cell is dead.
   * If any live cell with two live neighbors lives on to the next generation then return 1 if cell is alive.
   * If any live cell with more than three live neighbors dies then return 0 if cell is dead.
   * Cell is dead but 3 lives neighbors causes it to be born and return 1 if cell is alive.
   */
    public static int getNextState(int i, int j) {
        int liveNeighbors = calculateLivingNeighbors (i, j);

        if ((grid[i][j] == 1) && (liveNeighbors < 2)) {
            return  0;
        }
        else if ((grid[i][j] == 1)  && liveNeighbors == 2) {
            return  1;
        }
        else if ((grid[i][j] == 1) && liveNeighbors > 3) {
            return  0;
        }
        else if (grid[i][j] == 0 && liveNeighbors == 3) {
            return  1;
        }
        else {
            return grid[i][j];
        }
    }

   /** i == Row index of the grid
     * j == Column index of the grid
     * Returns the count of living neighbors for a particular cell in the grid.
     * Checks for boundary conditions.
     * Then remove after counting.
    */
    public static int calculateLivingNeighbors(int i, int j) {
        int liveCount = 0;
        for (int x=-1; x<=1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (i + x < 0 || i + x > rows - 1 || y + j < 0 || y + j > (columns - 1)) {
                    continue;
                }
                liveCount += grid[i + x][y + j];
            }
        }
        liveCount -= grid[i][j];
        return liveCount;
    }
}