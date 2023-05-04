package com.example.admintor.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Document(collection = "appeals")
public class Appeal {
    @Id
    private String id;
    private String number;
    private String shortNumber;

    @Field("erpEnvelopesInfo")
    private List<EnvelopesInfo> envelopesInfos;

    @Field("subservices")
    private Object subServices;
}
