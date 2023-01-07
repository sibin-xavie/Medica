package com.gerimedica.medica.util;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateReqValidator implements DateValidator {
    private DateTimeFormatter dateFormatter;

    public DateReqValidator(DateTimeFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    @Override
    public boolean isValid(String dateStr) {
        try {
            this.dateFormatter.parse(dateStr);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
