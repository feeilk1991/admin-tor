package com.example.admintor.repository.camunda;

import com.example.admintor.models.Camunda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CamundaRepository extends MongoRepository<Camunda, String> {
    @Query("{'mainId' : ?0}")
    Camunda findCamunda(@Param("mainId") String mainId);

    @Query("{'processInstanceId':  ?0}")
    Camunda getCamundaByProcessInstanceId(@Param("processInstanceId") String processInstanceId);
}
