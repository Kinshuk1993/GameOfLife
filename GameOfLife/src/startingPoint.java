/**
 * 
 */

/**
 * @author Kinshuk
 *
 */
public class startingPoint {
	// Variable to store the number of iterations done
	static int iterationCount = 0;
	// // variable to store the number of iterations to be done in the game
	// final static int TOTAL_ITERATIONS = 5;

	/**
	 * Main Class is the starting point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Fix the number of rows and columns in the matrix
		final int NUMBER_OF_ROWS = 6, NUMBER_OF_COLUMNS = 6;

		// matrix of 6 x 6
		int[][] matrix = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

		// Displaying the initial matrix
		printMatrix(matrix, NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);

		// // Loop till all iterations completed in the game
		// for (int iterationCounter = 0; iterationCounter <= TOTAL_ITERATIONS;
		// iterationCounter++) {
		// // perform the nextMatrixCycle step or the iteration
		// nextIteration(matrix, NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
		// }

		// perform the nextMatrixCycle step or the iteration
		nextIteration(matrix, NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
	}

	/**
	 * Function to go over the nextMatrixCycle steps in the game Static as it is
	 * directly called inside the main function without any object creation
	 * 
	 * @param matrix
	 * @param NUMBER_OF_ROWS
	 * @param NUMBER_OF_COLUMNS
	 */
	static void nextIteration(int matrix[][], int NUMBER_OF_ROWS, int NUMBER_OF_COLUMNS) {
		// variable to hold the matrix of original size of the matrix
		int[][] nextMatrixCycle = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

		/**
		 * Looping through each row cell of the matrix Starting from 1 as matrix[1][1]
		 * is first cell with neighbours (in first row) Going only till rows-1 as last
		 * cell with neighbours is matrix[#row-1][#col-1]
		 */
		for (int rowCellCounter = 1; rowCellCounter < NUMBER_OF_ROWS - 1; rowCellCounter++) {
			/**
			 * Loop to iterate through each column till all columns have been visited
			 * Starting from 1 as matrix[1][1] is first cell with neighbours (in first
			 * column) Going only till rows-1 as last cell with neighbours is
			 * matrix[#row-1][#col-1]
			 */
			for (int colVisitCounter = 1; colVisitCounter < NUMBER_OF_COLUMNS - 1; colVisitCounter++) {
				// Variable to store the number of live Neighbouring cells
				int liveNeighbourCells = 0;
				/**
				 * Loop to get column neighbour cell values
				 * Going only from -1 to 1 (0 to 2) as neighbours exists between 0 and 2 only
				 */
				for (int row = -1; row <= 1; row++)
					/**
					 * Loop to get row neighbour cell values
					 * Going only from -1 to 1 (0 to 2) as neighbours exists between 0 and 2 only
					 */
					for (int col = -1; col <= 1; col++)
						/**
						 * Add the matrix[x][y] cell value to live neighbour cell count
						 * where x = rowCellCounter + i, and y = colVisitCounter + j
						 * [x][y] ranges from [0][0] to [2][2], that is all neighbours
						 * Including the current cell as well
						 */
						liveNeighbourCells = liveNeighbourCells + matrix[rowCellCounter + row][colVisitCounter + col];

				// The current cell needs to be subtracted as it has been counted before already
				liveNeighbourCells = liveNeighbourCells - matrix[rowCellCounter][colVisitCounter];

				/**
				 * The live cell dies if either The number of neighbouring cells is less than 2
				 * for a live cell The number of neighbouring cells is more than 3 for a live
				 * cell
				 */
				if ((matrix[rowCellCounter][colVisitCounter] == 1)
						&& ((liveNeighbourCells < 2) || (liveNeighbourCells > 3))) {
					nextMatrixCycle[rowCellCounter][colVisitCounter] = 0;
				}
				// Dead cell becomes a live cell iff there are exactly 3 neighbouring cells
				// around it
				else if ((matrix[rowCellCounter][colVisitCounter] == 0) && (liveNeighbourCells == 3)) {
					nextMatrixCycle[rowCellCounter][colVisitCounter] = 1;
				}
				/**
				 * For any other condition, state of the cell does not change at all, and Just
				 * take the value from the original matrix and copy it as is
				 */
				else {
					nextMatrixCycle[rowCellCounter][colVisitCounter] = matrix[rowCellCounter][colVisitCounter];
				}
			}
		}

		// Print the matrix
		printMatrix(nextMatrixCycle, NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
	}

	/**
	 * Function to print the matrix on the console output Static as it is called
	 * inside static method
	 * 
	 * @param matrix
	 * @param NUMBER_OF_ROWS
	 * @param NUMBER_OF_COLUMNS
	 */
	public static void printMatrix(int[][] matrix, int NUMBER_OF_ROWS, int NUMBER_OF_COLUMNS) {
		// console for print matrix
		System.out.println("Printing the matrix: Iteration Number: " + iterationCount++);
		// outer loop to run through rows
		for (int rowCounter = 0; rowCounter < NUMBER_OF_ROWS; rowCounter++) {
			// inner loop to iterate through the columns
			for (int columnCounter = 0; columnCounter < NUMBER_OF_COLUMNS; columnCounter++) {
				/**
				 * Check the current cell value If the cell value is 1, then print a live cell
				 * In all other cases, console an "underline" (underscore) Underscore/Blank
				 * underline depicts a blank entry or a dead cell
				 */
				// for Alive Cell
				if (matrix[rowCounter][columnCounter] == 1) {
					// Print for live cell
					System.out.print("* ");
				}
				// for Dead cell
				else {
					// print for dead cell
					System.out.print("_ ");
				}
			}
			// go to the nextMatrixCycle line
			System.out.println("");
		}
		// Before performing the nextMatrixCycle iteration, break line
		System.out.println("");
	}
}
