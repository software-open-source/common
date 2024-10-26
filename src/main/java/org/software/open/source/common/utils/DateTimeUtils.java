package org.software.open.source.common.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateTimeUtils {

    private DateTimeUtils() {
    }

    public static String formatDateTime(TemporalAccessor temporal, String pattern) {
        if (temporal == null || pattern == null) {
            throw new IllegalArgumentException("TemporalAccessor and pattern must not be null");
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            if (temporal instanceof ZonedDateTime) {
                formatter = formatter.withZone(ZoneId.systemDefault());
            }
            return formatter.format(temporal);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid pattern: " + pattern, e);
        }
    }

}
