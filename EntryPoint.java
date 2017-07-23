/**
 * @author R. Logan Snyder
 * <p> EntryPoint
 * <p> User inputs a time in military format, and gets a phonetic representation back. Ex: 21:04 = "It's nine oh four P.M"
 * <p> Challenge source: https://www.reddit.com/r/dailyprogrammer/comments/6jr76h/20170627_challenge_321_easy_talking_clock/
 */

import java.util.Scanner;

public class EntryPoint
{
	
	public static void main (String[] args)
	{
		
		int firstNum; // Used to store the first number before the colon in the time provided
		int secondNum; // Used to store the second number after the colon in the time provided
		
		Scanner input = new Scanner(System.in);
		input.useDelimiter(":"); // A colon is used as the delimiter to separately store the first and second number.
		
		// Prompts the user for a time and then stores them in the appropriate variables.
		System.out.print("Enter any time in military format: ");
		firstNum = input.nextInt();
		secondNum = input.nextInt();
		
		// constructs a TimeParser object with the numbers provided in the time to parse the time.
		TimeParser parser = new TimeParser(firstNum, secondNum);
		
		// Gives one line of whitespace then outputs the phonetic representation of the time provided.
		System.out.println();
		System.out.print(parser.phoneticRepresentation());
		
		input.close();
		
	}
	
}
