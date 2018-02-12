package fr.polytech.ihm.Model;

public class LoginCheck {

    private String username;
    private String password;

    public LoginCheck(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        if(username.equals("user") && password.equals("user") || this.isAdmin())
            return true;
        return false;
    }

    public boolean isAdmin() {
        if(username.equals("admin") && password.equals("admin"))
            return true;
        return false;
    }
}
