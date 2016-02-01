package com.yoganakaar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoganakaar.dao.TournamentRepository;
import com.yoganakaar.model.Event;
import com.yoganakaar.model.Tournament;

@Service
public class EventService {

	@Autowired
	private TournamentRepository tournamentRepository;

	private Logger logger = Logger.getLogger(EventService.class);

	public Event getEvent(String tournamentId, String eventId) {

		logger.debug("Entered getEvent()");
		try {
			return tournamentRepository
					.findOne(tournamentId)
					.getEvents()
					.stream()
					.filter(event -> event.getEventId().equalsIgnoreCase(
							eventId)).findFirst().get();
		} catch (Exception e) {
			logger.debug("Exception Occurred :: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public void postEvent(String tournamentId, Event event) {

		logger.debug("Entered getEvent()");
		try {
			Tournament tournament = tournamentRepository.findOne(tournamentId);
			tournament.getEvents().add(event);
			tournamentRepository.save(tournament);
		} catch (Exception e) {
			logger.debug("Exception Occurred :: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public List<Event> getAllEvent(String tournamentId) {

		logger.debug("Entered getAllEvent()");
		try {
			return tournamentRepository.findOne(tournamentId).getEvents()
					.stream().collect(Collectors.toList());
		} catch (Exception e) {
			logger.debug("Exception Occurred :: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
