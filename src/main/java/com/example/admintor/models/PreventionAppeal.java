package com.example.admintor.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "preventionAppeals")
public class PreventionAppeal {
    @Id
    private String id;
    private String number;
    private String shortNumber;
    @Field("parentEntries")
    private String parentEntries;
    @Field("guid")
    private String guid;
}
