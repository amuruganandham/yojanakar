package com.yoganakaar.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoganakaar.dao.TournamentRepository;
import com.yoganakaar.model.Tournament;

@Service
public class TournamentService {

	@Autowired
	private TournamentRepository tournamentRepository;

	private Logger logger = Logger.getLogger(TournamentService.class);

	public Tournament getTournament(String tournamentId) {

		logger.debug("Going to Get Tournament with Id :: " + tournamentId);
		try {
			return tournamentRepository.findOne(tournamentId);
		} catch (Exception e) {
			logger.debug("Exception Occurred :: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public Boolean saveTournament(Tournament tournament) {

		logger.debug("Going to Save data to DB..");
		try {
			tournamentRepository.save(tournament);
		} catch (Exception e) {
			logger.debug("Exception Occurred :: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Boolean deleteTournament(String tournamentId) {

		logger.debug("Going to Delete Tournament with Id :: " + tournamentId);
		try {
			tournamentRepository.delete(tournamentId);
			return true;
		} catch (Exception e) {
			logger.debug("Exception Occurred :: " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public List<Tournament> getAllTournament() {

		logger.debug("Going to Get all Tournaments from DB");
		try {
			return tournamentRepository.findAll();
		} catch (Exception e) {
			logger.debug("Exception Occurred :: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
