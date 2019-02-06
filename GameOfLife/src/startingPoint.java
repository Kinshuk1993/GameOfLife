/**
 * 
 */

/**
 * @author Kinshuk
 *
 */
public class startingPoint {

	/**
	 * Main Class acting as the starting point
	 * @param args
	 */
	public static void main(String[] args) {
		int numberOfRows = 6, numberOfColumns = 6;

		// matrix of 6 x 6
		int[][] matrix = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

		// Displaying the matrix
		System.out.println("Printing the initial configuration of the matrix");
		// outer loop to run through rows
		for (int rowCounter = 0; rowCounter < numberOfRows; rowCounter++) {
			// inner loop to iterate through the columns
			for (int columnCounter = 0; columnCounter < numberOfColumns; columnCounter++) {
				/**
				 * Check the current cell value If the cell value is 1, then print a live cell
				 * In all other cases, console an "underline" (underscore) Underscore/Blank
				 * underline depicts a blank entry or a dead cell
				 */
				// for Alive Cell
				if (matrix[rowCounter][columnCounter] == 1) {
					// Print for live cell
					System.out.print("*");
				}
				// for Dead cell
				else {
					// print for dead cell
					System.out.print("_");
				}
			}
			// go to the next line
			System.out.println("");
		}
		// Before performing the next iteration, print 2 blank lines
		System.out.println("\n\r");

		// TO DO: REMOVE THIS CONSOLE
		System.out.println("Checking the line breaks");
	}
}
