package com.example.admintor.service.envelope;

import com.example.admintor.models.ErknmEnvelope;
import com.example.admintor.repository.envelope.EknmEnvelopeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ErknmEnvelopeServiceImpl implements ErknmEnvelopeService {
    @Autowired
    private EknmEnvelopeRepository envelopeRepository;

    Optional<ErknmEnvelope> optionalErknmEnvelope;
    @Override
    public Optional<ErknmEnvelope> getErnmEnvelopeByAppealId(String mainId) {

        Stream<ErknmEnvelope> stream = envelopeRepository.getErnmEnvelopeByAppealId(mainId).stream();
        if (stream != null) {
           optionalErknmEnvelope = stream.filter(x-> x.getMainId().equals(mainId)).findFirst();
        }
        return optionalErknmEnvelope;
    }
}
