package com.learning.sharefeeds;

public class User {
    private String userName;
    private String emailId;
    private String password;

    public User(){
      this.userName="";
      this.emailId="";
      this.password="";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }
}