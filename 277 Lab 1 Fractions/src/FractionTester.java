/**
 * @author Kenny Do
 * @version 1.0
 * @since 8/31/2016
 * CECS 277 
 */
public class FractionTester {

	public static void main(String[] args) {
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = new Fraction(1,3);
		Fraction f3 = f1.add(f2);
		System.out.println("1. " + f1.toString() + " + " + f2.toString() + " = " + f3);
		
		f3.sub(f1, f2);
		System.out.println("2. " + f1.toString() + " - " + f2.toString() + " = " + f3);
		
		f3 = f1.mul(f2);
		System.out.println("3. " + f1.toString() + " * " + f2.toString() + " = " + f3);
		
		f3.div(f1, f2);
		System.out.println("4. " + f1.toString() + " / " + f2.toString() + " = " + f3);
		
		f1.setNumerator(2);
		
		f2.setDenominator(5);
		
		System.out.println("5. Numerator: " + f1.getNumerator());
		System.out.println("6. Denominator: " + f2.getDenominator());

	}

}
