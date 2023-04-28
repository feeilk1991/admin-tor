package com.example.admintor.service.appeal;

import com.example.admintor.models.Appeal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppealServiceImpl implements AppealService {
    @Override
    public List<Appeal> getListAppeals() {
        return null;
    }

    @Override
    public Appeal getAppealId(String uid) {
        return null;
    }

    @Override
    public Appeal updateAppeal(String uid, Appeal request) {
        return null;
    }
}
