package com.hacom.demo.modelo;

import java.time.OffsetDateTime;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DateRangeRequest {

    @NotNull
    private OffsetDateTime from;

    @NotNull
    private OffsetDateTime to;

}
