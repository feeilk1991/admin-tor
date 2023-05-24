package com.example.admintor.repository.passport;

import com.example.admintor.models.Appeal;
import com.example.admintor.models.AppealPassport;
import com.example.admintor.models.Camunda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppealPassportRepository extends MongoRepository<AppealPassport, String> {
    @Query("{'appealId' : ?0}")
    AppealPassport findPassport(@Param("appealId") String appealId);
}
