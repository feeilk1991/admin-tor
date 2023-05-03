package com.example.admintor.controller;

import com.example.admintor.models.AppealPassport;
import com.example.admintor.service.passport.AppealPassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/passports")
public class AppealPassportController {
    @Autowired
    private AppealPassportService appealPassportService;

    @GetMapping("/{id}")
    public AppealPassport findAppealPassportId(@PathVariable String id) {
        return appealPassportService.getAppealPassportId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAppealPassportById (@PathVariable String id) {
        appealPassportService.deleteAppealPassport(id);
    }

}
