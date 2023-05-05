package com.example.admintor.controller;

import com.example.admintor.models.Appeal;
import com.example.admintor.service.appeal.AppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AppealController {
    @Autowired
    private AppealService appealService;

    @GetMapping("/appeal")
    public String getDataById(@RequestParam(name = "id") String id, Model model) {
        // Получение данных по id из источника, если id был отправлен
            Appeal appeal = getDataByIdFromSource(id);
            model.addAttribute("appeal", appeal);

        // Возвращение имени представления для отображения данных
        return "data-view";
    }

    private Appeal getDataByIdFromSource(String id) {
        Optional<Appeal> myDataOptional = Optional.of(appealService.getAppealId(id));
        return myDataOptional.orElse(null);
    }
}
