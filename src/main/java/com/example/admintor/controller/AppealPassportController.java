package com.example.admintor.controller;

import com.example.admintor.models.AppealPassport;
import com.example.admintor.service.passport.AppealPassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppealPassportController {
    @Autowired
    private AppealPassportService appealPassportService;
    @GetMapping("/passports/{id}")
    public AppealPassport findAppealPassportId(@PathVariable String id) {
        return appealPassportService.getAppealPassportId(id);
    }

    @DeleteMapping("/passports/{id}")
    public void deleteAppealPassportById (@PathVariable String id) {
        appealPassportService.deleteAppealPassport(id);
    }

}
