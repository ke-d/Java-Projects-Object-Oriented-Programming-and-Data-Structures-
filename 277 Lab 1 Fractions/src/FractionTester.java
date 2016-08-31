import java.util.Scanner;

/**
 * @author Kenny Do
 * @version 1.0
 * @since 8/31/2016
 * CECS 277 
 */
public class FractionTester {
	public static void main(String[] args) {
		int num1;
		int deno1;
		int num2;
		int deno2;
		try(Scanner in = new Scanner(System.in)) {
			System.out.println("Enter a numerator for fraction 1");
			num1 = in.nextInt();
			System.out.println("Enter a denominator for fraction 1");
			deno1 = in.nextInt();
			System.out.println("Enter a numerator for fraction 2");
			num2 = in.nextInt();
			System.out.println("Enter a denominator for fraction 2");
			deno2 = in.nextInt();
			
		}
		Fraction f1 = new Fraction(num1,deno1);
		Fraction f2 = new Fraction(num2,deno2);
		Fraction f3 = f1.add(f2);
		System.out.println("1. " + f1.toString() + " + " + f2.toString() + " = " + f3);
		
		f3.sub(f1, f2);
		System.out.println("2. " + f1.toString() + " - " + f2.toString() + " = " + f3);
		
		f3 = f1.mul(f2);
		System.out.println("3. " + f1.toString() + " * " + f2.toString() + " = " + f3);
		
		f3.div(f1, f2);
		System.out.println("4. " + f1.toString() + " / " + f2.toString() + " = " + f3);
		
		double div = Fraction.divFraction(f1, f2);
		System.out.println("5. " + f1.toString() + " / " + f2.toString() + " = " + div);
		
		f1.setNumerator(2);
		
		f2.setDenominator(5);
		
		System.out.println("6. Numerator: " + f1.getNumerator());
		System.out.println("7. Denominator: " + f2.getDenominator());

	}

}
