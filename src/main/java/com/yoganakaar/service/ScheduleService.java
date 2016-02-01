package com.yoganakaar.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoganakaar.dao.TournamentRepository;
import com.yoganakaar.model.Event;
import com.yoganakaar.model.EventType;
import com.yoganakaar.model.Schedule;
import com.yoganakaar.model.Team;
import com.yoganakaar.model.Tournament;
import com.yoganakaar.util.TeamIndexCalulator;

@Service
public class ScheduleService {

	@Autowired
	private TournamentRepository tournamentRepository;

	private static Logger logger = Logger.getLogger(ScheduleService.class);

	private Integer stage = 1;
	private Integer day = 1;
	private Integer match = 1;

	public Event getScheduledTournament(String tournamentid, String eventId) {

		logger.debug("getScheduledTournament() :: " + tournamentid);
		Tournament tournament = tournamentRepository.findOne(tournamentid);
		return scheduleEvent(tournament.getEvents().stream()
				.filter(event -> event.getEventId().equalsIgnoreCase(eventId))
				.findFirst().get());
	}

	private Event scheduleEvent(Event event) {

		event.getTeams().forEach(
				team -> team.setYeti(TeamIndexCalulator.findTeamIndex(team)));

		Comparator<Team> teamIndexComparator = (team1, team2) -> Double
				.compare(team2.getYeti(), team1.getYeti());

		Comparator<Schedule> scheduleComparator = (schedule1, schedule2) -> schedule2
				.getScheduleId().compareTo(schedule1.getScheduleId());

		event.setTeams(event.getTeams().stream().sorted(teamIndexComparator)
				.collect(Collectors.toList()));

		if (!event.getEventType().equals(EventType.KnockOut)) {
			event = scheduleKnockOuts(event);
			event.setSchedules(event.getSchedules().stream()
					.sorted(scheduleComparator).collect(Collectors.toList()));
		} else
			event = scheduleGroupStage(event);

		return event;
	}

	private Event scheduleKnockOuts(Event event) {

		for (int i = 0; i < event.getTeams().size() / 2; i++) {

			Schedule schedule = new Schedule();
			schedule.setScheduleId("S" + stage + day + match);
			schedule.setStage(stage);
			schedule.setDay(day);
			schedule.setMatchNumber(match);
			schedule.getTeamIds().add(event.getTeams().get(i).getTeamId());

			if (event.getTeams().size() % 2 == 0) {
				schedule.getTeamIds().add(
						event.getTeams().get(i + event.getTeams().size() / 2)
								.getTeamId());
			} else {
				schedule.getTeamIds().add(
						event.getTeams()
								.get(i + event.getTeams().size() / 2 + 1)
								.getTeamId());
			}
			event.getSchedules().add(schedule);

			if (event.getMatchesPerDay() == match) {
				day++;
				match = 1;
			} else {
				match++;
			}
		}
		if (event.getTeams().size() % 2 != 0) {
			Schedule schedule = new Schedule();
			schedule.setScheduleId("S" + stage + "00");
			schedule.setStage(stage);
			schedule.setDay(0);
			schedule.setMatchNumber(0);
			schedule.getTeamIds().add(
					event.getTeams().get(event.getTeams().size() / 2)
							.getTeamId());
			event.getSchedules().add(schedule);
		}
		return event;
	}

	private static Event scheduleGroupStage(Event event) {
		logger.debug(event);
		if (event.getTeams().size() % event.getTeamsPerGroup() != 0)
			throw new IllegalArgumentException("Not able to Group teams");

		Integer teamCount = event.getTeams().size();
		Integer groupCount = event.getTeams().size() / event.getTeamsPerGroup();
		Integer day = 1;
		Integer match = 1;
		List<Team> teams = null;
		List<Schedule> schedules = new ArrayList<>();
		HashMap<String, List<Team>> group = new HashMap<String, List<Team>>();
		for (int i = 0; i < groupCount; i++) {
			String groupId = "group" + i;
			teams = new ArrayList<>();
			for (int j = i; j < teamCount; j += groupCount) {
				teams.add(event.getTeams().get(j));
				logger.debug(event.getTeams().get(j));
			}
			logger.debug(groupId);
			group.put(groupId, teams);
		}
		List<Map<Integer, Schedule>> scheduleList = new ArrayList<Map<Integer, Schedule>>();
		Integer count = 0;
		for (int k = 0; k < groupCount; k++) {
			String groupId = "group" + k;

			List<Team> teamList = group.get(groupId);
			logger.debug(groupId);
			logger.debug(teamList);
			Map<Integer, Schedule> groupSchedule = new HashMap<Integer, Schedule>();
			count = 0;
			for (int i = teamList.size() - 1; i >= 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					Schedule schedule = new Schedule();
					List<String> teamIds = new ArrayList<String>();
					teamIds.add(teamList.get(i).getTeamId());
					teamIds.add(teamList.get(j).getTeamId());
					schedule.setTeamIds(teamIds);
					groupSchedule.put(count++, schedule);
					logger.debug(count + "  :::: " + schedule);
				}

			}
			scheduleList.add(groupSchedule);
		}

		int min = 0;
		int max = count - 1;
		for (int i = 0; i < count; i++) {
			int schedulethismatch;
			if (i % 2 == 0) {
				schedulethismatch = min;
				min++;
			} else {
				schedulethismatch = max;
				max--;
			}
			for (int j = 0; j < groupCount; j++) {
				Map<Integer, Schedule> groupSchedule = scheduleList.get(j);
				Schedule schedule = groupSchedule.get(schedulethismatch);
				schedule.setDay(day);
				schedule.setMatchNumber(match);
				if (event.getMatchesPerDay() == match) {
					day++;
					match = 1;
				} else {
					match++;
				}
				logger.debug(schedule);
				schedules.add(schedule);
			}
		}

		return event;
	}

}
