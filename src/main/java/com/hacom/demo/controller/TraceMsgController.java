package com.hacom.demo.controller;

import com.hacom.demo.modelo.DateRangeRequest;
import com.hacom.demo.modelo.TraceMsg;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@RequestMapping("api/v1/msg/")
public class TraceMsgController {

    @Autowired
    TraceMsgService service;

    private final Counter myCounter;

    public TraceMsgController(MeterRegistry meterRegistry) {
        this.myCounter = meterRegistry.counter("hacom.test.developer.insert.rx");
    }

    @PostMapping()
    public Mono<TraceMsg> insertar(@RequestBody TraceMsg traceMsg) {

        log.debug("Petición de registro");
        myCounter.increment();
        return service.save(traceMsg);

    }

    @GetMapping()
    public Flux<TraceMsg> extraer(@RequestBody DateRangeRequest dateRangeRequest) {

        return service.allFromTo(dateRangeRequest);

    }

}
