package org.droidtag.game;

import java.util.List;

public class Game {

	private GameType gameType;
	private List<Team> teams;
	
	public Game() {
	}
	
	public GameType getGameType() {
		return gameType;
	}
	
	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}
	
	public List<Team> getTeams() {
		return teams;
	}
	
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}
