package Model.User;

public abstract class User {
    public enum Roll {
        ADMIN,
        BUYER
    }

    private String username, password, email, phoneNo;
    private Roll roll;

    public User(String username, String password, String email, String phoneNo, Roll roll) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNo = phoneNo;
        this.roll = roll;
    }

    // SETTERS
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    // GETTERS
    public String getEmail() {
        return email;
    }

    public Roll getRoll() {
        return roll;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "username:'" + username + '\'' +
                ", password:'" + password + '\'' +
                ", email:'" + email + '\'' +
                ", phoneNo:'" + phoneNo + '\'' +
                ", roll:" + roll ;
    }
}
