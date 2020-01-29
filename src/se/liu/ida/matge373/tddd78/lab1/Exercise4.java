package se.liu.ida.matge373.tddd78.lab1;

public class Exercise4<f>
{
    public static void main(String[] args) {
	for (int i = 0; i <= 16; i++) { //16 är max, är int för litet (byte).
	    System.out.println(i + "-fakultet: " + factorial(i));
	}
    }

    /**
     * Calculates f! given f.
     *
     * @param f
     * @return f!
     */
    private static int factorial(int f) {
	if (f == 0) return 1;
	int result = 1;
	for (int i = 1; i <= f; i++) {
	    result *= i;
	}

	return result;
    }
}

