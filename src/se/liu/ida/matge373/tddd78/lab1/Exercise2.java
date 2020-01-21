package se.liu.ida.matge373.tddd78.lab1;

public class Exercise2
{
    public static int sumFor(int min, int max) {
        int sum = 0;
	for (int i = 0; min < max; i++) {
	    min += i;
	    sum += min;
	}
	return sum;
    }

    public static void main(String[] args) {
	int min = 10;
	int max = 20;
	System.out.println("Nu har min värdet: " + sumFor(min,max));
    }
}

