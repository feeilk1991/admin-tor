package com.example.admintor.service.passport;

import com.example.admintor.models.AppealPassport;
import com.example.admintor.repository.appeal.AppealRepository;
import com.example.admintor.repository.passport.AppealPassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AppealPassportServiceImpl implements AppealPassportService{

    @Autowired
    private AppealPassportRepository passportRepository;
    @Override
    public AppealPassport getAppealPassportId(String appealId) {
        return Objects.requireNonNull(passportRepository.findById(appealId).orElse(null));
    }

    @Override
    public AppealPassport updatePassportAppealId(String uid, AppealPassport appealPassport) {
        return null;
    }

    @Override
    public void deleteAppealPassport(String appealId) {
        AppealPassport appealPassport = Objects.requireNonNull(passportRepository.findById(appealId).orElse(null));
        passportRepository.delete(appealPassport);
    }
}
