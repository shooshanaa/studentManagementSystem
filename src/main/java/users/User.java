package users;

import java.util.UUID;

public class User {
    private final UUID id;
    private String name;
    private UserTypes userType;
    private String userName;
    private String password;

    public User(UUID id, String name, UserTypes userType, String userName, String password) {
        this.id = id;
        this.name = name;
        this.userType = userType;
        this.userName = userName;
        this.password = password;
    }

    public User(String name, UserTypes userType, String userName, String password){
        this.id= UUID.randomUUID();
        this.name = name;
        this.userType = userType;
        this.userName = userName;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
       this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserTypes getUserType() {
        return userType;
    }

    public void setUserType(UserTypes userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    protected boolean verifyPassword(String password) {
        return this.password.equals(password);
    }
}
