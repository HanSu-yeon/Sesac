import java.util.regex.Pattern;

public class  PasswordChecker {

    public static boolean checker(String password) {

        if ("".equals(password)) return false;

        for (int i = 0; i < password.length(); i ++) {
            char c = password.charAt(i);
            if (c < 33 || c > 126) {	// 특수문자, 숫자, 영문자를 제외한 글자 = 제어문자
                return false;
            }
        }

        char firstChar = password.charAt(0);
        if (!Character.isAlphabetic(firstChar))
            return false;

        int charTypeCount = getCharTypeCount(password);
        if (charTypeCount < 2) return false;
        if (charTypeCount == 2 && password.length() < 10) return false;
        if (charTypeCount > 2 && password.length() < 8) return false;

        return true;
    }

    private static int getCharTypeCount(String str) {
        final String SPECIAL_CHAR = "!@#$%^&*";

        boolean hasAlphabetic = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);

            if (Character.isAlphabetic(c)) hasAlphabetic = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (SPECIAL_CHAR.indexOf(c) > 0) hasSpecial = true;
        }

        int charTypeCount = 0;
        if (hasAlphabetic) charTypeCount++;
        if (hasDigit) charTypeCount++;
        if (hasSpecial) charTypeCount++;

        return charTypeCount;
    }


}
