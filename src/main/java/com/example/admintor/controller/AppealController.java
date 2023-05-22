package com.example.admintor.controller;

import com.example.admintor.models.Appeal;
import com.example.admintor.models.Camunda;
import com.example.admintor.service.appeal.AppealService;
import com.example.admintor.service.camunda.CamundaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AppealController {
    @Autowired
    private AppealService appealService;

    @Autowired
    private CamundaService camundaService;

    @GetMapping("/data")
    public ModelAndView showDataForm(Model model) {
        model.addAttribute("id", null);
        return new ModelAndView("data-view");
    }

    @GetMapping("/data/{id}")
    public ModelAndView getDataById(String id, Model model) {
        Appeal appeal = getDataByIdFromSource(id);
        model.addAttribute("appeal", appeal);
        if (appeal != null) {
            Camunda camunda = camundaService.getCamundaByMainId(appeal.getId());
            model.addAttribute("camunda", camunda);

        }
        return new ModelAndView("data-view");
    }

    private Appeal getDataByIdFromSource(String id) {
        Optional<Appeal> myDataOptional = Optional.of(appealService.getAppealId(id));
        return myDataOptional.orElse(null);
    }
}
