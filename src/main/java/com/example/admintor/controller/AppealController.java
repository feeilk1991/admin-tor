package com.example.admintor.controller;

import com.example.admintor.models.Appeal;
import com.example.admintor.service.appeal.AppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppealController {
    @Autowired
    private AppealService appealService;

    @GetMapping("/appeals/{id}")
    public Appeal findAppealById(@PathVariable String id) {
        return appealService.getAppealId(id);
    }

    @GetMapping("/appeals")
    public List<Appeal> findAllAppeals()
    {
        return appealService.getListAppeals();
    }
}
