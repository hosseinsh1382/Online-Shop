package Controller;

import Exceptions.InvalidEmailException;
import Exceptions.InvalidPhoneException;
import Model.User.Buyer;
import Model.User.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    private static User loggedInUser = null;
    private static ArrayList<User> users = new ArrayList<>();

    public static void editUsername(User user, String username) {
        user.setUsername(username);
    }

    public static void editPassword(User user, String password) {
        user.setPassword(password);
    }

    public static void editEmail(User user, String email) {
        user.setEmail(email);
    }

    public static void editPhoneNo(User user, String phoneNo) {
        user.setPhoneNo(phoneNo);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        UserController.loggedInUser = loggedInUser;
    }

    public static boolean CheckUserExisting(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                loggedInUser.equals(u);
                return true;
            }
        }
        return false;
    }

    public static boolean checkEmailValidation(String email) throws InvalidEmailException {
        Pattern pattern = Pattern.compile("^\\w+@\\w+\\.\\w+");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.find())
            throw new InvalidEmailException();
        return true;
    }

    public static boolean checkPhoneValidation(String email) throws InvalidPhoneException {
        Pattern pattern = Pattern.compile("^09\\d{11}");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.find())
            throw new InvalidPhoneException();
        return true;
    }

    public static boolean checkPasswordValidation(String email) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public static boolean login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                loggedInUser = u;
                return true;
            }
        }
        return false;
    }

    public static void signUp(String username, String password, String email, String phoneNo) throws InvalidPhoneException, InvalidEmailException {
        checkEmailValidation(email);
        checkPasswordValidation(password);
        checkPhoneValidation(phoneNo);

        users.add(new Buyer(username,password,email,phoneNo));
    }
}
