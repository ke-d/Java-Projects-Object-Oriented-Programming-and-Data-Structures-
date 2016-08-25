/**
 * Kenny Do
 * CECS 277
 * 8/31/2016
 */
public class FractionTester {

	public static void main(String[] args) {
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = new Fraction(1,3);
		Fraction f3 = f1.add(f2);
		System.out.println(f1.toString() + " + " + f2.toString() + " = " + f3);
		
		f3.sub(f1, f2);
		System.out.println(f1.toString() + " - " + f2.toString() + " = " + f3);
		
		f3 = f1.mul(f2);
		System.out.println(f1.toString() + " * " + f2.toString() + " = " + f3);
		
		f3.div(f1, f2);
		System.out.println(f1.toString() + " / " + f2.toString() + " = " + f3);
		
		f1.setNumerator(2);
		
		f2.setDenominator(5);
		
		System.out.println("Numerator: " + f1.getNumerator());
		System.out.println("Denominator: " + f2.getDenominator());

	}

}
