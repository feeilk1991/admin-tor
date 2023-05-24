package com.example.admintor.controller;

import com.example.admintor.models.Appeal;
import com.example.admintor.models.AppealPassport;
import com.example.admintor.models.Camunda;
import com.example.admintor.service.appeal.AppealService;
import com.example.admintor.service.camunda.CamundaService;
import com.example.admintor.service.passport.AppealPassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @GetMapping("/data")
    public ModelAndView showAllAppeals(Model model) throws NullPointerException {
        List<Appeal> appeals = new ArrayList<>();;

        //TODO
        Appeal appeal = getDataByIdFromSource("6385d4e4a978a3000137ba6e");
        try {
            appeals.add(appeal);
        } catch (NullPointerException e) {
            model.addAttribute("appeals", e.getMessage());
        }

        model.addAttribute("appeals", appeals);

        return new ModelAndView("data-view");
    }

    /*@GetMapping("/data")
    public ModelAndView showDataForm(Model model) {
        model.addAttribute("id", null);
        return new ModelAndView("data-view");
    }*/

    /*@GetMapping("/data/{id}")
    public ModelAndView getDataById(String id, Model model) {
        Appeal appeal = getDataByIdFromSource(id);
        model.addAttribute("appeal", appeal);
        if (appeal != null) {
            Camunda camunda = camundaService.getCamundaByMainId(id);
            model.addAttribute("camunda", camunda);

            AppealPassport appealPassport = appealPassportService.getAppealPassportId(id);
            model.addAttribute("passport", appealPassport);

        }
        return new ModelAndView("data-view");
    }*/

    @GetMapping("/data/details/{id}")
    public ModelAndView getDataAppealId(@PathVariable("id")String id, Model model) {
        Appeal appeal = getDataByIdFromSource(id);
        model.addAttribute("appeal", appeal);
        if (appeal != null) {
            Camunda camunda = camundaService.getCamundaByMainId(id);
            model.addAttribute("camunda", camunda);

            AppealPassport appealPassport = appealPassportService.getAppealPassportId(id);
            model.addAttribute("passport", appealPassport);

        }
        return new ModelAndView("data-details");
    }

    private Appeal getDataByIdFromSource(String id) {
        Optional<Appeal> myDataOptional = Optional.of(appealService.getAppealId(id));
        return myDataOptional.orElse(null);
    }

    private List<Appeal> getDataAppeals() {
        return appealService.getListAppeals();
    }
}
