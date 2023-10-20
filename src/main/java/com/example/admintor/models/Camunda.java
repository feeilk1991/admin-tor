package com.example.admintor.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "camundaBusinessInfo")
public class Camunda {
    @Id
    private String id;
    @Field("mainId")
    private String mainId;
    @Field("instanceId")
    private String instanceId;
}
