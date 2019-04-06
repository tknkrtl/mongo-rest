package com.atakan.mongoRest.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.atakan.mongoRest.entity.Owners;

@Repository
public interface MongoDbRepo extends MongoRepository<Owners,String> {
	
	
}
