import java.util.Scanner;

public class Fraction {
	static Scanner scan;

	static {
	  scan = new Scanner(System.in); 
	}
	private int numerator;
	private int denominator;
	
	public Fraction() {
		setNumerator(0);
		setDenominator(1);
	}
	
	public Fraction(int num, int deno) {
		setNumerator(num);
		setDenominator(deno);
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public void setNumerator(int value) {
		numerator = value; 
	}
	
	public void setDenominator(int value) {
		denominator = value;
		while(denominator == 0) {
			System.out.println("Invalid input. Enter a number that is not 0");
			denominator = scan.nextInt();
		}
	}
	
	public void inputFraction() {
		System.out.println("Input Numerator");
		int num = scan.nextInt();
		System.out.println("Input Denominator");	
		int deno = scan.nextInt();
		setNumerator(num);
		setDenominator(deno);
	}
	
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	private int gcd(int m, int n) {
		int r;
		while(n != 0) {
			r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
	
	public Fraction add(Fraction newFraction) {
		int newNumerator = numerator * newFraction.getDenominator() + newFraction.getNumerator() * denominator;
		int newDenominator = denominator * newFraction.getDenominator();
		int gcd = gcd(newNumerator, newDenominator);
		newNumerator /= gcd;
		newDenominator /= gcd;
		return new Fraction(newNumerator, newDenominator);
	}
	
	public void sub(Fraction f1, Fraction f2) {
		numerator = f1.getNumerator() * f2.getDenominator() - f2.getNumerator() * f1.getDenominator();
		denominator = f1.getDenominator() * f2.getDenominator();
		int gcd = gcd(f1.getDenominator(), f2.getDenominator());
		numerator /= gcd;
		denominator /= gcd;
	}
	
	public Fraction mul(Fraction newFraction) {
		int newNumerator = numerator * newFraction.getNumerator();
		int newDenominator = denominator * newFraction.getDenominator();
		int gcd = gcd(newNumerator, newDenominator);
		newNumerator /= gcd;
		newDenominator /= gcd;
		return new Fraction(newNumerator, newDenominator);
	}
	
	public void div(Fraction f1, Fraction f2) {
		numerator = f1.getNumerator() * f2.getDenominator();
		denominator = f1.getDenominator() * f2.getNumerator();
		int gcd = gcd(f1.getDenominator(), f2.getDenominator());
		numerator /= gcd;
		denominator /= gcd;
	}
	
	public static double divFraction(Fraction f1, Fraction f2) {
		return (f1.getNumerator() * f2.getDenominator()) / (f1.getDenominator() * f2.getNumerator());
	}
	
	
}
