package nit.com.onlinedoctorappointment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nareshit on 23-Nov-16.
 */

public class StringUtils {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

     StringUtils(){

    }

    /**
     * For empty string and null string false is returned
     * @param s
     * @return true if passed string is not null and empty.
     */
    public static boolean isValidString(String s){
        return s!=null && !("".equals(s.trim()));
    }







    /**
     * Validate hex with regular expression
     *
     * @param hex
     *            hex for validation
     * @return true valid hex, false invalid hex
     */
    public  boolean validate(final String hex) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}
