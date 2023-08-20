package com.example.toradmin.service.appealPassport;

import com.example.toradmin.model.AppealPassport;
import com.mongodb.lang.NonNull;

public interface AppealPassportService {
    @NonNull
    AppealPassport getAppealPassportId (String appealId);

    @NonNull
    void deleteAppealPassport(String uid);
}
