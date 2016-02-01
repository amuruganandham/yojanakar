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

import com.yoganakaar.model.Tournament;
import com.yoganakaar.service.TournamentService;

@RestController
@ComponentScan("com.yoganakaar")
public class TournamentController {

	@Autowired
	private TournamentService tournamentService;

	private Logger logger = Logger.getLogger(TournamentController.class);

	@RequestMapping(value = "/tournament", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Tournament> getAllTournament() {

		logger.debug("getTournament()..");
		return tournamentService.getAllTournament();
	}

	@RequestMapping(value = "/tournament/{tournamentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Tournament getTournament(
			@PathVariable(value = "tournamentId") String tournamentId) {

		logger.debug("getTournament() :: tournamentId = " + tournamentId);
		return tournamentService.getTournament(tournamentId);
	}

	@RequestMapping(value = "/tournament", method = { RequestMethod.POST,
			RequestMethod.PUT }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveTournament(@RequestBody Tournament tournament) {

		logger.debug("saveTournament() :: " + tournament.toString());
		if (tournamentService.saveTournament(tournament))
			return "success";

		return "failure";
	}

	@RequestMapping(value = "/tournament/{tournamentId}", method = RequestMethod.DELETE)
	public String updateTournament(
			@PathVariable(value = "tournamentId") String tournamentId) {

		logger.debug("saveTournament() :: " + tournamentId);
		if (tournamentService.deleteTournament(tournamentId))
			return "success";

		return "failure";
	}
}
