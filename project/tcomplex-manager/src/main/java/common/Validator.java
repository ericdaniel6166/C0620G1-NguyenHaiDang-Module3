package common;

import java.util.regex.Pattern;

public class Validator {
    public static final String REGEX_MA_MAT_BANG = "^[A-Z0-9]{3}-[A-Z0-9]{2}-[A-Z0-9]{2}$";
    //    public static final String REGEX_DIEN_TICH = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";
//    public static final String REGEX_TANG = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";
//    public static final String REGEX_GIA_TIEN = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";
    public static final String REGEX_POSITIVE_NUMBER = "^([1-9]\\d*(\\.\\d*)?)|(0\\.\\d+)$";
    public static final String REGEX_POSITIVE_INTEGER = "^[1-9]\\d*$";

    //    ABC-12-34	1	21	1	1	1500000	2020-01-01	2020-02-02
    public static boolean regex(String regex, String string) {
        return Pattern.matches(regex, string);
    }
}
