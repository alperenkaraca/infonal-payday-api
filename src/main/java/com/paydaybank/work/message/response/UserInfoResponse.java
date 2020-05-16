package com.paydaybank.work.message.response;

public class UserInfoResponse {
    private String username;
    private String email;
    private String title;

    public UserInfoResponse(String username, String email, String title) {
        this.username = username;
        this.email = email;
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
