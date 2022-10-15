package main.java.model;

import java.util.Objects;

public class Authentication {
    private int loginId;
    private String username;
    private String userPassword;


    public Authentication(int id, String username , String userPassword){
        this.loginId=id;
        this.username=username;
        this.userPassword=userPassword;
    }

    public int getLoginId(){
        return loginId;
    };

    public void setLoginId(int loginId){
        this.loginId=loginId;
    };

    public String getUsername(){
        return username;
    };

    public void setUsername(String username){
        this.username=username;
    };

    public String getUserPassword(){
        return userPassword;
    };

    public void setUserPassword(String userPassword){
        this.userPassword=userPassword;
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginId);
    }
    @Override
    public String toString() {
        return "authentication{" +
                "username='" + username + '\'' +
                '}';
    }
}

