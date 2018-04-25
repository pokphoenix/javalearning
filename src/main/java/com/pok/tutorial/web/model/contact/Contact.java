package com.pok.tutorial.web.model.contact;

import lombok.Data;

@Data
public class Contact {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public Contact() {
    }

    public Contact(String firstname, String lastname, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }

}
