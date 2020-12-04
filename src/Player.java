

/**
 * @author Taylor McLaughlin
 * This models one of the players in the game. 
 * Each player will have certain stats and other information such as what team they are on.
 */
public class Player {
	
	private int tasksCompleted = 0;
	private int tilesWalked = 0;
	private int timesShuffled = 0; // Maybe changed this
	private boolean isImposter = false;
	private int playerColor; // this number should be converted into a color in view
	private int row;
	private int col;
	private int identity;
	
	/**
	 * This constructor saves what team the player is on and what their color is
	 * 
	 */
	public Player(boolean isImposter, int playerNumber, int row, int col, int identity) {
		this.isImposter = isImposter;
		this.playerColor = playerNumber;
		this.row = row;
		this.col = col;
		this.identity = identity;
	}
	
	public int getTasksCompleted() { return tasksCompleted; }
	public int getTilesWalked() { return tilesWalked; }
	public int getTimesShuffled() { return timesShuffled; }
	public boolean isImposter() { return isImposter; }
	public int getColor() { return playerColor; }
	public int getRow() { return row; }
	public int getCol() { return col; }
	public int getIdentity() { return identity; }
	
	public void incrementTasksCompleted() {
		this.tasksCompleted++;
	}
	
	public void incrementTilesWalked() {
		this.tilesWalked++;
	}
	
	public void incrementTimesShuffled() {
		this.timesShuffled++;
	}
	
	public void updateRow(int amount) {
		this.row = row + amount;
	}
	
	public void updateCol(int amount) {
		this.col = col + amount;
	}
	
}