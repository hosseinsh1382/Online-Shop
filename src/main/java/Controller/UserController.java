package Controller;

import Exceptions.InvalidEmailException;
import Exceptions.InvalidInputException;
import Exceptions.InvalidPhoneException;
import Model.User.Buyer;
import Model.User.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    private static User loggedInUser = new Buyer("null", null, null, null);
    private static ArrayList<User> users = new ArrayList<>();

    public static void editUsername(String username) {
        loggedInUser.setUsername(username);
    }

    public static void editPassword(String password) throws InvalidInputException {
        if (checkPasswordValidation(password)) {
            loggedInUser.setPassword(password);
        }
    }

    public static void editEmail(String email) throws InvalidEmailException {
        if (checkEmailValidation(email)) {
            loggedInUser.setEmail(email);
        }
    }

    public static void editPhoneNo(String phoneNo) throws InvalidPhoneException {
        if (checkPhoneValidation(phoneNo)) {
            loggedInUser.setPhoneNo(phoneNo);
        }
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

    public static boolean checkPhoneValidation(String phoneNo) throws InvalidPhoneException {
        Pattern pattern = Pattern.compile("^09\\d{9}");
        Matcher matcher = pattern.matcher(phoneNo);
        if (!matcher.find())
            throw new InvalidPhoneException();
        return true;
    }

    public static boolean checkPasswordValidation(String password) throws InvalidInputException {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=().])(?=\\S+$).{8,20}$");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find())
            throw new InvalidInputException("Invalid Password");
        return true;
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

    public static void signUp(String username, String password, String email, String phoneNo) throws InvalidInputException {
        checkEmailValidation(email);
        checkPasswordValidation(password);
        checkPhoneValidation(phoneNo);

        users.add(new Buyer(username, password, email, phoneNo));
    }
}
