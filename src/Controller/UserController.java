package Controller;

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

    public static boolean checkEmailValidation(String email){
        Pattern pattern = Pattern.compile("^\\w+\\@\\w+\\.\\w+");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
    public static boolean checkPhoneValidation(String email){
        Pattern pattern = Pattern.compile("^09\\d{11}");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
    public static boolean checkPasswordValidation(String email){
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
