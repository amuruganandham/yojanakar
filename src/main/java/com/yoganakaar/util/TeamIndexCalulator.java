package com.yoganakaar.util;

import java.util.OptionalDouble;

import org.apache.log4j.Logger;

import com.yoganakaar.model.Player;
import com.yoganakaar.model.Team;
import com.yoganakaar.service.ScheduleService;

public class TeamIndexCalulator {
	
	private static final Integer EXPIRENCE_WEIGHTAGE = 8;
	private static final Integer EXPERTISE_WEIGHTAGE = 10;
	private static final Integer POPULARITY_WEIGHTAGE = 2;
	private static final Integer FITNESS_WEIGHTAGE = 5;

	private static Logger logger = Logger.getLogger(ScheduleService.class);
	
	public static Double findPlayerIndex(Player player) {
		
		Double index = player.getExperienceLevel() * EXPIRENCE_WEIGHTAGE / 10 
					+ player.getExpertiseLevel() * EXPERTISE_WEIGHTAGE / 10
					+ player.getPopularityLevel() * POPULARITY_WEIGHTAGE / 10
					+ player.getFitnessLevel() * FITNESS_WEIGHTAGE / 10;
		
		logger.debug(player.getPlayerId() + " Player Index :: " + index);
		return index;
	}
	
	public static Double findTeamIndex(Team team) {
		
		logger.debug("findTeamIndex()..");
		
		OptionalDouble index = team.getPlayers()
									 .stream()
									 .mapToDouble(TeamIndexCalulator::findPlayerIndex)
									 .average();
		
		if(index.isPresent()) {
			logger.debug("Team Index :: " + index.getAsDouble());
			return index.getAsDouble();
		}	
		return null;
	}
}
