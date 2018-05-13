package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;
import static com.ubs.opsit.interviews.TimeConstants.*;

import org.junit.Test;

public class BerlinTimeConverterTest {

    TimeConverter berlinTimeConverter = new BerlinTimeConverter();


    /**
     * Scenario: Midnight
     * When the time is 00:00:00
     * Then the clock should look like
     * Y
     * OOOO
     * OOOO
     * OOOOOOOOOOO
     * OOOO
     */
    @Test
    public void testBerlinClockForMidnight() {
        String berlinTime = berlinTimeConverter.convertTime("00:00:00");
        String[] berlintTimeArray = berlinTime.split("\r\n");

        String[] expectedTimeInArray = new String[]{"Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"};
        assertEquals(expectedTimeInArray.length, berlintTimeArray.length);
        for (int i = 0; i < expectedTimeInArray.length; i++) {
            assertEquals(expectedTimeInArray[i], berlintTimeArray[i]);
        }
    }


    /**
     * Scenario: Middle of the afternoon
     * When the time is 13:17:01
     * Then the clock should look like
     * O
     * RROO
     * RRRO
     * YYROOOOOOOO
     * YYOO
     */

    @Test
    public void testBerlinClockForMiddleOfTheAfterNoon() {

        String berlinTime = berlinTimeConverter.convertTime("13:17:01");
        String[] berlintTimeArray = berlinTime.split("\r\n");

        String[] expectedTimeInArray = new String[]{"O", "RROO", "RRRO", "YYROOOOOOOO", "YYOO"};
        assertEquals(expectedTimeInArray.length, berlintTimeArray.length);
        for (int i = 0; i < expectedTimeInArray.length; i++) {
            assertEquals(expectedTimeInArray[i], berlintTimeArray[i]);
        }
    }

    /**
     * Scenario: Just Before MidNight
     * When the time is 23:59:59
     * Then the clock should look like
     * O
     * RRRR
     * RRRO
     * YYRYYRYYRYY
     * YYYY
     */

    @Test
    public void testBerlinClockForJustBeforeMidNight() {

        String berlinTime = berlinTimeConverter.convertTime("23:59:59");
        String[] berlintTimeArray = berlinTime.split("\r\n");

        String[] expectedTimeInArray = new String[]{"O", "RRRR", "RRRO", "YYRYYRYYRYY", "YYYY"};
        assertEquals(expectedTimeInArray.length, berlintTimeArray.length);
        for (int i = 0; i < expectedTimeInArray.length; i++) {
            assertEquals(expectedTimeInArray[i], berlintTimeArray[i]);
        }
    }


    /**
     * Scenario: For MidNight
     * When the time is 24:00:00
     * Then the clock should look like
     * Y
     * RRRR
     * RRRR
     * OOOOOOOOOOO
     * 0000
     */

    @Test
    public void testBerlinClockForMidNightTime() {

        String berlinTime = berlinTimeConverter.convertTime("24:00:00");
        String[] berlintTimeArray = berlinTime.split("\r\n");

        String[] expectedTimeInArray = new String[]{"Y", "RRRR", "RRRR", MINUTE_TOP_ROW_ALL_LAMP_OFF, "OOOO"};
        assertEquals(expectedTimeInArray.length, berlintTimeArray.length);
        for (int i = 0; i < expectedTimeInArray.length; i++) {
            assertEquals(expectedTimeInArray[i], berlintTimeArray[i]);
        }
    }
}
