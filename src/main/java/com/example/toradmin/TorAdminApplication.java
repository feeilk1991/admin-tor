package com.example.toradmin;

import com.vaadin.flow.component.dependency.NpmPackage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@NpmPackage(value = "lumo-css-framework", version = "^4.0.10")
public class TorAdminApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(TorAdminApplication.class, args);
    }
}
