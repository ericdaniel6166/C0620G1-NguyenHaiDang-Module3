package common;

import java.util.regex.Pattern;

public class Validator {
    //    KH-XXXX
    public static final String REGEX_CUSTOMER_ID = "^KH-\\d{4}$";
    //    DV-XXXX
    public static final String REGEX_SERVICE_ID = "^DV-\\d{4}$";
    //    Tên
    public static final String REGEX_PERSON_NAME = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";
    //    Số điện thoại
    //    090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx
    public static final String REGEX_PHONE = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$";
    //    public static final String REGEX_PHONE = "^(090|091|[(]84[)][+]90|[(]84[)][+]91)[\\d]{7}$";
    //    CMND 9 số và 12 số
    public static final String REGEX_ID_NUMBER = "^(\\d{9}|\\d{12})$";
    //    Email
    //    public static final String REGEX_EMAIL = "^[\\w.]+@[\\w&&[^_]]+([.][\\w&&[^_]]+){1,2}$";
    public static final String REGEX_EMAIL = "[\\w.]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+){1,2}";
    //    số dương
    public static final String REGEX_POSITIVE_NUMBER = "^([1-9]\\d*(\\.\\d*)?)|(0\\.\\d+)$";
    //    số nguyên dương
    public static final String REGEX_POSITIVE_INTEGER = "^[1-9]\\d*$";
    //    mã dịch vụ
//    public static final String REGEX_SERVICE_NAME = "^(SVVL|SVHO|SVRO)-\\d{4}$";
    //    mã dịch vụ
    public static final String REGEX_SERVICE_NAME = "^DV-\\d{4}$";
    //    mã dịch vụ
    public static final String REGEX_NOT_NULL = "^.+$";


    public static boolean regex(String regex, String string) {
        return Pattern.matches(regex, string);
    }

    public static void main(String[] args) {
        boolean a = Pattern.matches(REGEX_PHONE, "abc");
        boolean b = Pattern.matches(REGEX_EMAIL, "abc");
        boolean c = Pattern.matches(REGEX_POSITIVE_NUMBER, "abc");
        boolean d = Pattern.matches(REGEX_SERVICE_NAME, "abc");
        boolean e = Pattern.matches(REGEX_PERSON_NAME, "abc");
        boolean f = Pattern.matches(REGEX_ID_NUMBER, "abc");
        boolean v = Pattern.matches(REGEX_NOT_NULL, "abc");
    }
}
