package com.example.admintor.service.passport;

import com.example.admintor.models.AppealPassport;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AppealPassportService {
    @NonNull
    AppealPassport getAppealPassportId (String appealId);

    @NonNull
    AppealPassport updatePassportAppealId (String uid, @NonNull AppealPassport appealPassport);

    @NonNull
    void deleteAppealPassport(String uid);

    List<AppealPassport> findAllAppeals();
}
