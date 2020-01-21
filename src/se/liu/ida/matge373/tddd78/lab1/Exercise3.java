package se.liu.ida.matge373.tddd78.lab1;

import javax.swing.*;
import java.util.Enumeration;

public class Exercise3
{
    private final static int TABELL = 5;

    public static void main(String[] args) {
        String input =
		JOptionPane.showInputDialog("Please input a value");
	//if (Something input is not number)
	//	JOptionPane.showInputDialog("Please input another value");
        int tabell = Integer.parseInt(input);
	for (int i = 0; i <= 12; i++) {
	    int multiplied = tabell * i;
	    System.out.println(i + "*" + tabell + "=" + multiplied);
	}
    }
}

