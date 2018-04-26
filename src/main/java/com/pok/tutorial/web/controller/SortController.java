package com.pok.tutorial.web.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SortController {

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {

                System.out.println(arr[j - 1] + " : " + arr[j]);

                if (arr[j - 1] > arr[j]) {
                    // swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    System.out.println(" swap : " + arr);
                }

            }
        }

    }

    @GetMapping("/sort-bubble")
    public String primeNumber(Locale locale, Model model) {
        int arr[] = { 3, 60, 35, 2, 45, 320, 5 };

        System.out.println("Array Before Bubble Sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        bubbleSort(arr);// sorting array elements using bubble sort

        System.out.println("Array After Bubble Sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        return "home";
    }

    public static int getThirdLargest(int[] a, int total) {
        int temp;
        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                System.out.println(a[i] + " : " + a[j]);
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    System.out.println("swap : " + a[i] + " : " + a[j] + " = ");

                    for (int k : a) {
                        System.out.print(k + " ");
                    }
                    System.out.println(" ");

                }
            }
        }
        return a[total - 3];

        /*
         * //or Arrays.sort(a); return a[total-3];
         */

    }

    @GetMapping("/third-largest-number")
    public String thirdLargestNumber(Locale locale, Model model) {
        int a[] = { 1, 2, 5, 6, 3, 2 };
        int b[] = { 44, 66, 99, 77, 33, 22, 55 };
        System.out.println("Third Largest: " + getThirdLargest(a, 6));
        System.out.println("Third Largest: " + getThirdLargest(b, 7));

        return "home";
    }

}
