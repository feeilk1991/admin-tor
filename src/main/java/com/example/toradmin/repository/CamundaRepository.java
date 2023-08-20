package com.example.toradmin.repository;

import com.example.toradmin.model.CamundaBusinessInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CamundaRepository extends MongoRepository<CamundaBusinessInfo, String> {
    @Query("{'mainId' : ?0}")
    CamundaBusinessInfo findCamunda(@Param("mainId") String mainId);

    @Query("{'processInstanceId':  ?0}")
    CamundaBusinessInfo getCamundaByProcessInstanceId(@Param("processInstanceId") String processInstanceId);
}
