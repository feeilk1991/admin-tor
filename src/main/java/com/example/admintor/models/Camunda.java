package com.example.admintor.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "camundaBusinessInfo")
public class Camunda {
    @Id
    private String id;
    private String mainId;

    private String instanceId;
}
