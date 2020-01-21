package se.liu.ida.matge373.tddd78.lab1;

import java.security.spec.RSAOtherPrimeInfo;

public class Exercise2
{
    public static int sumFor(int min, int max) {
	int sum = 0;
	for (int i = 0; min < max + 1; i++) {
	    sum += min;
	    min += 1;
	}
	return sum;
    }

    public static void main(String[] args) {
	int min = 10;
	int max = 20;
	System.out.println("Summan i for-loopen: " + sumFor(min, max));
	System.out.println("Summan i while-loopen: " + sumWhile(min, max));
    }

    public static int sumWhile(int min, int max) {
	int new_val = 0;
        while (min < max + 1) {
            new_val += min;
	    min += 1;
	}
        return new_val;
    }
}

