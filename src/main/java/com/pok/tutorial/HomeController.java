package com.pok.tutorial;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pok.tutorial.web.model.Company;
import com.pok.tutorial.web.model.User;
import com.pok.tutorial.web.model.input.NumericInput;
import com.pok.tutorial.web.model.input.TextInput;
import com.pok.tutorial.web.utility.DataResponse;
import com.pok.tutorial.web.utility.Functions;
import com.pok.tutorial.web.utility.GenericData;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

    @GetMapping("/custom-function")
    public String customFunction(Locale locale, Model model) {
        model.addAttribute("customFunction", true);
        return "home";
    }

    @GetMapping("/test-string-to-double")
    public String testStringToDouble(Locale locale, Model model) {
        System.out.println("===== String to Double =====");
        String toBeDouble = "200.20";

        /*
         * long start2 = System.nanoTime(); Double doubleString =
         * Double.parseDouble(toBeDouble); long end2 = System.nanoTime();
         * System.out.println("parseDouble : " + (end2 - start2));
         * 
         * long start3 = System.nanoTime(); Double fromString = new Double(toBeDouble);
         * long end3 = System.nanoTime(); System.out.println("new Double : " + (end3 -
         * start3));
         * 
         * long start = System.nanoTime(); Double doubleStr =
         * Double.valueOf(toBeDouble); long end = System.nanoTime();
         * System.out.println("valueOf : " + (end - start));
         */

        /*
         * long[] a1 = { 3, 4, 5 }; long[] a2 = a1.clone(); a2[1] = 7;
         * 
         * System.out.println(a1[0] + " " + a1[1] + " " + a1[2]);
         * System.out.println(a2[0] + " " + a2[1] + " " + a2[2]);
         * 
         * System.out.print(a1[0] + a1[1] + a1[2] + " "); System.out.println(a2[0] +
         * a2[1] + a2[2]);
         */

        int sum = 0;
        int[] warmup = new int[1];
        warmup[0] = 1;
        for (int i = 0; i < 15000; i++) { // triggers JIT
            sum += copyClone(warmup);
            sum += copyArrayCopy(warmup);
            sum += copyCopyOf(warmup);
        }

        int count = 10_000_000;
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = i;
        }

        // additional warmup for main
        for (int i = 0; i < 10; i++) {
            sum += copyArrayCopy(array);
        }

        long start, end;

        System.gc();
        // copyCopyOf
        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            sum += copyCopyOf(array);
        }
        end = System.nanoTime();
        System.out.println("Arrays.copyOf: " + (end - start));

        System.gc();
        // copyArrayCopy
        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            sum += copyArrayCopy(array);
        }
        end = System.nanoTime();
        System.out.println("arrayCopy: " + (end - start));
        System.gc();
        // copyClone
        start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            sum += copyClone(array);
        }
        end = System.nanoTime();
        System.out.println("clone: " + (end - start));
        // sum
        System.out.println(sum);

        Float f1 = new Float("3.0");
        int x = f1.intValue();
        byte b = f1.byteValue();
        double d = f1.doubleValue();
        System.out.println("int + byte + type");
        System.out.println(x + b + d);

        System.out.println("String equal object");
        String s = "hello";
        Object o = s;
        if (o.equals(s)) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
        if (s.equals(o)) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }

        int n = 153;// It is the number to check armstrong
        int temp = n;
        n = 7;
        System.out.println(n + " : " + temp);

        return "home";
    }

    long[] fix(long[] a3) {
        a3[1] = 7;
        return a3;
    }

    private static int copyClone(int[] array) {
        int[] copy = array.clone();
        return copy[copy.length - 1];
    }

    private static int copyArrayCopy(int[] array) {
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy[copy.length - 1];
    }

    private static int copyCopyOf(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        return copy[copy.length - 1];
    }

    @GetMapping("/convert")
    public String convert(Locale locale, Model model) {

        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());

        model.addAttribute("convert", true);
        return "home";
    }

    @GetMapping("/array")
    public String array(Locale locale, Model model) {

        int[] arr = { 1, 2, 3, 4, 5 };

        List<Integer> arrayList = new ArrayList();

        for (int e : arr) {
            System.out.println(e);
            arrayList.add(e);
        }

        arrayList.add(10);

        model.addAttribute("intArray", arrayList);

        Integer x = 5;
        Integer y = 10;
        Integer z = 5;
        short a = 5;
        int b = 5;

        System.out.println(x.equals(y));
        System.out.println(x.equals(z));
        System.out.println(x.equals(a));
        System.out.println(x.equals(b));
        System.out.println(b == a);

        return "home";
    }

    @GetMapping("/custom-array")
    public String customArray(Locale locale, Model model) {

        List<DataResponse> dataResponse = new ArrayList<DataResponse>();

        dataResponse.add(new DataResponse("string 2", 70));
        dataResponse.add(new DataResponse("string 2", 70));
        dataResponse.add(new DataResponse("string 3", 90));

        model.addAttribute("customArrays", dataResponse);
        /*
         * List<DataResponse> list = new ArrayList<DataResponse>();
         * 
         * DataResponse<Integer, String> dataResponse = new DataResponse();
         * dataResponse.add(Integer.valueOf(10), "Hello World"); list.add(dataResponse);
         * 
         * DataResponse<Integer, String> dataResponse2 = new DataResponse();
         * dataResponse2.add(Integer.valueOf(12), "Hello World2");
         * list.add(dataResponse2);
         */
        //
        // System.out.printf("(CustomList)Integer Value :%d\n", list.get(0));
        // System.out.printf("(CustomList)Integer Value :%d\n", list.get(1));

        // dataResponse.add("string 1", 100);
        // dataResponse.add("string 2", 70);
        // dataResponse.add("string 3", 90);

        // GenericData<DataResponse> list = new GenericData<DataResponse>();

        // model.addAttribute("customArrays", list);

        return "home";
    }

    @GetMapping("/generics")
    public String generic(Locale locale, Model model) {

        List<GenericData> list = new ArrayList<GenericData>();

        GenericData<Integer, String> dataResponse = new GenericData();
        dataResponse.add(Integer.valueOf(10), "Hello World");
        list.add(dataResponse);

        GenericData<Integer, String> dataResponse2 = new GenericData();
        dataResponse2.add(Integer.valueOf(12), "Hello World2");
        list.add(dataResponse2);

        GenericData<String, Integer> dataResponse3 = new GenericData();
        dataResponse3.add("Hello World", Functions.randomInteger(1, 100000));
        list.add(dataResponse3);

        GenericData<String, Integer> dataResponse4 = new GenericData();
        dataResponse4.add("Hello World", Functions.randomInteger(1, 100000));
        list.add(dataResponse4);

        // System.out.printf("(CustomList)Integer Value :%d\n",
        // list.getItem(0).getFirst());

        model.addAttribute("customArrays", list);
        return "home";
    }

    @GetMapping("/sort-generic")
    public String sortGeneric(Locale locale, Model model) {

        Map<String, String> unsortMapString = new HashMap();
        unsortMapString.put("Z", "z");
        unsortMapString.put("B", "b");
        unsortMapString.put("A", "a");
        unsortMapString.put("C", "c");
        unsortMapString.put("D", "d");
        unsortMapString.put("E", "e");
        unsortMapString.put("Y", "y");
        unsortMapString.put("N", "n");
        unsortMapString.put("J", "j");
        unsortMapString.put("M", "m");
        unsortMapString.put("F", "f");

        Map<String, String> sortMapString = new TreeMap(unsortMapString);
        Map<String, String> sortMapStringDESC = new TreeMap(Collections.reverseOrder());
        sortMapStringDESC.putAll(unsortMapString);

        List<GenericData> list = new ArrayList<GenericData>();

        GenericData<String, List<GenericData>> rowString = new GenericData<String, List<GenericData>>();

        List<GenericData> listRowString = new ArrayList<GenericData>();

        GenericData<String, Map> rowUnSortString = new GenericData();
        rowUnSortString.add("UnSortString", unsortMapString);
        listRowString.add(rowUnSortString);

        GenericData<String, Map> rowSortStringASC = new GenericData();
        rowSortStringASC.add("SortStringASC", sortMapString);
        listRowString.add(rowSortStringASC);

        GenericData<String, Map> rowSortStringDESC = new GenericData();
        rowSortStringDESC.add("SortStringDESC", sortMapStringDESC);
        listRowString.add(rowSortStringDESC);

        rowString.add("String", listRowString);
        list.add(rowString);

        Map unsortMapInt = new HashMap();
        unsortMapInt.put(10, "z");
        unsortMapInt.put(5, "b");
        unsortMapInt.put(6, "a");
        unsortMapInt.put(20, "c");
        unsortMapInt.put(1, "d");
        unsortMapInt.put(7, "e");
        unsortMapInt.put(8, "y");
        unsortMapInt.put(99, "n");
        unsortMapInt.put(50, "j");
        unsortMapInt.put(2, "m");
        unsortMapInt.put(9, "f");

        Map sortMapInt = new TreeMap(unsortMapInt);
        Map sortMapIntDesc = new TreeMap(Collections.reverseOrder());
        sortMapIntDesc.putAll(unsortMapInt);

        GenericData<String, List<GenericData>> rowInt = new GenericData<String, List<GenericData>>();

        List<GenericData> listRowInt = new ArrayList<GenericData>();

        GenericData<String, Map> rowUnSortInt = new GenericData();
        rowUnSortInt.add("UnSortInt", unsortMapInt);
        listRowInt.add(rowUnSortInt);

        GenericData<String, Map> rowSortIntASC = new GenericData();
        rowSortIntASC.add("SortIntASC", sortMapInt);
        listRowInt.add(rowSortIntASC);

        GenericData<String, Map> rowSortIntDESC = new GenericData();
        rowSortIntDESC.add("SortIntDESC", sortMapIntDesc);
        listRowInt.add(rowSortIntDESC);

        rowInt.add("Int", listRowInt);

        list.add(rowInt);

        model.addAttribute("genericSort", list);
        return "home";
    }

    @GetMapping("/sort")
    public String sort(Locale locale, Model model) {

        Map<String, String> unsortMap = new HashMap();
        unsortMap.put("Z", "z");
        unsortMap.put("B", "b");
        unsortMap.put("A", "a");
        unsortMap.put("C", "c");
        unsortMap.put("D", "d");
        unsortMap.put("E", "e");
        unsortMap.put("Y", "y");
        unsortMap.put("N", "n");
        unsortMap.put("J", "j");
        unsortMap.put("M", "m");
        unsortMap.put("F", "f");

        Map<String, String> treeMap = new TreeMap(unsortMap);

        Map<GenericData, GenericData> list = new HashMap();

        GenericData<String, String> rowString = new GenericData();
        rowString.add("String", "unsortString");

        GenericData<Object, Integer> dataResponse = new GenericData();
        dataResponse.add(unsortMap, Functions.randomInteger(1, 100000));
        list.put(rowString, dataResponse);

        GenericData<String, String> rowString2 = new GenericData();
        rowString2.add("String", "sortString");

        GenericData<Object, Integer> dataResponse2 = new GenericData();
        dataResponse2.add(treeMap, Functions.randomInteger(1, 100000));
        list.put(rowString2, dataResponse2);

        Map unsortMapInt = new HashMap();
        unsortMapInt.put(10, "z");
        unsortMapInt.put(5, "b");
        unsortMapInt.put(6, "a");
        unsortMapInt.put(20, "c");
        unsortMapInt.put(1, "d");
        unsortMapInt.put(7, "e");
        unsortMapInt.put(8, "y");
        unsortMapInt.put(99, "n");
        unsortMapInt.put(50, "j");
        unsortMapInt.put(2, "m");
        unsortMapInt.put(9, "f");

        Map treeMapInt = new TreeMap(unsortMapInt);
        Map treeMapIntDesc = new TreeMap(Collections.reverseOrder());
        treeMapIntDesc.putAll(unsortMapInt);

        GenericData<String, String> rowInt = new GenericData();
        rowInt.add("Int", "unsortInt");

        GenericData<Object, Integer> dataResponseInt = new GenericData();
        dataResponseInt.add(unsortMapInt, Functions.randomInteger(1, 100000));
        list.put(rowInt, dataResponseInt);

        GenericData<String, String> rowSortIntASC = new GenericData();
        rowSortIntASC.add("Int", "sortInt ASC");

        GenericData<Object, Integer> dataResponseSortInt = new GenericData();
        dataResponseSortInt.add(treeMapInt, Functions.randomInteger(1, 100000));
        list.put(rowSortIntASC, dataResponseSortInt);

        GenericData<String, String> rowSortIntDESC = new GenericData();
        rowSortIntDESC.add("Int", "sortInt DESC");

        GenericData<Object, Integer> dataResponseSortIntDESC = new GenericData();
        dataResponseSortIntDESC.add(treeMapIntDesc, Functions.randomInteger(1, 100000));
        list.put(rowSortIntDESC, dataResponseSortIntDESC);

        //
        // long start = System.nanoTime();
        // for (Map.Entry entry : unsortMap.entrySet()) {
        //
        // System.out.println("Key : " + entry.getKey() + " Value : " +
        // entry.getValue());
        // }
        // long end = System.nanoTime();

        // List<,GenericData> list = new ArrayList<GenericData>();
        //
        // GenericData<Object, Integer> dataResponse = new GenericData();
        // dataResponse.add(unsortMap, (int) (end - start));
        // list.add(dataResponse);
        //
        // start = System.nanoTime();

        // for (Map.Entry entry : treeMap.entrySet()) {
        // System.out.println("Key : " + entry.getKey() + " Value : " +
        // entry.getValue());
        // }
        // end = System.nanoTime();

        model.addAttribute("sorts", list);
        return "home";
    }

    @GetMapping("/generic-response")
    public String GenericResponse(Locale locale, Model model) {

        User user = new User();
        user.setId(1);
        user.setName("pok");

        user.setResult(false);
        user.setError("cannot connect database");

        user.setResponse(user);

        Company company = new Company();
        company.setId(12);
        company.setName("Vertice");
        company.setAddress("UBCII");

        company.setResult(true);
        company.setResponse(company);

        Map list = new HashMap();

        list.put("user", user);
        list.put("company", company);

        model.addAttribute("sortGenericJava", list);

        return "home";
    }

}
