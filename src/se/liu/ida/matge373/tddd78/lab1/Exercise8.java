package se.liu.ida.matge373.tddd78.lab1;

import javax.swing.*;

public class Exercise8
{
    public static boolean askUser(String question) {
	JOptionPane.showInputDialog(question);
	return JOptionPane.showConfirmDialog(null, question, "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    public static void main(String[] args) { ;

	while (!askUser("Quit")) {}
	while (!askUser("Really?")) {}
	if ()

//	if (askUser("Quit?") && askUser("Really?")) {
//	    return;
//	} else {
//	}

    }
}


