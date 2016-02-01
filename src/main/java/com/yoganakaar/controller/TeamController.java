package com.yoganakaar.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoganakaar.model.Team;
import com.yoganakaar.service.TeamService;

@RestController
@ComponentScan("com.yoganakaar")
public class TeamController {

	private Logger logger = Logger.getLogger(TeamController.class);
 
	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "/team/{tournamentId}/{eventId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Team> getAllTeam(@PathVariable("tournamentId") String tournamentId,
			@PathVariable("eventId") String eventId) {

		logger.debug("Entered GetAllEvent()..");
		return teamService.getAllTeam(tournamentId, eventId);
	}
	
	@RequestMapping(value = "/team/{tournamentId}/{eventId}/{teamId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Team getTeam(@PathVariable("tournamentId") String tournamentId,
			@PathVariable("eventId") String eventId,
			@PathVariable("teamId") String teamId) {

		logger.debug("Entered GetAllEvent()..");
		return teamService.getTeam(tournamentId, eventId, teamId);
	}

	@RequestMapping(value = "/team/{tournamentId}/{eventId}", method = {RequestMethod.POST, RequestMethod.PUT }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void postEvent(@PathVariable("tournamentId") String tournamentId,
			@PathVariable("eventId") String eventId,
			@RequestBody Team team) {

		logger.debug("Entered postEvent()..");
		teamService.postTeam(tournamentId, eventId, team);
	}
}
