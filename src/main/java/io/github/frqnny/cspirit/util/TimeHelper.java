package io.github.frqnny.cspirit.util;

import java.util.Calendar;

public class TimeHelper {

    public static int getCurrentDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    public static String getFormattedDay(int day) {

        String[] sufixes = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
        return switch (day % 100) {
            case 11, 12, 13 -> day + "th";
            default -> day + sufixes[day % 10];
        };
    }
}
