package com.example.admintor.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "preventionAppeals")
public class PreventionAppeals {
    @Id
    private String id;
    private String number;
    private String shortNumber;

    @Field("erpEnvelopesInfo")
    private List<EnvelopesInfo> envelopesInfos;
}
