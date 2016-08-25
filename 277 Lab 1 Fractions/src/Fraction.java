/**
 * Kenny Do
 * CECS 277
 * 8/31/2016
 */
import java.util.Scanner;

public class Fraction {
	/**
	 * Scanner used for user input
	 */
	static Scanner scan;

	static {
	  scan = new Scanner(System.in); 
	}
	
	/**
	 * Stores the numerator
	 */
	private int numerator;
	
	/**
	 * Stores the denominator 
	 */
	private int denominator;
	
	/**
	 * Creates a fraction with numerator 0 and denominator 1
	 */
	public Fraction() {
		setNumerator(0);
		setDenominator(1);
	}
	
	/**
	 * Creates a fraction with user specifications
	 * @param num will be the numerator stored in fraction
	 * @param deno will be the denominator stored in fraction
	 */
	public Fraction(int num, int deno) {
		setNumerator(num);
		setDenominator(deno);
	}
	
	/**
	 * Returns the numerator
	 * @return the numerator
	 */
	public int getNumerator() {
		return numerator;
	}
	
	/**
	 * Returns the denominator
	 * @return the denominator
	 */
	public int getDenominator() {
		return denominator;
	}
	
	/**
	 * Sets the numerator
	 * @param value will be stored in numerator
	 */
	public void setNumerator(int value) {
		numerator = value; 
	}
	
	/**
	 * Sets the denominator
	 * @param value will be stored in denominator
	 */
	public void setDenominator(int value) {
		denominator = value;
		//input validation for the denominator
		while(denominator == 0) {
			System.out.println("Invalid input. Enter a number that is not 0");
			denominator = scan.nextInt();
		}
	}
	
	/**
	 * Asks the user to input a numerator and denominator
	 */
	public void inputFraction() {
		System.out.println("Input Numerator");
		int num = scan.nextInt();
		System.out.println("Input Denominator");	
		int deno = scan.nextInt();
		setNumerator(num);
		setDenominator(deno);
	}
	
	/**
	 * Returns the fraction in the format: numerator/denominator
	 */
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	/**
	 * Calculates the GCD of m and n
	 * @param m is one parameter for the GCD
	 * @param n is the other parameter for the GCD
	 * @return the GCD
	 */
	private int gcd(int m, int n) {
		int r;
		while(n != 0) {
			r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
	
	/**
	 * Adds this fraction and another fraction together
	 * @param newFraction is the other fraction being added
	 * @return a new fraction with this fraction and newFraction added
	 */
	public Fraction add(Fraction newFraction) {
		int newNumerator = numerator * newFraction.getDenominator() + newFraction.getNumerator() * denominator;
		int newDenominator = denominator * newFraction.getDenominator();
		int gcd = gcd(newNumerator, newDenominator);
		newNumerator /= gcd;
		newDenominator /= gcd;
		return new Fraction(newNumerator, newDenominator);
	}
	
	/**
	 * Update the values of this fraction by subtracting f1 and f2
	 * @param f1 is the first fraction
	 * @param f2 is the second fraction
	 */
	public void sub(Fraction f1, Fraction f2) {
		numerator = f1.getNumerator() * f2.getDenominator() - f2.getNumerator() * f1.getDenominator();
		denominator = f1.getDenominator() * f2.getDenominator();
		int gcd = gcd(f1.getDenominator(), f2.getDenominator());
		numerator /= gcd;
		denominator /= gcd;
	}
	
	/**
	 * Multiply this fraction and another fraction together
	 * @param newFraction is the other fraction being multiplied
	 * @return a new fraction with this fraction and newFraction multiplied
	 */
	public Fraction mul(Fraction newFraction) {
		int newNumerator = numerator * newFraction.getNumerator();
		int newDenominator = denominator * newFraction.getDenominator();
		int gcd = gcd(newNumerator, newDenominator);
		newNumerator /= gcd;
		newDenominator /= gcd;
		return new Fraction(newNumerator, newDenominator);
	}
	
	/**
	 * Update the values of this fraction by dividing f1 and f2
	 * @param f1 is the first fraction
	 * @param f2 is the second fraction
	 */
	public void div(Fraction f1, Fraction f2) {
		numerator = f1.getNumerator() * f2.getDenominator();
		denominator = f1.getDenominator() * f2.getNumerator();
		int gcd = gcd(f1.getDenominator(), f2.getDenominator());
		numerator /= gcd;
		denominator /= gcd;
	}
	
	/**
	 * Calculates the double value of dividing f1 and f2
	 * @param f1 is the first fraction
	 * @param f2 is the second fraction
	 * @return double value of dividing f1 and f2
	 */
	public static double divFraction(Fraction f1, Fraction f2) {
		return (f1.getNumerator() * f2.getDenominator()) / (f1.getDenominator() * f2.getNumerator());
	}
	
	
}
