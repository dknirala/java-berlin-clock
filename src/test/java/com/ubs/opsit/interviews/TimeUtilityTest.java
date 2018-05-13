package com.ubs.opsit.interviews;


import org.junit.Test;

import static com.ubs.opsit.interviews.TimeConstants.*;
import static com.ubs.opsit.interviews.TimeUtility.*;
import static org.junit.Assert.assertEquals;

public class TimeUtilityTest {

    /**
     * Yellow lamp should blink on/off every two seconds
     */
    @Test
    public void testForSecondLampShouldBlinkOnOffEveryTwoSeconds() {
        assertEquals(LAMP_YELLOW, getSecond(0));
        assertEquals(LAMP_OFF, getSecond(1));
        assertEquals(LAMP_OFF, getSecond(59));
    }

    /**
     * This Junit will check top Hour row have 4 lamps
     */
    @Test
    public void testHoursTopRowShouldHaveFourLamps() {
        assertEquals(FOUR, getHourTopRow(9).length());
        assertEquals(FOUR, getHourTopRow(25).length());
    }

    /**
     * Top hour row should light a red lamp for every 5 hours
     */
    @Test
    public void testHoursTopRowShouldLightRedLampForEvery5Hours() {
        assertEquals("OOOO", getHourTopRow(0));
        assertEquals("RROO", getHourTopRow(13));
        assertEquals("RRRR", getHourTopRow(23));
        assertEquals("RRRR", getHourTopRow(24));
    }

    /**
     * Bottom hours should have 4 lamps
     */
    @Test
    public void testHoursBottomRowShouldHave4Lamps() {
        assertEquals(FOUR, getHourBottomRow(FIVE).length());
    }

    /**
     * Bottom hours should light a red lamp for every hour left from top hours
     */
    @Test
    public void testHoursBottomRowShouldLightRedLampForEveryOneHour() {
        assertEquals("OOOO", getHourBottomRow(0));
        assertEquals("RRRO", getHourBottomRow(13));
        assertEquals("RRRO", getHourBottomRow(23));
        assertEquals("RRRR", getHourBottomRow(24));
    }

    /**
     * This will test Top minutes should have 11 lamps
     */
    @Test
    public void testMinutesTopRowShouldHave11Lamps() {
        assertEquals(11, geMinutesTopRow(34).length());
    }

    /**
     * Top minutes should have 3rd, 6th and 9th lamps in red to indicate first quarter, half and last quarter
     */
    @Test
    public void testMinutesTopRowShouldHave_third_six_nineth_LampsInRed() {
        String minutes32 = geMinutesTopRow(40);
        assertEquals(LAMP_RED, minutes32.substring(TWO, THREE));
        assertEquals(LAMP_RED, minutes32.substring(FIVE, SIX));
        assertEquals(LAMP_OFF, minutes32.substring(EIGHT, NINE));
    }

    /**
     * Top minutes should light a yellow lamp for every 5 minutes unless it's first quarter, half or last quarter
     */
    @Test
    public void testMinutesTopRowShouldLightYellowLampForEvery5Minutes() {
        assertEquals(MINUTE_TOP_ROW_ALL_LAMP_OFF ,geMinutesTopRow(0));
        assertEquals("YYROOOOOOOO", geMinutesTopRow(17));
        assertEquals("YYRYYRYYRYY", geMinutesTopRow(59));
    }

    /**
     * Bottom minutes should have 4 lamps
     */
    @Test
    public void testMinutesBottomRowShouldHave4Lamps() {
        assertEquals(4, geMinutesBottomRow(0).length());
    }

    /**
     * Bottom minutes should light a yellow lamp for every minute left from top minutes
     */
    @Test
    public void testBottomMinutesBottomRowShouldLightYellowLampForEveryMinuteLeft() {
        assertEquals("OOOO", geMinutesBottomRow(0));
        assertEquals("YYOO", geMinutesBottomRow(17));
        assertEquals("YYYY", geMinutesBottomRow(59));
    }
}
