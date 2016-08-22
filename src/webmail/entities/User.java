package webmail.entities;

/**
 * Created by JOKER on 10/28/14.
 */
public class User {
    public String username;
    public String password;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String toString() { return username+" :"+password; }
}
