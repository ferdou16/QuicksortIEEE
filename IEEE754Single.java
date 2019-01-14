package ca.utoronto.utm.floatingpoint;

public class IEEE754Single {
	
	public static void main(String[] args) {
		System.out.println("0 to 10");
		for (float i = 0.0f; i <= 10.0f; i++) {
			System.out.println(binRep(i));
		}
		
		System.out.println("misc");
		System.out.println(binRep(-6.8f));
		System.out.println(binRep(23.1f));
		System.out.println(binRep(14.625f));
		System.out.println(binRep(.1f));
		System.out.println(binRep(5.75f));
		System.out.println(binRep(1.0f / 3.0f));

		System.out.println("Machine Epsilon");
		float me = machineEpsilon();
		System.out.println("Machine Epsilon = " + binRep(me));
		System.out.println("1+machine epsilon = " + binRep(1.0f + me));
		System.out.println("Underflow");
		System.out.println("Underflow = " + binRep(underflow()));

		System.out.println("Overflow");
		System.out.println("Overflow = " + binRep(overflow()));
		System.out.println("MAX_VALUE = " + binRep(Float.MAX_VALUE));
	}
	/**
	 * Search for machine epsilon (eps), that is, the smallest
	 * float such that 1+eps>1. 
	 * Print out progress along the way.
	 * 
	 * @return machine epsilon
	 */
	public static float machineEpsilon() {
		float one = 1.0f, me = 1.0f, meNew = 1.0f;
		System.out.println(binRep(one + meNew));
		while(one+meNew>one) {
			meNew /=2.0f;
			System.out.println(binRep(one + meNew));
		meNew /=2.0f;
		System.out.println(binRep(one + meNew));
		}
		return (me);
		}

	/**
	 * Search for underflow, that is the smallest float
	 * number that is greater than 0. 
	 * Print out progress along the way.
	 * @return underflow
	 */
	public static float underflow() {
		// ufl>0.0
		float ufl = 1.0f, uflNew = 1.0f;
		System.out.println(binRep(uflNew));
		while(uflNew>0.0) {
			uflNew/=2.0f;
			ufl=uflNew;
			System.out.println(binRep(uflNew));
			}
		return ufl;
		}

	/**
	 * Search for overflow, the largest float, 
	 * by first finding the largest exponent, and
	 * then finding the largest mantissa. 
	 * Print out progress along the way.
	 * @return overflow
	 */
	
	public static float overflow() {
		/*
		 * Algorithm: First find the maximum exponent and then the mantissa.
		 */
		System.out.println("Maximum Exponent");
		float ofl = 1.0f, oflNew = 1.0f;
		float positive_infinity=(float)1.0f/ (float)0.0f;
				
		while(oflNew<positive_infinity) {
			ofl=oflNew;
			oflNew=oflNew*2;
			System.out.println(binRep(ofl));
		}

	}

	/**
	 * Take apart a floating point number and return a string representation of it.
	 * @param d the floating point number to investigate
	 * @return By example, this method returns strings like...
	 * 
	 * binRep(0.0f) returns "0[00000000]00000000000000000000000=+0.00000000000000000000000x2^(0)=0.0"
	 * binRep(1.0f) returns "0[01111111]00000000000000000000000=+1.00000000000000000000000x2^(0)=1.0"
	 * binRep(2.0f) returns "0[10000000]00000000000000000000000=+1.00000000000000000000000x2^(1)=2.0"
	 * binRep(14.625f) returns "0[10000010]11010100000000000000000=+1.11010100000000000000000x2^(3)=14.625"
	 * binRep(0.1f) returns "0[01111011]10011001100110011001101=+1.10011001100110011001101x2^(-4)=0.1"
	 */
	// Return information about the representation of floating point number d, ********
	public static String binRep(float d) {
		// 
		/*
		 *
		 */

		int l = Float.floatToRawIntBits(d); // Use this to pull bits of d
		int sign = 0;
		int exponent = 0; 
		int mantissa = 0;
		String sSign = "";
		String sExponent = "";
		String sMantissa = "";
		String s = sSign + "[" + sExponent + "]" + sMantissa;
		String t = (sign == 0) ? "+" : "-";

		int trueExponent = 0;
		
		t = t + sMantissa + "x2^(" + trueExponent + ")";
		return (s + "=" + t + "=" + d);
	}
}
