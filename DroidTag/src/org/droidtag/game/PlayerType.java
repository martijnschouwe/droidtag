package org.droidtag.game;


/**
 * @author mschouwe
 * PlayerType enum for all types a player can be in a game
 */
public enum PlayerType {

	RIFLEMAN(1),
	SUPPORT(2),
	DEMOLITIONS(3),
	SNIPER(4);
	
	int id;
	
	private PlayerType(int id) {
		this.id = id;
	}
	
	
}
