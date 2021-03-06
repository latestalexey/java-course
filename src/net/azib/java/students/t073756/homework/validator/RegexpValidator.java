package net.azib.java.students.t073756.homework.validator;

import java.util.regex.Pattern;

public class RegexpValidator {

    private RegexpValidator() {
    }

    /**
     * Regexp check, unicode case folding aware
     *
     * @param input   - string under check
     * @param pattern - validation pattern
     * @return - true, if input matches with pattern
     */
    public static boolean validate(String input, String pattern) {
        return Pattern.compile(pattern, Pattern.UNICODE_CASE).matcher(input.trim()).matches();
    }
}
