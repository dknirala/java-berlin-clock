package com.ubs.opsit.interviews;

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

    public static Integer[] getTimeUnits(String aTime) {
        String[] time = aTime.split(SEMI_COLON);

        Integer[] timeUnitValue = new Integer[THREE];
        timeUnitValue[ZERO] = Integer.parseInt(time[ZERO]);
        timeUnitValue[ONE] = Integer.parseInt(time[ONE]);
        timeUnitValue[TWO] = Integer.parseInt(time[TWO]);
        return timeUnitValue;
    }

    public static String convertToBerlinTime(String aTime) {
        Integer[] splitTime = getTimeUnits(aTime);

        return getSecond(splitTime[TWO]) + LINE_SEPARATOR +
                getHourTopRow(splitTime[ZERO]) + LINE_SEPARATOR +
                getHourBottomRow(splitTime[ZERO]) + LINE_SEPARATOR +
                geMinutesTopRow(splitTime[ONE]) + LINE_SEPARATOR +
                geMinutesBottomRow(splitTime[ONE]);
    }
}
