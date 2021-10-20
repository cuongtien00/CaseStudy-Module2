package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordExample {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String PASSWORD_REGEX = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$";

    public PasswordExample() {
        pattern = pattern.compile(PASSWORD_REGEX);
    }
    public boolean validatePassword(String regex){
        matcher = pattern.matcher (regex);
        return matcher.matches();
    }
}
