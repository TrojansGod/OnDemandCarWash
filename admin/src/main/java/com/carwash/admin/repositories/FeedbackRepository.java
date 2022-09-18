package com.carwash.admin.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.carwash.admin.models.Feedback;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback,String> {

}