package com.example.admintor.repository.envelope;

import com.example.admintor.models.ErknmEnvelope;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EknmEnvelopeRepository extends MongoRepository<ErknmEnvelope, String> {

}
