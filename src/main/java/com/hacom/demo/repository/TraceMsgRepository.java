package com.hacom.demo.repository;

import com.hacom.demo.modelo.TraceMsg;
import java.time.OffsetDateTime;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface TraceMsgRepository extends ReactiveMongoRepository<TraceMsg, ObjectId> {
    
    @Query("{'ts' : {$and:[{$gte:?0},{$lte:?1}]}")
    public Flux<TraceMsg> allFromTo(OffsetDateTime from, OffsetDateTime to);

}
