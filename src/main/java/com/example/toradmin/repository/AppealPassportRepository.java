package com.example.toradmin.repository;

import com.example.toradmin.model.AppealPassport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppealPassportRepository extends MongoRepository<AppealPassport, String> {
    @Query("{'appealId' : ?0}")
    AppealPassport findPassport(@Param("appealId") String appealId);
}
