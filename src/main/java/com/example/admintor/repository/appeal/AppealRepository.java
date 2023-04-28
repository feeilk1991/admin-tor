package com.example.admintor.repository.appeal;

import com.example.admintor.models.Appeal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppealRepository extends MongoRepository<Appeal, String> {

}
