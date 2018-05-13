package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.TimeConstants.*;

/**
 * Method Validates the Time It checks for following things:-
 *  1) Checks for Null and empty value of inputTime.
 *  2) Checks for proper valid pattern of time in the form of (hh:mm:ss) and also check for limit value allowed in
 * HH ,MM and SS. For example: 00:00:00 is valid time but 00:00 is not.
 *
 */
public class BerlinClockValidationUtil {


    private static String[] times ;

    public static boolean  validateForNullAndEmpty(String inputTime){

        if(null == inputTime || inputTime.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
        return true;
    }

    /**
     * This method does the validation on input time format
     *
     * Example : 33:44 is invalid time format
     *
     * @param inputTime
     * @return boolean
     */
    public static boolean validateForInvalidTimeFormat(String inputTime){
        times = inputTime.split(SEMI_COLON, THREE);

        if(times.length != THREE) {
            throw new IllegalArgumentException(ERROR_INVALID_TIME_FORMAT);
        }
        return true;
    }

    /**
     * This method does the validation on input time format and boundary conditions
     *
     * Example :
     * a.) ab:33  is invalid
     * b.) 25:35:87   is outside of boundary of hours and seconds since 24 is the max and 59 is the max
     * value for hour and minute and second
     *
     *
     * @param inputTime
     * @return boolean
     */
    public static boolean validateForNumbericValueAndBoundryCondition(String inputTime) {
        int hours, minutes, seconds = ZERO;
        times = inputTime.split(SEMI_COLON, THREE);
        try {
            hours = Integer.parseInt(times[ZERO]);
            minutes = Integer.parseInt(times[ONE]);
            seconds = Integer.parseInt(times[TWO]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_TYPE);
        }

        // Validation for boundary condition
        if (hours < ZERO || hours >TWENTY_FOUR) throw new IllegalArgumentException(HOURS_OUT_OF_BOUND);
        if (minutes < ZERO || minutes > FIFTY_NINE) throw new IllegalArgumentException(MINUTE_OUT_OF_BOUND);
        if (seconds < ZERO || seconds > FIFTY_NINE) throw new IllegalArgumentException(SECOND_OUT_OF_BOUND);

        return true;
    }
}
