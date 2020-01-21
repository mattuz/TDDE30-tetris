package se.liu.ida.matge373.tddd78.lab1;

import javax.swing.*;
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
	String input =
		JOptionPane.showInputDialog("for eller while?");
	switch (input) {
	    case "for":
		System.out.println("Summan i for-loopen: " + sumFor(min, max));
	    break;
	    case "while":
		System.out.println("Summan i while-loopen: " + sumWhile(min, max));
		break;
	    default:
		    System.out.println("Must select valid method.");
	}
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

