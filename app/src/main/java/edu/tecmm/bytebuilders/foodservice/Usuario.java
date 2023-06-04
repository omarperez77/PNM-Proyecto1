package edu.tecmm.bytebuilders.foodservice;

public class Usuario {
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userNamer;

    public Usuario(){

    }
    public Usuario(String name, String email, String password){
        userName=name;
        userEmail=email;
        userPassword=password;

    }
    public Usuario(String name, String email, String password,String username){
        userName=name;
        userEmail=email;
        userPassword=password;
        userNamer = username;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserNamer() {
        return userNamer;
    }

    public void setUserNamer(String username) {
        this.userNamer = userName;
    }
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return userName;
    }
}
