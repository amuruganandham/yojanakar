package com.yoganakaar.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Team {

	@Id
	private String teamId;
	private String teamName;
	private Double yeti;

	private List<Player> players = new ArrayList<>();

	public Team() {
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Double getYeti() {
		return yeti;
	}

	public void setYeti(Double yeti) {
		this.yeti = yeti;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", yeti=" + yeti + ", players=" + players + "]";
	}

}
