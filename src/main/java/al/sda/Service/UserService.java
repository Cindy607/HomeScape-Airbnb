package al.sda.Service;

import al.sda.Dao.UserDAO;
import al.sda.Entities.Client;
import al.sda.Entities.Host;
import al.sda.Entities.User;
import al.sda.Functionalities.Validations;
import java.util.List;

public class UserService {
    private UserDAO userDAO;
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(String name, String email, String password, String role) {
        if (!Validations.isValidName(name)) {
            System.out.println("Invalid name. Only letters allowed.");
            return;
        }
        if (!Validations.isValidEmail(email)) {
            System.out.println("Invalid email format.");
            return;
        }
        if (!Validations.isValidPassword(password)) {
            System.out.println("Invalid password. Must have at least 6 characters, one uppercase, and one number.");
            return;
        }
        if (userDAO.findUserByEmail(email) != null) {
            System.out.println("Email already registered!");
            return;
        }
        String userId = generateUserId();
        User newUser;
        if (role.equalsIgnoreCase("host")) {
            newUser = new Host(userId, name, email, password);
        } else if (role.equalsIgnoreCase("client")) {
            newUser = new Client(userId, name, email, password);
        } else {
            System.out.println("Invalid role. Must be 'host' or 'client'.");
            return;
        }
        userDAO.addUser(newUser);
        System.out.println("Registration successful! Welcome, " + name);
    }

    public User loginUser(String email, String password) {
        User user = userDAO.findUserByEmail(email);
        if (user == null) {
            System.out.println("No user found with this email.");
            return null;
        }
        if (!user.getPassword().equals(password)) {
            System.out.println("Incorrect password.");
            return null;
        }
        System.out.println("Login successful. Welcome back, " + user.getName() + "!");
        return user;
    }

    public User findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }

    private String generateUserId() {
        return "U" + System.currentTimeMillis();
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}









