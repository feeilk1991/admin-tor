package com.example.admintor.service.camunda;

import com.example.admintor.models.Camunda;
import com.example.admintor.repository.camunda.CamundaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CamundaServiceImpl implements CamundaService {
    @Autowired
    private CamundaRepository camundaRepository;
    @Override
    public List<Camunda> findCamunda(Camunda camunda)
    {
        return camundaRepository.findAll(Example.of(camunda));
    }

    @Override
    public Camunda getCamundaByProcessInstanceId(String processInstanceId) {
        if (processInstanceId == null) {
            throw new NullPointerException();
        }
        return camundaRepository.getCamundaByProcessInstanceId(processInstanceId);
    }
    @Override
    public Camunda getCamundaByMainId(String mainId) {
        return camundaRepository.findCamunda(mainId);
    }
}
