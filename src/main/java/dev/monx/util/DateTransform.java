package dev.monx.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Optional;

import org.jboss.logging.Logger;

// codigo do CHATGPT!!!
// write a function that receives an Optional<String> in the format, 
// "2012-10-10", "Sep/22/1977", "Aug/2006", "2012-10-18 00:00:00", "1982" 
// or empty and return a LocalDate from the String received
public class DateTransform {
    private static final Logger logger = Logger.getLogger(DateTransform.class);

    private static final DateTimeFormatter[] formatters = {
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        new DateTimeFormatterBuilder().appendPattern("MMM/dd/yyyy").parseStrict().toFormatter(),
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    };

    private static LocalDate convertToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId systemDefault = ZoneId.systemDefault();
        return instant.atZone(systemDefault).toLocalDate();
    }

    public static LocalDate convertToLocalDate(Optional<String> dateString) {
        if (!dateString.isPresent()) {
            return null;
        }

        String input = dateString.get();

        if (input.matches("\\d{4}")) {
            return LocalDate.of(Integer.parseInt(input), 1, 1);
        }

        if (input.matches("\\w{3}/\\d{4}")) {
            SimpleDateFormat format = new SimpleDateFormat("MMM/yyyy");
            try {
                return convertToLocalDate(format.parse(input));
            } catch (ParseException e) {
                logger.error(e);
            }
        }

        for (DateTimeFormatter formatter : formatters) {
            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                logger.error(e);
            }
        }
        return null;
    }
}
