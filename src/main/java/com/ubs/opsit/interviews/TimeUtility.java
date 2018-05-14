package com.ubs.opsit.interviews;

import java.util.Arrays;

import static com.ubs.opsit.interviews.TimeConstants.*;

public class TimeUtility {

    public static String getSecond(int sec) {
        return (sec % TWO == ONE) ? LAMP_OFF : LAMP_YELLOW;
    }

    public static String getHourTopRow(int hour) {
        int numberOfLampsOn = hour / FIVE;
        return turnNumberOfLampsOnToString(numberOfLampsOn, TimeConstants.LAMP_RED, 4);
    }

    public static String getHourBottomRow(int hour) {
        int numberOfLampsOn = hour % FIVE;
        return turnNumberOfLampsOnToString(numberOfLampsOn, TimeConstants.LAMP_RED, 4);
    }

    public static String geMinutesTopRow(int min) {
        int numberOfLampsOn = min / FIVE;
        return turnNumberOfLampsOnToString(numberOfLampsOn, TimeConstants.LAMP_YELLOW, 11).replaceAll(YYY, YYR);
    }

    public static String geMinutesBottomRow(int min) {
        int numberOfLampsOn = min % FIVE;
        return turnNumberOfLampsOnToString(numberOfLampsOn, TimeConstants.LAMP_YELLOW, FOUR);
    }

    public static String turnNumberOfLampsOnToString(int numberOfLampsOn, String onLampColour, int length) {
        String returnable = BLANK;
        for (int i = ZERO; i < length; i++) {
            if (i < numberOfLampsOn) {
                returnable += onLampColour;
            } else {
                returnable += TimeConstants.LAMP_OFF;
            }
        }
        return returnable;
    }

    public static int[] getTimeUnits(String aTime) {
        return Arrays.stream(aTime.split(SEMI_COLON))
                .filter(word -> !word.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
        }

    public static String convertToBerlinTime(String time) {
        int[] splitTime = getTimeUnits(time);
        StringBuilder berlinTime = new StringBuilder();
        return berlinTime.append(getSecond(splitTime[TWO])).append(LINE_SEPARATOR)
                .append(getHourTopRow(splitTime[ZERO])).append(LINE_SEPARATOR)
                .append(getHourBottomRow(splitTime[ZERO])).append(LINE_SEPARATOR)
                .append(geMinutesTopRow(splitTime[ONE])).append(LINE_SEPARATOR)
                .append(geMinutesBottomRow(splitTime[ONE])).toString();
    }
}
