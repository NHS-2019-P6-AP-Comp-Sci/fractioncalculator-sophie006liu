/**
 * @author Mr. Rasmussen
 */
package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		System.out.println("Let's use the fraction calculator or type quit if not");

		Scanner scanner = new Scanner(System.in);
		String wholeExpression = scanner.nextLine();

		while (true) {
			if (wholeExpression.equals("quit")) {
				System.out.println("See you l8er");
				System.exit(0);
			}

			// while(!wholeExpression.equals("quit")) {
			// System.out.println(wholeExpression);
			String result = produceAnswer(wholeExpression);
			System.out.println("Answer:" + result);
			wholeExpression = scanner.nextLine();
		}
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
		String firstOperandInfo = "";

		// whole and fraction
		if (firstOperand.contains("_")) {

			int slashIndex = firstOperand.indexOf("/");
			int underIndex = firstOperand.indexOf("_");
			String whole1 = firstOperand.substring(0, underIndex);
			int w1 = Integer.parseInt(whole1);

			String numerator1 = firstOperand.substring(underIndex + 1, slashIndex);
			int n1 = Integer.parseInt(numerator1);

			String denominator1 = firstOperand.substring(slashIndex + 1);
			int d1 = Integer.parseInt(denominator1);
			firstOperandInfo = mixedNumber(w1, n1, d1);
//			
		}
		// just fraction
		if (!firstOperand.contains("_") && firstOperand.contains("/")) {
			int slashIndex = firstOperand.indexOf("/");
			String numerator1 = firstOperand.substring(0, slashIndex);
			// System.out.println("The numerator is " + numerator1);
			int n1 = Integer.parseInt(numerator1);
			String denominator1 = firstOperand.substring(slashIndex + 1);
			int d1 = Integer.parseInt(denominator1);
			int w1 = 0;
			firstOperandInfo = mixedNumber(w1, n1, d1);

		}

		// just whole number
		if (!firstOperand.contains("_") && !firstOperand.contains("/")) {

			String whole1 = firstOperand.substring(0, spaceOneIndex);
			int w1 = Integer.parseInt(whole1);
			int n1 = 0;
			int d1 = 1;
			firstOperandInfo = mixedNumber(w1, n1, d1);
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
			String whole2 = secondOperand.substring(0, underIndex);
			int w2 = Integer.parseInt(whole2);

			String numerator2 = secondOperand.substring(underIndex + 1, slashIndex);
			int n2 = Integer.parseInt(numerator2);

			String denominator2 = secondOperand.substring(slashIndex + 1);
			int d2 = Integer.parseInt(denominator2);
			secondOperandInfo = mixedNumber(w2, n2, d2);

		}

		// just fraction
		if (!secondOperand.contains("_") && secondOperand.contains("/")) {
			int slashIndex = secondOperand.indexOf("/");
			String numerator2 = secondOperand.substring(0, slashIndex);
			int n2 = Integer.parseInt(numerator2);

			String denominator2 = secondOperand.substring(slashIndex + 1);
			int d2 = Integer.parseInt(denominator2);
			int w2 = 0;
			secondOperandInfo = mixedNumber(w2, n2, d2);

		}

		// just whole number

		if (!secondOperand.contains("_") && !secondOperand.contains("/")) {
			String whole2 = secondOperand.substring(0);
			int w2 = Integer.parseInt(whole2);
			int n2 = 0;
			int d2 = 1;
			secondOperandInfo = mixedNumber(w2, n2, d2);

		}

		String answers = "";
		if (wholeExpression.contains("+")) {
			answers = addition(firstOperandInfo, secondOperandInfo);
		} else if (wholeExpression.contains(" - ")) {
			answers = subtraction(firstOperandInfo, secondOperandInfo);
		} else if (wholeExpression.contains("*")) {
			answers = multiplication(firstOperandInfo, secondOperandInfo);
			System.out.println(answers);
		} else if (wholeExpression.contains("/")) {
			answers = division(firstOperandInfo, secondOperandInfo);
		}
		
		return answers;
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need
	public static String mixedNumber(int w, int n, int d) {
		String sign = "";
		if (w < 0 || n < 0) {
			sign = "-";
		}
		if (w < 0)
			w = 0 - w;
		if (n < 0)
			n = 0 - n;

		int numerator = n + (w * d);
		String strNumerator = Integer.toString(numerator);
		String denominator = Integer.toString(d);
		String mixed = strNumerator + "/" + denominator;

		String res = sign + mixed;
		// System.out.println("mixed number: " + res);
		return res;
	}

	public static String addition(String firstfraction, String secondfraction) {
		int slash1 = firstfraction.indexOf("/");
		String num1 = firstfraction.substring(0, slash1);
		int a = Integer.parseInt(num1);
		String den1 = firstfraction.substring(slash1 + 1);
		int b = Integer.parseInt(den1);

		int slash2 = secondfraction.indexOf("/");
		String num2 = secondfraction.substring(0, slash2);
		int c = Integer.parseInt(num2);
		String den2 = secondfraction.substring(slash2 + 1);
		int d = Integer.parseInt(den2);

		int finalNum = a * d + b * c;
		int finalDen = b * d;

		String answer = finalNum + "/" + finalDen;
		return answer;
	}

	public static String subtraction(String firstfraction, String secondfraction) {
		int slash1 = firstfraction.indexOf("/");
		String num1 = firstfraction.substring(0, slash1);
		int a = Integer.parseInt(num1);
		String den1 = firstfraction.substring(slash1 + 1);
		int b = Integer.parseInt(den1);

		int slash2 = secondfraction.indexOf("/");
		String num2 = secondfraction.substring(0, slash2);
		int c = Integer.parseInt(num2);
		String den2 = secondfraction.substring(slash2 + 1);
		int d = Integer.parseInt(den2);

		int finalNum = a * d - b * c;
		int finalDen = b * d;

		String answer = finalNum + "/" + finalDen;
		return answer;
	}

	public static String division(String firstfraction, String secondfraction) {
		int slash1 = firstfraction.indexOf("/");
		String num1 = firstfraction.substring(0, slash1);
		int n1 = Integer.parseInt(num1);
		String den1 = firstfraction.substring(slash1 + 1);
		int d1 = Integer.parseInt(den1);

		int slash2 = secondfraction.indexOf("/");
		String num2 = secondfraction.substring(0, slash2);
		int n2 = Integer.parseInt(num2);
		String den2 = secondfraction.substring(slash2 + 1);
		int d2 = Integer.parseInt(den2);

		int finalNum = n1 * d2;
		int finalDen = d1 * n2;
		String sign = "";

		if (finalNum > 0 && finalDen < 0 || finalNum < 0 && finalDen > 0) {
			sign = "-";
		}
		finalDen = Math.abs(finalDen);
		finalNum = Math.abs(finalNum);
		String answer = sign + finalNum + "/" + finalDen;
		return answer;
	}

	public static String multiplication(String firstfraction, String secondfraction) {
		int slash1 = firstfraction.indexOf("/");
		String num1 = firstfraction.substring(0, slash1);
		int n1 = Integer.parseInt(num1);
		String den1 = firstfraction.substring(slash1 + 1);
		int d1 = Integer.parseInt(den1);
		System.out.println(n1 + " " + d1);

		int slash2 = secondfraction.indexOf("/");
		String num2 = secondfraction.substring(0, slash2);
		int n2 = Integer.parseInt(num2);
		String den2 = secondfraction.substring(slash2 + 1);
		int d2 = Integer.parseInt(den2);
		// System.out.println(n2 + " "+d2);
		int finalNum = n1 * n2;
		int finalDem = d1 * d2;

		String sign = "";

		if (finalNum > 0 && finalDem < 0 || finalNum < 0 && finalDem > 0) {
			sign = "-";
		}
		finalDem = Math.abs(finalDem);
		finalNum = Math.abs(finalNum);
		String answer = sign + finalNum + "/" + finalDem;

		return answer;
	}
}
