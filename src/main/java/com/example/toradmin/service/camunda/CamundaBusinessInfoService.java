package com.example.toradmin.service.camunda;

import com.example.toradmin.model.CamundaBusinessInfo;

import java.util.List;

public interface CamundaBusinessInfoService {
    CamundaBusinessInfo getCamundaByMainId (String uid);
    List<CamundaBusinessInfo> findCamunda(CamundaBusinessInfo camunda);
    CamundaBusinessInfo getCamundaByProcessInstanceId(String processInstanceId);
}
