import java.util.Objects;

public class Validator {
    private static final String VALID_SIMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";
    private Validator() {
    }
    public static boolean check(String login,
                                String password,
                                String confirmPassword) {

        try {
            validate(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;

        }
    }

    private static void validate(String login,
                                 String password,
                                 String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть меньше 20 знаков");
        }
        if (!containsValidSymbols(login)) {
            throw new WrongLoginException("Логин содержит недопустимые символы!");
        }
        if (isNotValidPassword(password) || isNotValidPassword(confirmPassword))
            if (!containsValidSymbols(password)) {
                throw new WrongLoginException("Пароль содержит недопустимые символы!");

            }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать");
        }
    }

    private static boolean isNotValidPassword(String password) {
        return Objects.isNull(password) || password.length() >= 20;
    }

    private static boolean containsValidSymbols(String s) {
        char[] symbols = s.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            for (char symbol : symbols) {
                if (!VALID_SIMBOLS.contains(String.valueOf(symbol))) {
                    return false;
                }
            }
        }
        return true;
    }
}
