package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.BerlinClockValidationUtil.*;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * @author Deepak Nirala
 *
 * This JUnit class is used to test validation scenarios
 *
 */
public class BerlinClockValidationUtilTest {

	/**
	 * This method will test the null or empty time string input .
	 */
	@Test(expected=IllegalArgumentException.class)
    public void validateForNull() {
 		 validateForNullAndEmpty(null);
 		 validateForNullAndEmpty("");
    }

	/**
	 * This method will validate the invalid input format of user entered time value
	 * Example :
	 */
 	@Test(expected=IllegalArgumentException.class)
 	public void validateTestForInvalidTimeFormat() {
 		validateForInvalidTimeFormat("23:40");
 		validateForInvalidTimeFormat("23");
 	}

 	/**
	 * This will test for valid time ;
	 * Example :
	 */
 	@Test
 	public void validateTestForValidTimeFormat() {
 		assertTrue("23:34:56",true);
 		assertTrue("23:34:66",true);
 	}

 	@Test(expected=IllegalArgumentException.class)
 	public void validateTestForNumbericValueAndBoundryCondition() {
 		validateForNumbericValueAndBoundryCondition("50:40:32");
 		validateForNumbericValueAndBoundryCondition("50:87:32");
 		validateForNumbericValueAndBoundryCondition("50:40:78");
 		validateForNumbericValueAndBoundryCondition("abc:def:geg");
 	}
}
