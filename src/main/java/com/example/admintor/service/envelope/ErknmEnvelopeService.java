package com.example.admintor.service.envelope;

import com.example.admintor.models.ErknmEnvelope;

import java.util.List;
import java.util.Optional;

public interface ErknmEnvelopeService {
    Optional<ErknmEnvelope> getErnmEnvelopeByAppealId(String mainId);
}
