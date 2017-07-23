/**
 * @author R. Logan Snyder
 * <p> TimeParser
 * <p> Parses a military time and gives it back phonetically, ex: 21:04 outputs "It's nine oh four P.M"
 */

public class TimeParser
{
	// Convention: Use underscores (_) to denote class-level variables aka fields
	private int _firstNumber; // The # before the colon; Ex: if time is 21:04, this would store 21.
	private int _secondNumber; // The # after the colon; Ex: if time is 21:04, this would store 04.
	private boolean _am; // true if time is 11:59 or less
	private boolean _pm; // true if time is 12:00 or greater
	
	/**
	 * Initializes all fields to their default values.
	 */
	public TimeParser (int firstNum, int secondNum)
	{
		_firstNumber = firstNum;
		_secondNumber = secondNum;
		_am = false;
		_pm = false;
	}
	
	//TODO: Validation of time input, if not an integer and not and within valid range, inform user input is invalid and loop back to providing another time.
	//TODO: Figure out how to fix weird input format requirement. User must input, for example, "21:04:" instead of "21:04" because of a delimiter issue.
	
	/**
	 * Turns the first number of the time provided (# before the colon) and changes it to a string representation, i.e "08" = "eight".
	 * @return The first number in its phonetic / string representation.
	 */
	private String firstNumPhonetically ()
	{
		// An array of all possible strings the first number could be. The first one is twelve, as that is at index 0 in the array, and 0 in military time corresponds to 12.
		// Other than twelve, all strings correspond to their index in the list, which I use below to match the number with its corresponding string
		String[] times = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"};
		
		String firstNumPhonetically;
		
		// If the number is at or below 11, the number directly corresponds to it's index in the array, i.e "8" is at index 8 in the times array.
		// so "0" = "Twelve" = times[0], "1" = "One" = times[1] and so on.
		if (_firstNumber <= 11)
		{
			firstNumPhonetically = times[_firstNumber];
		}
		else 
		{
			// If the first number provided is greater than 11, I simply subtract 12 and do the same thing I did in the previous if statement body.
			// so "12" = 12 - 12 = 0 = times[0], "13" = 13 - 12 = 1 = times[1] and so on.
			firstNumPhonetically = times[_firstNumber - 12];
		}
		
		return firstNumPhonetically;
	}
	
	/**
	 * Turns the second number of the time provided (# after the colon) and changes it to a string representation, i.e "08" = "eight".
	 * @return The second number in its phonetic / string representation.
	 */
	private String secondNumPhonetically()
	{
		// Another array of all possible strings, this time for what the second number could be. The first one, at index 0, is "o'clock" as 00 corresponds to o'clock
		// when representing a time phonetically. Ex: if it's 3:00 P.M, and someone asks you the time, you respond "it's 3 o'clock", not "it's 3 zero zero".
		String[] times = {"o'clock", "oh one", "oh two", "oh three", "oh four", "oh five", "oh six", "oh seven", "oh eight", "oh nine", "Ten", "eleven",
				"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
				"twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", 
				"twenty eight", "twenty nine", "thirty", "thirty one", "thirty two", "thirty three", "thirty four", "thirty five", "thirty six", 
				"thirty seven", "thirty eight", "thirty nine", "forty", "forty one", "forty two", "forty three",
				"forty four", "forty five", "forty six", "forty seven", "forty eight", "forty nine", "fifty", "fifty one",
				"fifty two", "fifty three", "fifty four", "fifty five", "fifty six", "fifty seven", "fifty eight", "fifty nine"};
		
		String secondNumPhonetically = times[_secondNumber];
		
		return secondNumPhonetically;
	}
	
	/**
	 * Determines if the time is in AM or PM.
	 */
	private void determineAMPM ()
	{
		// If the first number is <= 11, it must be A.M.
		if (_firstNumber <= 11)
		{
			_am = true;
		}
		// If it is any other number (12 - 23) it must be P.M.
		else 
		{
			_pm = true;
		}
	}
	
	/**
	 * Provides the final output in it's phonetic representation.
	 * The reason this is not a toString method is because this object is a parser, not a time data structure, although maybe it should be...
	 * @return phonetic representation of military time provided.
	 */
	public String phoneticRepresentation()
	{
		String firstNumPhonetically = firstNumPhonetically();
		String secondNumPhonetically = secondNumPhonetically();
		String AMorPM;
		
		determineAMPM();
		
		if (_am == true)
		{
			AMorPM = "am";
		}
		else
		{
			AMorPM = "pm";
		}
		
		if (_firstNumber == 0 && _secondNumber == 0)
		{
			return "It's midnight, 2spooky4u.";
		}
		else if (_firstNumber == 12 && _secondNumber == 0)
		{
			return "It's noon.";
		}
		else
		{
			return "It's "+ firstNumPhonetically + " " + secondNumPhonetically + " " + AMorPM + ".";
		}
	}
}
