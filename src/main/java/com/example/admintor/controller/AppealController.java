package com.example.admintor.controller;

import com.example.admintor.models.Appeal;
import com.example.admintor.service.appeal.AppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appeals")
public class AppealController {
    @Autowired
    private AppealService appealService;

    @GetMapping("/{id}")
    public Appeal findAppealById(@PathVariable String id) {
        return appealService.getAppealId(id);
    }
}
