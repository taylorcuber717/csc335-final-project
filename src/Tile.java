import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Taylor McLaughlin
 * This represents a single tile in the board for the social deduction game.
 * Each tile can be a wall or regular tile, and if it is a regular tile it can have a task on it.
 * Each tile can also have any number of players on it.
 */
public class Tile implements Serializable {
	private int row; 
	private int col; 
	private boolean isWall;
	private boolean hasTask;
	private boolean isTaskCompleted = false;
	private ArrayList<Integer> players = new ArrayList<Integer>();
	
	
	public Tile(int row, int col, boolean isWall, boolean hasTask) {
		this.row = row;
		this.col = col;
		this.isWall = isWall;
		this.hasTask = hasTask;
	}
	
	
	public int getRow() { return row; }
	public int getColumn() { return col; }
	public boolean isWall() { return isWall; }
	public boolean hasTask() { return hasTask; }
	public boolean isTaskCompleted() { return isTaskCompleted; }
	
	/**
	 * Set hasTask as true
	 * 
	 */
	public void setTask() {
		this.hasTask = true;
	}
	
	/**
	 * Mark task as completed
	 * 
	 */
	public boolean completeTask() {
		if(this.hasTask) {
			this.isTaskCompleted = true;
		}
		return this.isTaskCompleted;
	}
}