/**
 * @author Mr. Rasmussen
 */
package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		System.out.println("Let's use the fraction calculator or type quit if not");
		Scanner expressionScanner = new Scanner(System.in);
		String wholeExpression = expressionScanner.nextLine();
		if (wholeExpression.equals("quit")) {
			System.out.print("See you l8er");
		}

		// while(!wholeExpression.equals("quit")) {
		//System.out.println(wholeExpression);
		String secondOperand = produceAnswer(wholeExpression);
		System.out.print(secondOperand);
	}

	// }

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String wholeExpression) {
		// TODO: Implement this function to produce the solution to the input
		int spaceOneIndex = wholeExpression.indexOf(' ');

		String firstOperand = wholeExpression.substring(0, spaceOneIndex);
		//System.out.println("first value is " + firstOperand);
		// whole and fraction
		if (firstOperand.contains("_")) {
			String whole1 = firstOperand.substring(0, 1);
			//System.out.println("The whole number in the first operand is  " + whole1);

			String numerator1 = firstOperand.substring(2, 3);
			//System.out.println("The numerator is " + numerator1);

			String denominator1 = firstOperand.substring(4);
			//System.out.println("The denominator is " + denominator1);
		}
		// just fraction
		if (!firstOperand.contains("_") && firstOperand.contains("/")) {
			String numerator1 = firstOperand.substring(0, 1);
			//System.out.println("The numerator is " + numerator1);

			String denominator1 = firstOperand.substring(2);
			//System.out.println("The denominator is " + denominator1);
			// String frac1Num = wholeExpression.substring(3,3);
		}
		// just whole number
		if (!firstOperand.contains("_") && !firstOperand.contains("/")) {
			String whole1 = firstOperand.substring(0, 1);
			//System.out.println("The whole number is " + whole1);
		}

		//System.out.println();
		int operatorIndex = spaceOneIndex + 1;
		//System.out.println("The operator is " + wholeExpression.charAt(operatorIndex) + "\n");

		// second operand stuff
		String secondOperand = wholeExpression.substring(operatorIndex + 2);
		//System.out.println("'" + secondOperand +"'" );
		// mixed
		if (secondOperand.contains("_") && secondOperand.contains("/")) {
			String whole2 = secondOperand.substring(0, 1);
//			System.out.println("The whole number in the first operand is  " + whole2);

			String numerator2 = secondOperand.substring(2, 3);
	//		System.out.println("The numerator is " + numerator2);

			String denominator2 = secondOperand.substring(4);
		//	System.out.println("The denominator is " + denominator2);
		}
		// just fraction
		if (!secondOperand.contains("_") && secondOperand.contains("/")) {
			String numerator2 = secondOperand.substring(0, 1);
			//System.out.println("The numerator is " + numerator2);

			String denominator2 = secondOperand.substring(2);
			//System.out.println("The denominator is " + denominator2);
			// String frac1Num = wholeExpression.substring(3,3);
		}
		// just whole number
		if (!secondOperand.contains("_") && !secondOperand.contains("/")) {
			String whole2 = secondOperand.substring(0);
			//System.out.println(whole2);
		}
		return secondOperand;
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need
	public static void addition(int firstfraction, int secondfraction) {
		System.out.println(firstfraction + secondfraction);
	}

	public static void subtraction(int firstfraction, int secondfraction) {

	}

	public static void division(int firstfraction, int secondfraction) {

	}
}
