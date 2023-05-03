package com.example.admintor.repository.passport;

import com.example.admintor.models.Appeal;
import com.example.admintor.models.AppealPassport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppealPassportRepository extends MongoRepository<AppealPassport, String> {

}
