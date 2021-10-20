package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountExample {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String ACOUNT_REGEX = "[^0-9]{6,}$";

    public AccountExample() {
        pattern = pattern.compile(ACOUNT_REGEX);
    }

    public boolean validateId(String regex){
        matcher = pattern.matcher (regex);
        return matcher.matches();
    }
}
