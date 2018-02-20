package fr.polytech.ihm.Model;

public class LoginCheck {

    private String username;
    private String password;

    public LoginCheck(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        return (username.equals("user") && password.equals("user") || this.isAdmin());
    }

    public boolean isAdmin() {
        return (username.equals("admin") && password.equals("admin"));
    }
}
