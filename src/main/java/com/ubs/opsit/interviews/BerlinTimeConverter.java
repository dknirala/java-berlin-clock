package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.BerlinClockValidationUtil.*;
import static com.ubs.opsit.interviews.TimeUtility.*;

/**
 * This class provides the actual implementation of berlin clock.
 * This class will responsible for
 *  1. Validation
 *  2. Convert input time to berlin time representation.
 */
public class BerlinTimeConverter implements TimeConverter{

	public String convertTime(String time) {
		// validations 
		validateForNullAndEmpty(time);
		validateForInvalidTimeFormat(time);
		validateForNumbericValueAndBoundryCondition(time);			

		// conversion logic 
		return convertToBerlinTime(time);
	}
}
