package com.example.admintor.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "appealsErknmEnvelopesInfo")
public class ErknmEnvelope {
    @Id
    private String id;
    @Field("taskId")
    private String taskId;
}
