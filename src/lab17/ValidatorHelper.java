package lab17;
import java.util.Scanner;

public class ValidatorHelper {
	
	public static boolean getYesNo(Scanner scnr, String prompt) {
		System.out.print(prompt);
		String yesOrNo = scnr.next();
		boolean goAgain = true;
		if (yesOrNo.equalsIgnoreCase("yes")|| yesOrNo.equalsIgnoreCase("no")) {
			if (yesOrNo.equalsIgnoreCase("yes")){
				return goAgain;
			}else {
				return goAgain = false;
			}
		 
	}else {
		return getYesNo(scnr, yesOrNo);
	}
	}
	
	
	
	public static int getInt(Scanner scnr, String prompt) {
		System.out.print(prompt);
		boolean isValid = scnr.hasNextInt();
		while (!isValid) { // keep looping as long as they enter something invalid
			scnr.nextLine(); // advance the scanner past the bad input
			System.out.println("Oops. That's not a valid number. Please enter a number without decimals.");
			System.out.print(prompt);
			isValid = scnr.hasNextInt();
		}
		return scnr.nextInt();
	}
	
	public static Double getDouble(Scanner scnr, String prompt) {
		System.out.print(prompt);
		boolean isValid = scnr.hasNextDouble();
		while (!isValid) { // keep looping as long as they enter something invalid
			scnr.nextLine(); // advance the scanner past the bad input
			System.out.println("Oops. That's not a valid number. Please enter a number without decimals.");
			System.out.print(prompt);
			isValid = scnr.hasNextDouble();
		}
		return scnr.nextDouble();
	}
	
	public static int getIntAtOrAbove(Scanner scnr, String prompt, int minValue) {
		int input = getInt(scnr, prompt);
		if (input < minValue) {
			System.out.println("Oops. The number must be at least " + minValue);
			return getIntAtOrAbove(scnr, prompt, minValue);
		} else {
			return input;
		}
	}

	public static String getString(Scanner scnr, String prompt) {
		System.out.print(prompt);
		return scnr.next();
	}
}