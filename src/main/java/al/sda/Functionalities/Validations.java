package al.sda.Functionalities;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validations {
    // Validon një email me regex të avancuar
    public static boolean isValidEmail(String email) {
        // Regex për të verifikuar email më profesional
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    // Validon që passwordi të ketë të paktën 6 karaktere, një shkronjë të madhe dhe një numër
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 6) {
            return false;
        }
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d).{6,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    // Validon që emri të ketë vetëm shkronja
    public static boolean isValidName(String name) {
        String nameRegex = "^[A-Za-z]+$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    // Validon që mbiemri të ketë vetëm shkronja
    public static boolean isValidSurname(String surname) {
        String surnameRegex = "^[A-Za-z]+$";
        Pattern pattern = Pattern.compile(surnameRegex);
        Matcher matcher = pattern.matcher(surname);
        return matcher.matches();
    }
}




