package com.example.toradmin.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "appealsErknmEnvelopesInfo")
public class ErknmEnvelope {
    @Id
    private String id;
    @Field("mainId")
    private String mainId;
    @Field("taskId")
    private String taskId;
}