package com.yoganakaar.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoganakaar.model.Event;
import com.yoganakaar.service.ScheduleService;

@RestController
@ComponentScan("com.yoganakaar")
public class ScheduleController {

	private Logger logger = Logger.getLogger(ScheduleController.class);

	@Autowired
	private ScheduleService sheduleService;

	@RequestMapping(value = "/schedule/{tournamentId}/{eventId}", method = {
			RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Event scheduleTournament(
			@PathVariable("tournamentId") String tournamentId,
			@PathVariable("eventId") String eventId) {

		logger.debug("scheduleTournament()..");
		return sheduleService.getScheduledTournament(tournamentId, eventId);
	}
}
