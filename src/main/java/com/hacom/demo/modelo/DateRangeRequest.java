package com.hacom.demo.modelo;

import java.time.OffsetDateTime;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class DateRangeRequest {

    @NotNull
    private OffsetDateTime from;
    
    @NotNull
    private OffsetDateTime to;

}
