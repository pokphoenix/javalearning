package com.pok.tutorial.web.controller;

import java.util.Locale;
import java.util.StringTokenizer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test-vertice")
    public String test(Locale locale, Model model) {

        String master = "abcdefghijklmnopqrstuvwxyz";
        master.length();
        System.out.println(master.length());

        String page = "POK AHA PHIX PHOENIX";

        String[] arrays = page.split(" ", -1);
        for (String array : arrays) {

            String name = array.toLowerCase();

            int l = name.length();
            // System.out.println("length : " + l);
            Integer nameValue = 0;
            for (int i = 0; i < l; i++) {
                int index = (master.indexOf(name.charAt(i))) + 1;
                System.out.println(name.charAt(i) + " " + index);
                nameValue += index;
            }
            System.out.println("get name : " + array + " length : " + l + " value : " + nameValue);

        }

        // model.addAttribute("customFunction", true);
        return "home";
    }

    @GetMapping("/test-vertice2")
    public String test2(Locale locale, Model model) {

        String master = "abcdefghijklmnopqrstuvwxyz";
        master.length();
        System.out.println(master.length());

        StringTokenizer page = new StringTokenizer("POK AHA PHIX PHOENIX", " ");
        while (page.hasMoreTokens()) {

            String name = page.nextToken().toLowerCase();

            int l = name.length();
            // System.out.println("length : " + l);
            Integer nameValue = 0;
            for (int i = 0; i < l; i++) {
                int index = (master.indexOf(name.charAt(i))) + 1;
                System.out.println(name.charAt(i) + " " + index);
                nameValue += index;
            }
            System.out.println("get name : " + name + " length : " + l + " value : " + nameValue);

        }

        // model.addAttribute("customFunction", true);
        return "home";
    }
}
