package com.example.toradmin.service.camunda;

import com.example.toradmin.model.CamundaBusinessInfo;
import com.example.toradmin.repository.CamundaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CamundaServiceBusinessInfoImpl implements CamundaBusinessInfoService {
    @Autowired
    private CamundaRepository camundaRepository;
    @Override
    public List<CamundaBusinessInfo> findCamunda(CamundaBusinessInfo camunda)
    {
        return camundaRepository.findAll(Example.of(camunda));
    }

    @Override
    public CamundaBusinessInfo getCamundaByProcessInstanceId(String processInstanceId) {
        return camundaRepository.getCamundaByProcessInstanceId(processInstanceId);
    }
    @Override
    public CamundaBusinessInfo getCamundaByMainId(String mainId) {
        return camundaRepository.findCamunda(mainId);
    }
}
