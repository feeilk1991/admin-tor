package com.example.admintor.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "appealsErknmEnvelopesInfo")
public class EnvelopesInfo {
    @Id
    private String id;
    private String mainId;
    private String passportId;
    private String collectionName;
    private String taskId;
    private String erpType;
}
