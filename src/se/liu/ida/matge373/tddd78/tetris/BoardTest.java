package se.liu.ida.matge373.tddd78.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;



public class BoardTest
{

    private static Random rdn = new Random();

    public static void main(String[] args) {
	Board b2 = new Board(15, 20);

	final Action doOneStep = new AbstractAction()
	{
	    public void actionPerformed(final ActionEvent actionEvent) {
		b2.rdnBoard();
		System.out.println("test");
		//TetrisViewer v1 = new TetrisViewer(b2);
		//v1.show();
	    }
	};
	final Timer clockTimer = new Timer(1000, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
	TetrisViewerOld v1 = new TetrisViewerOld(b2);

	v1.show();



	//clockTimer.stop();


    }
}
