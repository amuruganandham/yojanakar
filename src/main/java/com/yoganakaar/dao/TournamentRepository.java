package com.yoganakaar.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yoganakaar.model.Tournament;

public interface TournamentRepository extends MongoRepository<Tournament, String>{

}
