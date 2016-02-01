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

import com.yoganakaar.model.Event;
import com.yoganakaar.service.EventService;

@RestController
@ComponentScan("com.yoganakaar")
public class EventController {

	private Logger logger = Logger.getLogger(EventController.class);

	@Autowired
	private EventService eventService;

	@RequestMapping(value = "/event/{tournamentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Event> getAllEvent(
			@PathVariable("tournamentId") String tournamentId) {

		logger.debug("Entered GetAllEvent()..");
		return eventService.getAllEvent(tournamentId);
	}

	@RequestMapping(value = "/event/{tournamentId}/{eventId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Event getEvent(@PathVariable("tournamentId") String tournamentId,
			@PathVariable("eventId") String eventId) {

		logger.debug("Entered GetEvent()..");
		return eventService.getEvent(tournamentId, eventId);
	}

	@RequestMapping(value = "/event/{tournamentId}", method = {
			RequestMethod.POST, RequestMethod.PUT }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void postEvent(@PathVariable("tournamentId") String tournamentId,
			@RequestBody Event event) {

		logger.debug("Entered postEvent()..");
		eventService.postEvent(tournamentId, event);
	}
}
