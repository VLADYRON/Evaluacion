package com.hacom.demo.controller;

import com.hacom.demo.modelo.DateRangeRequest;
import com.hacom.demo.modelo.TraceMsg;
import com.hacom.demo.repository.TraceMsgRepository;
import java.time.OffsetDateTime;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class TraceMsgServiceImp implements TraceMsgService {

    @Autowired
    TraceMsgRepository traceMsgRepository;

    @Override
    public Mono<TraceMsg> save(TraceMsg traceMsg) {

        OffsetDateTime ts = OffsetDateTime.now();
        log.debug("Registro creado a {}", ts);
        traceMsg.setTs(ts);
        return traceMsgRepository.save(traceMsg);

    }

    @Override
    public Flux<TraceMsg> allFromTo(DateRangeRequest dateRangeRequest) {

        log.debug("Fecha inicio {}", dateRangeRequest.getFrom());
        log.debug("Fecha fin {}", dateRangeRequest.getTo());
        return traceMsgRepository.findTsBetween(dateRangeRequest.getFrom(), dateRangeRequest.getTo());

    }

}
