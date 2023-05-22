package com.example.admintor.repository.camunda;

import com.example.admintor.models.Camunda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface CamundaRepository extends MongoRepository<Camunda, String> {
}
