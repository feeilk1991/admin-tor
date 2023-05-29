package com.example.admintor.controller;

import com.example.admintor.models.Appeal;
import com.example.admintor.models.AppealPassport;
import com.example.admintor.models.Camunda;
import com.example.admintor.models.ErknmEnvelope;
import com.example.admintor.service.appeal.AppealService;
import com.example.admintor.service.camunda.CamundaService;
import com.example.admintor.service.envelope.ErknmEnvelopeService;
import com.example.admintor.service.passport.AppealPassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AppealController {
    @Autowired
    private AppealService appealService;
    @Autowired
    private CamundaService camundaService;
    @Autowired
    private AppealPassportService appealPassportService;
    @Autowired
    private ErknmEnvelopeService erknmEnvelopeService;

    private String PROD = "http://camunda.torknd.cloud-uat.vms.torcloud.digital.gov.ru";

    private final String DEMO = "http://camunda.knd.cloud-preprod.vms.torcloud.digital.gov.ru";

    @GetMapping("/data")
    public ModelAndView showAllAppeals(Model model) throws NullPointerException {
        List<Appeal> appeals = new ArrayList<>();;
        model.addAttribute("id", null);
        //TODO
//        Appeal appeal = getDataByIdFromSource("6385d4e4a978a3000137ba6e");
//        try {
//            appeals.add(appeal);
//        } catch (NullPointerException e) {
//            model.addAttribute("appeals", e.getMessage());
//        }

        model.addAttribute("appeals", appeals);

        return new ModelAndView("data-view");
    }

    @GetMapping("/data/{id}")
    public ModelAndView getDataById(String id, Model model) {
        Appeal appeal = getDataByIdFromSource(id);
        List<Appeal> appeals = new ArrayList<>();
        appeals.add(appeal);
        model.addAttribute("appeals", appeals);
        model.addAttribute("appeal", appeal);
        return new ModelAndView("data-view");
    }

    @GetMapping("/data/details/{id}")
    public ModelAndView getDataAppealId(@PathVariable("id")String id, Model model) {
        Appeal appeal = getDataByIdFromSource(id);
        getAppealAttribute(appeal, model, id);
        return new ModelAndView("data-details");
    }

    private void getAppealAttribute(Appeal appeal, Model model, String mainId) {
        model.addAttribute("appeal", appeal);
        if (appeal != null) {
            Camunda camunda = camundaService.getCamundaByMainId(mainId);
            model.addAttribute("camunda", camunda);

            AppealPassport appealPassport = appealPassportService.getAppealPassportId(mainId);
            model.addAttribute("passport", appealPassport);

            Optional<ErknmEnvelope> envelope = erknmEnvelopeService.getErnmEnvelopeByAppealId(mainId);
            envelope.ifPresent(erknmEnvelope -> model.addAttribute("envelope", erknmEnvelope));
        }
    }

    private Appeal getDataByIdFromSource(String id) {
        Optional<Appeal> myDataOptional = Optional.of(appealService.getAppealId(id));
        return myDataOptional.orElse(null);
    }
}
