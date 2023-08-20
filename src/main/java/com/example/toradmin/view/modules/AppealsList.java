package com.example.toradmin.view.modules;

import com.example.toradmin.model.AppealPassport;
import com.example.toradmin.model.CamundaBusinessInfo;
import com.example.toradmin.service.appealPassport.AppealPassportServiceImpl;
import com.example.toradmin.service.camunda.CamundaServiceBusinessInfoImpl;
import com.example.toradmin.service.envelope.ErknmEnvelopeServiceImpl;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.component.textfield.TextField;

@AnonymousAllowed
@Route(value="appeals")
@PageTitle("Appeals | CRM")
public class AppealsList extends VerticalLayout {
    Grid<AppealPassport> grid = new Grid<>(AppealPassport.class);
    TextField textField = new TextField();
    AppealPassportServiceImpl passportService;
    CamundaServiceBusinessInfoImpl businessInfoService;
    ErknmEnvelopeServiceImpl erknmEnvelopeServiceImpl;

    public AppealsList(AppealPassportServiceImpl passportService,
                    CamundaServiceBusinessInfoImpl camundaServiceBusinessInfo,
                    ErknmEnvelopeServiceImpl erknmEnvelopeService) {
        this.passportService = passportService;

        this.businessInfoService = camundaServiceBusinessInfo;
        this.erknmEnvelopeServiceImpl = erknmEnvelopeService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        //configureForm();

        add(getToolbar(), getContent());
        updateList();
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid);
        content.setFlexGrow(2, grid);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    private void configureGrid() {
        grid.addClassNames("contact-grid");
        grid.setSizeFull();
        grid.setColumns("appealId", "passportId", "envelopeId", "nameCollection", "processInstanceId");
        grid.addColumn(AppealPassport::getAppealId).setHeader("appealId");
        grid.addColumn(AppealPassport::getId).setHeader("passportId");
        grid.addColumn(AppealPassport::getCollectionName).setHeader("collectionName");

        //grid.addColumn(contact -> contact.getCompany().getName()).setHeader("Company");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

    }

    private HorizontalLayout getToolbar() {
        textField.setPlaceholder("Filter by name...");
        textField.setClearButtonVisible(true);
        textField.setValueChangeMode(ValueChangeMode.LAZY);
        textField.addValueChangeListener(e -> updateList());

        Button addContactButton = new Button("Add contact");

        var toolbar = new HorizontalLayout(textField, addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void updateList() {
        grid.setItems(passportService.getAppealPassportId(textField.getValue()));
    }
}
