package com.pok.tutorial.web.model.input;

public class NumericInput extends TextInput {
    public void add(char i) {
        if (Character.isDigit(i)) {
            c += Character.toString(i);
        }

    }
}
