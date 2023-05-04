package com.example.admintor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamundaController {
    private final String PROD = "http://camunda.torknd.cloud-uat.vms.torcloud.digital.gov.ru";

    private final String DEMO = "http://camunda.knd.cloud-preprod.vms.torcloud.digital.gov.ru/";
    @GetMapping(DEMO)
    public void  getInstance() {
        return ;
    }

    @GetMapping(PROD)
    public void  getInstance1() {
        return ;
    }
}
