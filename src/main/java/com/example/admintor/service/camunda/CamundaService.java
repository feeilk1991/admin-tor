package com.example.admintor.service.camunda;

import com.example.admintor.models.Camunda;

import java.util.List;

public interface CamundaService {
    Camunda getCamundaByMainId (String uid);
    List<Camunda> findCamunda(Camunda camunda);
    Camunda getCamundaByProcessInstanceId(String processInstanceId);
}
