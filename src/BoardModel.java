import java.util.Observable;
import java.util.Random;

/**
 * @author Taylor McLaughlin
 * This class is the model of this MVC some kind of social deduction game.
 */
public class BoardModel extends Observable{
	
	private Tile[][] board;
	final int BOARD_WIDTH = 20;
	final int BOARD_HEIGHT = 20;
	private int tasksLeft = 6;  // change this to percentage of total tiles
	private int tasksCompleted = 0;
	
	/**
	 * This constructor creates the board.
	 * 
	 */
	public BoardModel() {
		createBoard();
	}
	
	/**
	 * This function creates the board containing an n x m number of tiles (where n and m are given by the user).
	 * Each space has a 30% chance to be a wall, and a ~5% chance of having a tasks on it (assuming it is not a wall).
	 * The tasks are randomly assigned to different tiles.  The tasksCompleted variable is used in case the (((bad team)))
	 * shuffles the board, if the (((good team))) has already completed tasks we want these tasks to stay completed on
	 * the new shuffled board.
	 * 
	 */
	private void createBoard() {
		// initialize n x m board
		board = new Tile[BOARD_WIDTH][BOARD_HEIGHT];
		Random rand = new Random();
		
		// create n x m number of tiles, with each tile either being wall or normal tile
		for(int column = 0; column < BOARD_WIDTH; column++) {
			for(int row = 0; row < BOARD_HEIGHT; row++) {
				int wallRandom = rand.nextInt(100);
				if(wallRandom <= 30) {
					board[column][row] = new Tile(row, column, true, false);
				} else {
					board[column][row] = new Tile(row, column, false, false);
				}
			}
		}
		
		// randomly assign all of the tasks to randomly selected tiles, and make sure that completed tasks stay completed
		int currentTasks = tasksCompleted;
		while(tasksLeft > 0) {
			int columnRandom = rand.nextInt(BOARD_WIDTH);
			int rowRandom = rand.nextInt(BOARD_HEIGHT);
			if(board[rowRandom][columnRandom].isWall() == false) {
				board[rowRandom][columnRandom].setTask();
				tasksLeft--;
				if(currentTasks > 0) {
					boolean success = board[rowRandom][columnRandom].completeTask();
					if(success) {
						currentTasks--;
					}
				}
			}
		}
	}
	
	/**
	 * Shuffles the board.
	 * 
	 */
	public void shuffleBoard() {
		createBoard();
	}
	
	public Tile getTile(int row, int col) {
		return board[col][row];
	}
	
	/**
	 * This function removes a player from a given tile
	 * 
	 * @param row - the row of the tile where the player will be removed
	 * @param col - the column of the tile where the player will be removed
	 * @param playerNumber - the identity of the player that will be removed
	 * 
	 */
	public void removedPlayer(int row, int col, int playerNumber) {
		board[col][row].removePlayer(playerNumber);
	}
	
	/**
	 * This function adds a player to a given tile
	 * 
	 * @param row - the row of the tile where the player will be added
	 * @param col - the column of the tile where the player will be added
	 * @param playerNumber - the identity of the player that will be added
	 * 
	 */
	public void addPlayer(int row, int col, int playerNumber) {
		board[col][row].addPlayer(playerNumber);
	}
	
	
	
	
	
}