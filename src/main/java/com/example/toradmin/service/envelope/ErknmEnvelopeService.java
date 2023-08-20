package com.example.toradmin.service.envelope;

import com.example.toradmin.model.ErknmEnvelope;

import java.util.Optional;

public interface ErknmEnvelopeService {
    Optional<ErknmEnvelope> getErnmEnvelopeByAppealId(String mainId);
}
