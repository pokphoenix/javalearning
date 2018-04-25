package com.pok.tutorial.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pok.tutorial.web.model.contact.Contact;
import com.pok.tutorial.web.model.contact.ContactForm;

@Controller
public class ContactController {
    private static List<Contact> contacts = new ArrayList<Contact>();

    static {
        contacts.add(new Contact("Barack", "Obama", "barack.o@whitehouse.com", "147-852-965"));
        contacts.add(new Contact("George", "Bush", "george.b@whitehouse.com", "785-985-652"));
        contacts.add(new Contact("Bill", "Clinton", "bill.c@whitehouse.com", "236-587-412"));
        contacts.add(new Contact("Ronald", "Reagan", "ronald.r@whitehouse.com", "369-852-452"));
    }

    @GetMapping("/contact")
    public String index(Locale locale, Model model) {

        ContactForm contactForm = new ContactForm();
        contactForm.setContacts(contacts);

        String word = new String();
        word.equals(word.toLowerCase());

        model.addAttribute("contactForm", contactForm);
        return "contact/add";
    }

    @PostMapping("/contact/create")
    public String store(Locale locale, Model model, ContactForm contactForm) {

        List<Contact> contacts = contactForm.getContacts();

        if (null != contacts && contacts.size() > 0) {
            ContactController.contacts = contacts;
            for (Contact contact : contacts) {
                System.out.printf("%s \t %s \n", contact.getFirstname(), contact.getLastname());
            }
        }

        model.addAttribute("contactForm", contactForm);
        return "contact/index";
    }

}
