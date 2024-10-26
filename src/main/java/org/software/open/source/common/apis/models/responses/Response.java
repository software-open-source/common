package org.software.open.source.common.apis.models.responses;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.software.open.source.common.utils.DateTimeUtils;

import lombok.Data;
import lombok.NonNull;

@Data
public class Response<T> {

    private String timeServer = DateTimeUtils.formatDateTime(ZonedDateTime.now().withZoneSameInstant(ZoneId.of("UTC")), "YYYY/MM/dd HH:mm:ss Z");

    private int statusCode;

    private String message;

    @NonNull
    private final T data;

}
