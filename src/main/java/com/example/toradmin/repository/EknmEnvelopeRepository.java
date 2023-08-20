package com.example.toradmin.repository;

import com.example.toradmin.model.ErknmEnvelope;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EknmEnvelopeRepository extends MongoRepository<ErknmEnvelope, String> {
    @Query("{'mainId' : ?0}")
    List<ErknmEnvelope> getErnmEnvelopeByAppealId(@Param("mainId") String mainId);
}