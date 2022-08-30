package com.carwash.washer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.washer.models.Washer;

@Repository
public interface WasherRepository extends MongoRepository<Washer,String>{

}
