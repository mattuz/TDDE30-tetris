package se.liu.ida.matge373.tddd78.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoardTestNew
{
    public static void main(String[] args) {
	Board b2 = new Board(400, 400);

	final Action doOneStep = new AbstractAction()
	{
	    TetrisViewer v1 = new TetrisViewer(b2);
	    public void actionPerformed(final ActionEvent actionEvent) {
		b2.rdnBoard();
		System.out.println("test");
		//v1.refresh(b2);
		TetrisViewer v1 = new TetrisViewer(b2);
		v1.show();
		//TetrisViewerOld v2 = new TetrisViewerOld(b2);
		//v2.show();
	    }
	};
	final Timer clockTimer = new Timer(1000, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
	TetrisViewer v1 = new TetrisViewer(b2);

	v1.show();



	//clockTimer.stop();


    }
}

