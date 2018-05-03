package com.pok.tutorial.web.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NumberController {
    static boolean checkPrime(int n) {
        int i, m = 0, flag = 0;
        m = n / 2;
        if (n == 0 || n == 1) {
            System.out.println(n + " is not prime number");
            return false;
        } else {
            for (i = 2; i <= m; i++) {
                if (n % i == 0) {
                    System.out.println(n + " is not prime number");
                    return false;
                    // flag = 1;
                    // break;
                }
            }
            if (flag == 0) {
                System.out.println(n + " is prime number");
                return true;
            }
        } // end of else
        return false;
    }

    @GetMapping("/prime-number")
    public String primeNumber(Locale locale, Model model) {
        checkPrime(1);
        checkPrime(3);
        checkPrime(17);
        checkPrime(20);

        return "home";
    }

    @GetMapping("/armstrong-number")
    public String armStrongNumber(Locale locale, Model model) {
        int c = 0, a, temp;
        int n = 153;// It is the number to check armstrong
        temp = n;
        while (n > 0) {
            System.out.println("n =" + n);
            a = n % 10;
            System.out.println("a = n % 10 = " + a);
            n = n / 10;
            System.out.println(" n = n / 10 = " + n);
            System.out.println("c =" + c);
            c = c + (a * a * a);
            System.out.println("  c + (a * a * a) " + c);
            System.out.println("--------------------");
        }
        if (temp == c)
            System.out.println(temp + " is armstrong number");
        else
            System.out.println(temp + " is Not armstrong number");

        return "home";
    }

    static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }

    @GetMapping("/factorial-number")
    public String factorialNumber(Locale locale, Model model) {

        int i, fact = 1;
        int number = 4;// It is the number to calculate factorial
        fact = factorial(number);
        System.out.println("Factorial of " + number + " is: " + fact);

        return "home";
    }

    @GetMapping("/palindrome")
    public String index(Locale locale, Model model) {
        String word = "Deleveled";
        word = word.toLowerCase();
        String reverse = "";
        int length = word.length();

        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + word.charAt(i);

        System.out.println("word :" + word);
        System.out.println("reverse :" + reverse);

        if (word.equals(reverse))
            System.out.println("true :" + true);
        else
            System.out.println("false :" + false);

        String a = "ABCD";
        String b = a.toLowerCase();
        String c = b.replace('a', 'd');
        String d = c.replace('b', 'c');

        System.out.println(c);
        System.out.println(d);

        StringBuffer text = new StringBuffer("england");
        StringBuffer out = text.reverse();
        System.out.println("convert : " + out.toString());

        return "contact/add";
    }
}
