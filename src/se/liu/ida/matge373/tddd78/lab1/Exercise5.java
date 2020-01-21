package se.liu.ida.matge373.tddd78.lab1;

public class Exercise5
{
    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
	    int rest = number % i;
	    if (rest == 0) {
		// number är en jämn multipel av i
		return false;
	    }
	    }
        return true;
	}

    public static void main(String[] args) {
	for (int i = 2; i < 100; i++) {
	    System.out.println("Is " + i + " prime?: " + isPrime(i));
	}
    }
}
