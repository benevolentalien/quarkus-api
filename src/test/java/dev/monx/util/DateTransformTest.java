package dev.monx.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class DateTransformTest {
    @Test
    public void testConvertToLocalDate_WithValidDateString_ReturnsExpectedLocalDate() {
        Optional<String> dateString1 = Optional.of("2012-10-10");
        LocalDate expectedResult1 = LocalDate.of(2012, 10, 10);
        assertEquals(expectedResult1, DateTransform.convertToLocalDate(dateString1));

        Optional<String> dateString2 = Optional.of("Sep/22/1977");
        LocalDate expectedResult2 = LocalDate.of(1977, 9, 22);
        assertEquals(expectedResult2, DateTransform.convertToLocalDate(dateString2));

        Optional<String> dateString3 = Optional.of("Aug/2006");
        LocalDate expectedResult3 = LocalDate.of(2006, 8, 1);
        assertEquals(expectedResult3, DateTransform.convertToLocalDate(dateString3));

        Optional<String> dateString4 = Optional.of("1982");
        LocalDate expectedResult4 = LocalDate.of(1982, 1, 1);
        assertEquals(expectedResult4, DateTransform.convertToLocalDate(dateString4));
    }

    @Test
    public void testConvertToLocalDate_WithInvalidDateString_ReturnsNull() {
        Optional<String> dateString = Optional.of("invalid date string");
        assertNull(DateTransform.convertToLocalDate(dateString));
    }

    @Test
    public void testConvertToLocalDate_WithEmptyDateString_ReturnsNull() {
        Optional<String> dateString = Optional.empty();
        assertNull(DateTransform.convertToLocalDate(dateString));
    }
}