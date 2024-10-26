package org.software.open.source.common.apis.models.responses;

import java.time.ZonedDateTime;

import org.software.open.source.common.utils.Common;
import org.software.open.source.common.utils.DateTimeUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Response<T> {

    private String timeServer = DateTimeUtils.formatDateTime(ZonedDateTime.now(), Common.PATTERN_DEFAULT);

    private int statusCode;

    private String message;

    @NonNull
    private final T data;

}
