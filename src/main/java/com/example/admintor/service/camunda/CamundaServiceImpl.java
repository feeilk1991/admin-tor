package com.example.admintor.service.camunda;

import com.example.admintor.models.Appeal;
import com.example.admintor.models.Camunda;
import com.example.admintor.repository.appeal.AppealRepository;
import com.example.admintor.repository.camunda.CamundaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CamundaServiceImpl implements CamundaService {
    @Autowired
    private CamundaRepository camundaRepository;
    @Autowired
    private AppealRepository appealRepository;

    @Override
    public List<Camunda> findCamunda(Camunda camunda)
    {
        return camundaRepository.findAll(Example.of(camunda));
    }

    @Override
    public Camunda getCamundaByMainId(String mainId) {
        Camunda camunda = null;
        Appeal appeal = Objects.requireNonNull(appealRepository.findById(mainId).orElse(null));

       for (Camunda c: camundaRepository.findAll()) {
           if (Objects.equals(c.getMainId(), appeal.getId())) {
               camunda = c;
               break;
           }
       }
        return  camunda;
    }
}