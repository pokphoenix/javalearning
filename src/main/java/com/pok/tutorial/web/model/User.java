package com.pok.tutorial.web.model;

import com.pok.tutorial.web.master.Result;

import lombok.Data;

@Data
public class User extends Result<User> {

    public long id;
    public String name;

    // public long getId() {
    // return id;
    // }
    //
    // public void setId(long id) {
    // this.id = id;
    // }
    //
    // public String getName() {
    // return name;
    // }
    //
    // public void setName(String name) {
    // this.name = name;
    // }

    @Override
    public User unmarshall(User response) {
        return response;
    }

}
