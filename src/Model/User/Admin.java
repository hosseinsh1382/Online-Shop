package Model.User;

public class Admin extends User {
    Admin admin = new Admin("admin", "admin", "admin@gmial.com", "09370248298");

    private Admin(String username, String password, String email, String phoneNo) {
        super(username, password, email, phoneNo, Roll.ADMIN);
    }

}
