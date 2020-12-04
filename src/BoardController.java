import java.util.Observable;

public class BoardController {
	
	private BoardModel model;

	public BoardController(BoardModel model) {
		this.model = model;
	}
	
	/**
	 * This function moves a player from one tile to an adjacent one on the board.
	 * It first checks which direction the player wants to move, then it verifies that it is a valid
	 * move.  Then it moves the given player.
	 * 
	 * @param player - the player that is going to move
	 * @param direction - the direction that the player wants to move
	 * 
	 */
	public void movePlayer(Player player, int direction) {
		if(direction == 0) { // player wants to move left
			// check that the move would not put the player outside of the board and that the tile the player is moving to 
			// is not a wall
			if(player.getCol() > 0 && model.getTile(player.getRow(), player.getCol() - 1).isWall() == false) {  
				model.removedPlayer(player.getRow(), player.getCol(), player.getIdentity());
				player.updateCol(-1);
				model.addPlayer(player.getRow(), player.getCol(), player.getIdentity());
			}
		} else if(direction == 1) { // player wants to move up
			if(player.getRow() < model.BOARD_HEIGHT - 1 && model.getTile(player.getRow() + 1, player.getCol()).isWall() == false) {  
				model.removedPlayer(player.getRow(), player.getCol(), player.getIdentity());
				player.updateRow(1);
				model.addPlayer(player.getRow(), player.getCol(), player.getIdentity());
			}
		} else if(direction == 2) { // player wants to move right
			if(player.getCol() < model.BOARD_WIDTH - 1 && model.getTile(player.getRow(), player.getCol() + 1).isWall() == false) {  
				model.removedPlayer(player.getRow(), player.getCol(), player.getIdentity());
				player.updateCol(1);
				model.addPlayer(player.getRow(), player.getCol(), player.getIdentity());
			}
		} else if(direction == 3) { // player wants to move down
			if(player.getRow() > 0 && model.getTile(player.getRow() - 1, player.getCol()).isWall() == false) {  
				model.removedPlayer(player.getRow(), player.getCol(), player.getIdentity());
				player.updateRow(-1);
				model.addPlayer(player.getRow(), player.getCol(), player.getIdentity());
			}
		}
	}
	
}