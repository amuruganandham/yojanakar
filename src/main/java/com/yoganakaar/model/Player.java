package com.yoganakaar.model;

import org.springframework.data.annotation.Id;

public class Player {

	@Id
	private String playerId;
	private String companyId;
	private String playerName;
	private Double expertiseLevel;
	private Double experienceLevel;
	private Double popularityLevel;
	private Double fitnessLevel;
	private Long personalNumber;

	public Player() {
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Double getExpertiseLevel() {
		return expertiseLevel;
	}

	public void setExpertiseLevel(Double expertiseLevel) {
		this.expertiseLevel = expertiseLevel;
	}

	public Double getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(Double experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public Double getPopularityLevel() {
		return popularityLevel;
	}

	public void setPopularityLevel(Double popularityLevel) {
		this.popularityLevel = popularityLevel;
	}

	public Double getFitnessLevel() {
		return fitnessLevel;
	}

	public void setFitnessLevel(Double fitnessLevel) {
		this.fitnessLevel = fitnessLevel;
	}

	public Long getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(Long personalNumber) {
		this.personalNumber = personalNumber;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", companyId=" + companyId
				+ ", playerName=" + playerName + ", expertiseLevel="
				+ expertiseLevel + ", experienceLevel=" + experienceLevel
				+ ", popularityLevel=" + popularityLevel + ", fitnessLevel="
				+ fitnessLevel + ", personalNumber=" + personalNumber + "]";
	}

}
