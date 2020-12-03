

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
	
	/**
	 * This constructor saves what team the player is on and what their color is
	 * 
	 */
	public Player(boolean isImposter, int playerNumber) {
		this.isImposter = isImposter;
		this.playerColor = playerNumber;
	}
	
	public int getTasksCompleted() { return tasksCompleted; }
	public int getTilesWalked() { return tilesWalked; }
	public int getTimesShuffled() { return timesShuffled; }
	public boolean isImposter() { return isImposter; }
	public int getColor() { return playerColor; }
	
	public void incrementTasksCompleted() {
		this.tasksCompleted++;
	}
	
	public void incrementTilesWalked() {
		this.tilesWalked++;
	}
	
	public void incrementTimesShuffled() {
		this.timesShuffled++;
	}
	
}