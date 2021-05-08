package com.hacom.demo.modelo;

import java.time.OffsetDateTime;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class TraceMsg {

    @Id
    private ObjectId _id;
    private String sessionId;
    private String payload;
    private OffsetDateTime ts;

}
