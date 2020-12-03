import java.util.Observable;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Taylor McLaughlin
 * This class is the model of the minigames in our social deduction game.
 * Each minigame will be a small maze, this model represents that maze.
 */
public class MiniGameModel extends Observable {
	
	private Tile[][] board;
	final int BOARD_WIDTH = 20;
	final int BOARD_HEIGHT = 20;
	
	private ArrayList<Integer> mazeA = new ArrayList<>(
	        Arrays.asList(1,2,3)); // figure out board
//	private ArrayList<Integer> mazeB = new ArrayList<>(
//	        Arrays.asList(1,2,3));
//	private ArrayList<Integer> mazeC = new ArrayList<>(
//	        Arrays.asList(1,2,3));
//	private ArrayList<Integer> mazeD = new ArrayList<>(
//	        Arrays.asList(1,2,3));
//	private ArrayList<Integer> mazeE = new ArrayList<>(
//	        Arrays.asList(1,2,3));
//	private ArrayList<Integer> mazeF = new ArrayList<>(
//	        Arrays.asList(1,2,3));
	// add new mazes 
	
	/**
	 * This constructor generates a random number to select the maze and creates that maze
	 * 
	 */
	public MiniGameModel() {
		Random rand = new Random();
		int mazeRandom = rand.nextInt(6);
		createBoard(mazeRandom);
	}
	
	/**
	 * This function creates the maze, building it from one of (((6))) pre-designed mazes.  
	 * Each maze array contains the locations of the walls in the maze.
	 * 
	 */
	public void createBoard(int mazeNumber) {
		ArrayList<Integer> maze = null;
		switch(mazeNumber) {
		case 1:
			maze = mazeA;
//		case 2:
//			maze = mazeB;
//		case 3:
//			maze = mazeC;
//		case 4:
//			maze = mazeD;
//		case 5:
//			maze = mazeE;
//		case 6:
//			maze = mazeF;
		default:
			System.out.println("invalid maze selected");
		}
		
		for(int column = 0; column < BOARD_WIDTH; column++) {
			for(int row = 0; row < BOARD_HEIGHT; row++) {
				if(maze.contains(column * BOARD_WIDTH + row)) {
					board[column][row] = new Tile(row, column, true, false);
				} else {
					board[column][row] = new Tile(row, column, false, false);
				}
			}
		}
		
	}
	
}