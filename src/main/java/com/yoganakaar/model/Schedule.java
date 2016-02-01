package com.yoganakaar.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Schedule {

	@Id
	private String scheduleId;
	private Integer stage;
	private Integer day;
	private Integer matchNumber;
	private List<String> teamIds = new ArrayList<>();

	public Schedule() {
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Integer getStage() {
		return stage;
	}

	public void setStage(Integer stage) {
		this.stage = stage;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getMatchNumber() {
		return matchNumber;
	}

	public void setMatchNumber(Integer matchNumber) {
		this.matchNumber = matchNumber;
	}

	public List<String> getTeamIds() {
		return teamIds;
	}

	public void setTeamIds(List<String> teamIds) {
		this.teamIds = teamIds;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", stage=" + stage + ", day=" + day + ", matchNumber="
				+ matchNumber + ", teamIds=" + teamIds + "]";
	}

}
