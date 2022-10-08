package com.demo.swagger.users;

import java.util.Date;

public class UserRequest {
    private String name;
    private Date dob;

    public UserRequest() {
        super();
    }

    public UserRequest(String name, Date dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
