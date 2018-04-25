package com.pok.tutorial.web.model.input;

public class TextInput {
    public String c = "";

    public void add(char c) {
        this.c = Character.toString(c);
    }

    public String getValue() {
        return c;
    }
}
