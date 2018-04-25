package com.pok.tutorial.web.utility;

import com.github.marlonlom.utilities.timeago.TimeAgo;

public class Functions {

    public static String getSum(int x, int y) {
        int sum = x + y;
        return sum + "";
    }

    public static String hello(String t) {
        return "Hello " + t;
    }

    public static Integer randomInteger(Integer max, Integer min) {
        return ((int) (Math.random() * (max - min))) + min;
    }

    public static String daysUntilToday(long timeInMillis) {

        // Long timeInMillis = System.currentTimeMillis();

        return TimeAgo.using(timeInMillis);
    }

}
