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
		// System.out.println(wholeExpression);
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
		
		
		// whole and fraction
		if (firstOperand.contains("_")) {
			
			int slashIndex = firstOperand.indexOf("/");
			int underIndex = firstOperand.indexOf("_");
			String whole1 = firstOperand.substring(0,underIndex);
			int w1 = Integer.parseInt(whole1);
			
			String numerator1 = firstOperand.substring(underIndex + 1, slashIndex);
			//int n1 = Integer.parseInt(numerator1);

			String denominator1 = firstOperand.substring(slashIndex + 1);
			int d1 = Integer.parseInt(denominator1);
			//String firstOperandInfo = ("\"whole:" + w1 + "numerator:" + n1 + "denominator:" + d1);
//			
		}
		// just fraction
		if (!firstOperand.contains("_") && firstOperand.contains("/")) {
			int slashIndex = firstOperand.indexOf("/");
			String numerator1 = firstOperand.substring(0, slashIndex);
			//System.out.println("The numerator is " + numerator1);
			//int n1 = Integer.parseInt(numerator1);
			String denominator1 = firstOperand.substring(slashIndex+1);
			int d1 = Integer.parseInt(denominator1);
			int w1 = 0;
			//String firstOperandInfo = ("\"whole:" + w1 + "numerator:" + n1 + "denominator:" + d1);
			
		}
		
		// just whole number
		if (!firstOperand.contains("_") && !firstOperand.contains("/")) {
			
			String whole1 = firstOperand.substring(0, spaceOneIndex);
			//int w1 = Integer.parseInt(whole1);
			int n1 = 0;
			int d1 = 1;
			//String firstOperandInfo = ("\"whole:" + w1 + "numerator:" + n1 + "denominator:" + d1);
		}

		
			
		System.out.println();
		int operatorIndex = spaceOneIndex + 1;
		wholeExpression.charAt(operatorIndex);

		
		
		
		
		
		// second operand stuff
		String secondOperand = wholeExpression.substring(operatorIndex + 2);
		String secondOperandInfo = "";
		// mixed
		if (secondOperand.contains("_") && secondOperand.contains("/")) {
			int slashIndex = secondOperand.indexOf("/");
			int underIndex = secondOperand.indexOf("_");
			String whole2 = secondOperand.substring(0,underIndex);
			int w2 = Integer.parseInt(whole2);
			
			String numerator2 = secondOperand.substring(underIndex + 1, slashIndex);
			int n2 = Integer.parseInt(numerator2);

			String denominator2 = secondOperand.substring(slashIndex + 1);
			int d2 = Integer.parseInt(denominator2);
			secondOperandInfo = ("whole:" + w2 + " numerator:" + n2 + " denominator:" + d2);
			
		}
		
			
		
		
		// just fraction
		if (!secondOperand.contains("_") && secondOperand.contains("/")) {
			int slashIndex = secondOperand.indexOf("/");
			String numerator2 = secondOperand.substring(0, slashIndex);
			int n2 = Integer.parseInt(numerator2);

			String denominator2 = secondOperand.substring(slashIndex + 1);
			int d2  = Integer.parseInt(denominator2);
			int w2 = 0;
			secondOperandInfo = ("whole:" + w2 + " numerator:" + n2 + " denominator:" + d2);
			
		}
		
		
		// just whole number
		
		if (!secondOperand.contains("_") && !secondOperand.contains("/")) {
			String whole2 = secondOperand.substring(0);
			int w2 = Integer.parseInt(whole2);
			int n2 = 0;
			int d2 = 1;
			secondOperandInfo = ("whole:" + w2 + " numerator:" + n2 + " denominator:" + d2);
		

		}
		return secondOperandInfo;
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
