package com.example.admintor.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "appeals")
public class Appeal {
    @Id
    private String id;
    private String number;

    private String shortNumber;
}
