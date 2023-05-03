package com.example.admintor.service.appeal;

import com.example.admintor.models.Appeal;
import com.example.admintor.repository.appeal.AppealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppealServiceImpl implements AppealService {
    @Autowired
    private AppealRepository appealRepository;
    @Override
    public List<Appeal> getListAppeals() {
        return appealRepository.findAll();
    }

    @Override
    public Appeal getAppealId(String uid) {
        return Objects.requireNonNull(appealRepository.findById(uid).orElse(null));
    }

    @Override
    public Appeal updateAppeal(String uid, Appeal request) {
        Appeal appeal = Objects.requireNonNull(appealRepository.findById(uid).orElse(null));

        if (request != null) {
            appeal.setNumber(request.getNumber());
            appeal.setShortNumber(request.getShortNumber());
        }
        return appeal;
    }
}
