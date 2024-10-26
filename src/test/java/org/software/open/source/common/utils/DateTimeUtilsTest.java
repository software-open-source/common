package org.software.open.source.common.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

public class DateTimeUtilsTest {

    @Test
    public void testZoneDateTimeFormatting() {
        ZonedDateTime zdt = ZonedDateTime.now();
        String pattern = "yyyy-MM-dd HH:mm:ss Z";
        String formatted = DateTimeUtils.formatDateTime(zdt, pattern);

        assertNotNull(formatted);
    }

    @Test
    public void testLocalDateTimeFormatting() {
        LocalDateTime ldt = LocalDateTime.now();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String formatted = DateTimeUtils.formatDateTime(ldt, pattern);

        assertNotNull(formatted);
        assertTrue(formatted.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"));
    }

    @Test
    public void testLocalDateFormatting() {
        LocalDate ld = LocalDate.now();
        String pattern = "yyyy-MM-dd";
        String formatted = DateTimeUtils.formatDateTime(ld, pattern);

        assertNotNull(formatted);
        assertTrue(formatted.matches("\\d{4}-\\d{2}-\\d{2}"));
    }

    @Test
    public void testInvalidPattern() {
        LocalDateTime ldt = LocalDateTime.now();
        String invalidPattern = "invalid_format";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DateTimeUtils.formatDateTime(ldt, invalidPattern);
        });

        String expectedMessage = "Invalid pattern: invalid_format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testNullInputs() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DateTimeUtils.formatDateTime(null, "yyyy-MM-dd");
        });
        assertEquals("TemporalAccessor and pattern must not be null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            DateTimeUtils.formatDateTime(LocalDate.now(), null);
        });
        assertEquals("TemporalAccessor and pattern must not be null", exception.getMessage());
    }

}
