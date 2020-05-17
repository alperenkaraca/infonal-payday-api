package com.paydaybank.work.message.response;

public class UserInfoResponse {
    private String username;
    private String email;
    private String title;
    private Long id;

    public UserInfoResponse(String username, String email, String title, Long id) {
        this.username = username;
        this.email = email;
        this.title = title;
        this.id = id;
    }

    public UserInfoResponse()
    {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
