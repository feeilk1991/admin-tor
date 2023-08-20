package com.example.toradmin.service.appealPassport;

import com.example.toradmin.model.AppealPassport;
import com.example.toradmin.repository.AppealPassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AppealPassportServiceImpl implements AppealPassportService{

    @Autowired
    private AppealPassportRepository appealPassportRepository;
    @Override
    public AppealPassport getAppealPassportId(String appealId) {
        return appealPassportRepository.findPassport(appealId);
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
