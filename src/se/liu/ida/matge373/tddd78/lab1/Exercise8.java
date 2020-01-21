package se.liu.ida.matge373.tddd78.lab1;

import javax.swing.*;

public class Exercise8
{
    public static boolean askUser(String question) {
	JOptionPane.showInputDialog("Answer this question: yes or no?");
	return JOptionPane.showConfirmDialog(null, "Answer this question: yes or no?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    public static void main(String[] args) {
	while (askUser())
    }
}
