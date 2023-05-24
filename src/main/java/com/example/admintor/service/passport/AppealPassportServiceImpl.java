package com.example.admintor.service.passport;

import com.example.admintor.models.AppealPassport;
import com.example.admintor.repository.appeal.AppealRepository;
import com.example.admintor.repository.passport.AppealPassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AppealPassportServiceImpl implements AppealPassportService{

    @Autowired
    private AppealPassportRepository appealPassportRepository;
    @Autowired
    private AppealRepository appealRepository;

    @Override
    public AppealPassport getAppealPassportId(String appealId) {
        return appealPassportRepository.findPassport(appealId);
    }

    @Override
    public AppealPassport updatePassportAppealId(String uid, AppealPassport appealPassport) {
        return null;
    }

    @Override
    public void deleteAppealPassport(String appealId) {
        AppealPassport appealPassport = Objects.requireNonNull(appealPassportRepository.findPassport(appealId));
        if (appealPassport.getAppealId() == null || appealPassport.getAppealId().isEmpty()) {
            throw new NullPointerException("Not found appeal passport");
        }
        appealPassportRepository.delete(appealPassport);
    }
}
