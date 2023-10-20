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
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AppealController {

    private RestTemplate restTemplate;

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
        List<Appeal> appeals = new ArrayList<>();
        Appeal appeal = getDataByIdFromSource(id);
        if (appeal != null) {
            getAppealAttribute(appeal, model, id);
            appeals.add(appeal);
            model.addAttribute("appeal", appeal);
        }
        model.addAttribute("appeals", appeals);
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
            model.addAttribute("instanceId", camunda.getInstanceId());

//            AppealPassport appealPassport = appealPassportService.getAppealPassportId(mainId);
//            model.addAttribute("passport", appealPassport);

//            Optional<ErknmEnvelope> envelope = erknmEnvelopeService.getErnmEnvelopeByAppealId(mainId);
//            envelope.ifPresent(erknmEnvelope -> model.addAttribute("envelope", erknmEnvelope));
        }
    }

    @PostMapping("/data/sendRequests/{id}")
    public String sendRequestsToCamunda(@PathVariable("id")String id, Model model) {
        String platform = "tor"; // or "pknd"
        String urlGetAct;
        String urlModif;

        urlGetAct = "http://camunda.torknd.cloud-uat.vms.torcloud.digital.gov.ru/engine-rest/process-instance/processId/activity-instances";
        urlModif = "http://camunda.torknd.cloud-uat.vms.torcloud.digital.gov.ru/engine-rest/process-instance/processId/modification";

        String[] piList = {id};

        for (String pi : piList) {
            String url = urlGetAct.replace("processId", "processId="+pi);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer NDtLUFA7S1BQO3Jvemhrb3ZzdixlNDYwNzhkNy03YmRiLTQ4YjEtOGNjYi05YWJiMDllMTQ4M2Q7ZGEyMzI4RGMyNjZjNy00ZTM3LTkzMzUtMzY1OGU5ODFkNjVjOzEwLjQyLjQxLjI1NDsxMC40Mi40MS4yNTQ7MTY4ODM4ODY4ODM0NzsxNjg4Mzg4Nzc4MzQ3Ozs5Njc1YmQ0MjExMDEzNTJiMDcwZmFmNDUwNzQ1MzhmYmM0MzRkNGVlYjU0ZTk4MTc3MzRhZjRjZTNkNThjMTA2");

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            try {
                String postUrl = urlModif.replace("processId", "processId="+pi);

                String requestBody = "{\"skipCustomListeners\": true, \"skipIoMappings\": true, \"annotation\": \"Modified to resolve an error.\"}";

                HttpHeaders postRequestHeaders = new HttpHeaders();
                postRequestHeaders.setContentType(MediaType.APPLICATION_JSON);

                HttpEntity<String> postEntity = new HttpEntity<>(requestBody, postRequestHeaders);

                ResponseEntity<String> postResponse = restTemplate.exchange(postUrl, HttpMethod.POST, postEntity, String.class);

                try {
                    System.out.println(postResponse.getStatusCode());
                } catch (Exception e) {
                    System.out.println(postResponse.getStatusCode() + " exeception " + e.getMessage());
                }
            } catch (Exception e) {
                System.out.println(response.getStatusCode() + " exeception " + e.getMessage());
            }
        }

        return "redirect:/data";
    }

    private Appeal getDataByIdFromSource(String id) {
        Optional<Appeal> myDataOptional = Optional.of(appealService.getAppealId(id));
        return myDataOptional.orElse(null);
    }
}
