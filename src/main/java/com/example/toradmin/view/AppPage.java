package com.example.toradmin.view;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("app")
@AnonymousAllowed
@Route(value="", layout = MainLayout.class)
public class AppPage extends VerticalLayout {
    public AppPage() {
        setSpacing(false);

        Image image = new Image("images/empty-plant.png", "placeholder plant");
        image.setWidth("200px");
        add(image);

        H2 headerH2 = new H2("This app");
        headerH2.addClassNames(LumoUtility.Margin.Top.XLARGE, LumoUtility.Margin.Bottom.MEDIUM);
        add(headerH2);
        add(new Paragraph("It's place for app"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }
}
