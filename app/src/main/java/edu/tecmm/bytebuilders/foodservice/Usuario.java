package edu.tecmm.bytebuilders.foodservice;

public class Usuario {
    private String userName;
    private String userEmail;
    private String userPassword;

    public Usuario(){

    }
    public Usuario(String name, String email, String password){
        userName=name;
        userEmail=email;
        userPassword=password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
