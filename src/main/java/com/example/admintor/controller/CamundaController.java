package com.example.admintor.controller;

import com.example.admintor.models.Camunda;
import com.example.admintor.service.camunda.CamundaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("http://camunda.knd.cloud-preprod.vms.torcloud.digital.gov.ru")
public class CamundaController {
    @Autowired
    private CamundaService camundaService;
    private final String PROD = "http://camunda.torknd.cloud-uat.vms.torcloud.digital.gov.ru";
    private final String DEMO = "http://camunda.knd.cloud-preprod.vms.torcloud.digital.gov.ru";
//    @GetMapping(DEMO)
//    public void  getInstance() {
//        return ;
//    }

    @GetMapping("/engine-rest/process-instance/{instanceId}/activity-instances")
    public ModelAndView getActivityInstanceForProcessInstance (String instanceId, Model model) {
        Camunda camunda = camundaService.getCamundaByProcessInstanceId(instanceId);
        model.addAttribute("camunda", camunda);

        return new ModelAndView("data-details-camunda");
    }


}
