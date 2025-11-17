// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
		System.out.println(minus(2,7));  // 2 - 7
		System.out.println(times(3,4));  // 3 * 4
		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
		System.out.println(pow(5,3));      // 5^3
		System.out.println(pow(3,5));      // 3^5
		System.out.println(div(12,3));   // 12 / 3    
		System.out.println(div(5,5));    // 5 / 5  
		System.out.println(div(25,7));   // 25 / 7
		System.out.println(mod(25,7));   // 25 % 7
		System.out.println(mod(120,6));  // 120 % 6    c
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	 	System.out.println(minus(7,2));  // 7 - 2
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// This implementation is correct for non-negative x2.
		for (int i = 0; i < x2; i++) {
			x1++;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// This implementation is correct for non-negative x2.
		for (int i = 0; i < x2; i++) {
			x1--;
		}		
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Assuming x2 >= 0
		int total = 0;
		for (int i = 0; i < x2; i++) {
			total = plus(total, x1);
		}
		return total;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Assuming n >= 0
		int total = 1;
		for (int i = 0; i < n; i++) {
			total = times(total, x);
		}
		return total;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Assuming x1 >= 0 and x2 > 0
		int quotient = 0;
		int remainder = x1;
		while (remainder >= x2) {
			remainder = minus(remainder, x2);
			quotient++;
		}
		return quotient;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Assuming x1 >= 0 and x2 > 0
		// Remainder = x1 - (div(x1, x2) * x2)
		int quotient = div(x1, x2);
		int product = times(quotient, x2);
		int remainder = minus(x1, product);
		return remainder;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Assuming x >= 0
		int root = 0;
		// Find the largest integer 'root' such that (root + 1)^2 <= x
		while (times(plus(root, 1), plus(root, 1)) <= x) {
			root++;
		}
		return root;
	}	  	  
}