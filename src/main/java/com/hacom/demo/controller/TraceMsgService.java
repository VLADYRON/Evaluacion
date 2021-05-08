package com.hacom.demo.controller;

import com.hacom.demo.modelo.DateRangeRequest;
import com.hacom.demo.modelo.TraceMsg;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TraceMsgService {

    public Mono<TraceMsg> save(TraceMsg traceMsg);

    public Flux<TraceMsg> allFromTo(DateRangeRequest dateRangeRequest);
    
}
