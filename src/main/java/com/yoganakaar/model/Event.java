package com.yoganakaar.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Event {

	@Id
	private String eventId;
	private String eventName;
	private String organizerName;
	private Integer playersPerTeam;
	private Integer matchesPerDay;
	private EventType eventType;
	private Integer teamsPerGroup;
	private List<Schedule> schedules = new ArrayList<>();

	private List<Team> teams = new ArrayList<>();

	public Event() {
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public Integer getPlayersPerTeam() {
		return playersPerTeam;
	}

	public void setPlayersPerTeam(Integer playersPerTeam) {
		this.playersPerTeam = playersPerTeam;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Integer getMatchesPerDay() {
		return matchesPerDay;
	}

	public void setMatchesPerDay(Integer matchesPerDay) {
		this.matchesPerDay = matchesPerDay;
	}

	public Integer getTeamsPerGroup() {
		return teamsPerGroup;
	}

	public void setTeamsPerGroup(Integer teamsPerGroup) {
		this.teamsPerGroup = teamsPerGroup;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", organizerName=" + organizerName
				+ ", playersPerTeam=" + playersPerTeam + ", matchesPerDay=" + matchesPerDay + ", eventType=" + eventType
				+ ", teamsPerGroup=" + teamsPerGroup + ", schedules=" + schedules + ", teams=" + teams + "]";
	}

}
