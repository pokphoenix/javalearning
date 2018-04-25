package com.pok.tutorial.web.model;

import com.pok.tutorial.web.master.Result;

import lombok.Data;

@Data
public class Company extends Result<Company> {

    public long id;
    public String name;
    public String address;

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
    //
    // public String getAddress() {
    // return address;
    // }
    //
    // public void setAddress(String address) {
    // this.address = address;
    // }

    @Override
    public Company unmarshall(Company response) {
        return response;
    }

}
