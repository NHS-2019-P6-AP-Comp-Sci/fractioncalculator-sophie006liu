/**
 * @author Mr. Rasmussen
 */
package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		System.out.println("Let's use the fraction calculator. Keep typing expressions to continue using the"
				+ "calculator or type \"quit\" to stop");

		Scanner scanner = new Scanner(System.in);
		String wholeExpression = scanner.nextLine();

		//keep calc going until user types quit
		while (true) {
			if (wholeExpression.equals("quit")) {
				System.out.println("See you l8er");
				System.exit(0);
			}

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
		String answers = "";
		int spaceOneIndex = wholeExpression.indexOf(' ');

		String firstOperand = wholeExpression.substring(0, spaceOneIndex);
		String firstOperandInfo = "";
		if (wholeExpression.contains("0 ") && wholeExpression.indexOf(0) == 0) {
			if (wholeExpression.contains(" * ")){
				answers = "0";
			}
		}
		// 1st operand contains whole num and fraction
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
		// 1st operand contains just fraction
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

		// 1st operand contains just whole number
		if (!firstOperand.contains("_") && !firstOperand.contains("/")) {

			String whole1 = firstOperand.substring(0, spaceOneIndex);
			int w1 = Integer.parseInt(whole1);
			int n1 = 0;
			int d1 = 1;
			firstOperandInfo = mixedNumber(w1, n1, d1);
		}

		int operatorIndex = spaceOneIndex + 1;
		wholeExpression.charAt(operatorIndex);
		String operator = wholeExpression.substring(operatorIndex, operatorIndex + 1);
	
		// second operand stuff
		String secondOperand = wholeExpression.substring(operatorIndex + 2);
		String secondOperandInfo = "";
		// 2nd operand contains mixed num
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

		// 2nd operand contains just fraction
		if (!secondOperand.contains("_") && secondOperand.contains("/")) {
			int slashIndex = secondOperand.indexOf("/");
			String numerator2 = secondOperand.substring(0, slashIndex);
			int n2 = Integer.parseInt(numerator2);

			String denominator2 = secondOperand.substring(slashIndex + 1);
			int d2 = Integer.parseInt(denominator2);
			int w2 = 0;
			secondOperandInfo = mixedNumber(w2, n2, d2);

		}

		// 2nd operand contains just whole number

		if (!secondOperand.contains("_") && !secondOperand.contains("/")) {
			String whole2 = secondOperand.substring(0);
			int w2 = Integer.parseInt(whole2);
			int n2 = 0;
			int d2 = 1;
			secondOperandInfo = mixedNumber(w2, n2, d2);

		}

		// doing the calculation based on the operand
		if (wholeExpression.contains("+")) {
			answers = addition(firstOperandInfo, secondOperandInfo);
		} else if (operator.equals("-")) {
			answers = subtraction(firstOperandInfo, secondOperandInfo);
		} else if (operator.equals("*")) {
			answers = multiplication(firstOperandInfo, secondOperandInfo);
			System.out.println(answers);
		} else if (operator.equals("/")) {
			answers = division(firstOperandInfo, secondOperandInfo);
		}
		
		
		
		// division and multiplication with zero
		if (operator.equals("*") && firstOperand.equals("0")) {
				answers = "0";
		}
		if (operator.equals("/") && firstOperand.equals("0")) {
			answers = "0";
		}
		if (operator.equals("/") && firstOperand.equals("-0")) {
			answers = "0";
		}
		if (operator.equals("*") && secondOperand.equals("0")) {
			answers = "0";
		}
		if (firstOperand.contains("0/") && operator.contentEquals("*")) {
			answers = "0";
		}
		if (firstOperand.contains("0/") && operator.contentEquals("/")) {
			answers = "0";
		}
		if (firstOperand.equals(secondOperand) && operator.contentEquals("-")) {
			answers = "0";
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

		int gcf = GCF(Math.abs(finalNum), Math.abs(finalDen));
		String answer="";
		if (Math.abs(finalDen) > Math.abs(finalNum)) {
			answer = (finalNum/gcf) + "/" + (finalDen/gcf);
		} else if (Math.abs(finalDen) <= Math.abs(finalNum)){
			String num = "" + finalNum/gcf;
			String den = "" + finalDen/gcf;		
			answer= returnMixedFrac( num, den);
		}
		

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

		int gcf = GCF(Math.abs(finalNum), Math.abs(finalDen));
		String answer="";
		if (Math.abs(finalDen) > Math.abs(finalNum)) {
			answer = (finalNum/gcf) + "/" + (finalDen/gcf);
		} else if (Math.abs(finalDen) <= Math.abs(finalNum)){
			String num = "" + finalNum/gcf;
			String den = "" + finalDen/gcf;		
			answer= returnMixedFrac( num, den);
		}

		

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
		int gcf = GCF(Math.abs(finalNum), Math.abs(finalDen));
		String answer="";
		if (Math.abs(finalDen) > Math.abs(finalNum)) {
			answer = sign + (finalNum/gcf) + "/" + (finalDen/gcf);
		} else if (Math.abs(finalDen) <= Math.abs(finalNum)){
			String num = "" + finalNum/gcf;
			String den = "" + finalDen/gcf;		
			answer= sign + returnMixedFrac( num, den);
		}

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
		int gcf = GCF(Math.abs(finalNum), Math.abs(finalDem));
		
		String answer="";
		if (Math.abs(finalDem) > Math.abs(finalNum)) {
			answer = sign + (finalNum/gcf) + "/" + (finalDem/gcf);
		} else if (Math.abs(finalDem) <= Math.abs(finalNum)){
			String num = "" + finalNum/gcf;
			String den = "" + finalDem/gcf;		
			answer= sign + returnMixedFrac( num, den);
		}

		return answer;
	}
	
	
	
	
	
	//find the GCF using the Euclidean algorithm
	//say you pass in a = 8 and b= 4, it will keep running the algorithm until b= 0
	// first run b!=0, so it runs again with the new a value as b = 4, and b now equals 
	// the old a value % b so in this case 4 % 8 is . We are now using gcf (4, 4)
	// b != 0, so gcf runs again with the new a value as b = 4, and b is the old a value % b = 0
	// We are now using gcf (4, 0). b ==0, we return int a = 4 which is the GCF of 8 and 4
	public static int GCF(int a, int b) { 
		if (b == 0) { 
			return a; 
		} else { 
			return (GCF(b, a % b)); } 
		}
	
	// this takes improper fractions and makes them mixed numbers
	public static String returnMixedFrac(String num, String den) {
		int n= Integer.parseInt(num);
		int d= Integer.parseInt(den);
		int wholeNum= n/d;
		
		int newNum = (n % d);
		
		String answer = "";
		if (newNum != 0) {
			answer= "" + wholeNum + "_" + Math.abs(newNum) + "/" + d;
		} else if (newNum == 0) {
			answer = "" + wholeNum;
		}
		return answer;
		
	}
	
}
