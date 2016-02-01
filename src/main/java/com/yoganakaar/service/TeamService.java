package com.yoganakaar.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoganakaar.dao.TournamentRepository;
import com.yoganakaar.model.Event;
import com.yoganakaar.model.Team;
import com.yoganakaar.model.Tournament;

@Service
public class TeamService {

	@Autowired
	private TournamentRepository tournamentRepository;
	
	@Autowired
	private EventService eventService;

	private Logger logger = Logger.getLogger(TeamService.class);

	public Team getTeam(String tournamentId, String eventId, String teamId) {

		logger.debug("Entered getEvent()");
		try {
			Event event = eventService.getEvent(tournamentId, eventId);
			return event.getTeams()
						 .stream()
						 .filter(team -> team.getTeamId().equalsIgnoreCase(teamId))
						 .findFirst()
						 .get();
		} catch (Exception e) {
			logger.debug("Exception Occurred :: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public void postTeam(String tournamentId, String eventId, Team team) {

		logger.debug("Entered postTeam()");
		try {
			Tournament tournament = tournamentRepository.findOne(tournamentId);
			tournament.getEvents()
					  .stream()
					  .filter(event -> event.getEventId().equalsIgnoreCase(eventId))
					  .findFirst()
					  .get()
					  .getTeams()
					  .add(team);
			tournamentRepository.save(tournament);
		} catch (Exception e) {
			logger.debug("Exception Occurred :: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public List<Team> getAllTeam(String tournamentId, String eventId) {

		logger.debug("Entered getAllTeam()");
		try {
			return tournamentRepository.findOne(tournamentId)
										.getEvents()
										.stream()
										.filter(event -> event.getEventId().equalsIgnoreCase(eventId))
										.findFirst()
										.get()
										.getTeams();
		} catch (Exception e) {
			logger.debug("Exception Occurred :: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
