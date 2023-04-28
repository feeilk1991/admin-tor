package com.example.admintor.service.appeal;

import com.example.admintor.models.Appeal;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AppealService {
    @NonNull
    List<Appeal> getListAppeals();

    @NonNull
    Appeal getAppealId (String uid);

    @NonNull
    Appeal updateAppeal (String uid, @NonNull Appeal request);
}
