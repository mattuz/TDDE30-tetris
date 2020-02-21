package se.liu.ida.matge373.tddd78.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.DateTimeException;

public class BoardTestNew
{
    public static void main(String[] args) {
	Board b2 = new Board(15, 15);
	TetrisViewer v1 = new TetrisViewer(b2);
	b2.addBoardListener(v1.getBoardgraphics());
	v1.keyBindings();
	v1.show();
	v1.doStep();

	/*final Action doOneStep = new AbstractAction()
	{
	    TetrisViewer v1 = new TetrisViewer(b2);
	    public void actionPerformed(final ActionEvent actionEvent) {
		//b2.rdnBoard();
		v1.refresh(b2);
		v1.getBoardgraphics().repaint();
		b2.tick();

		//v1.refresh(b2);
	    }
	};
	final Timer clockTimer = new Timer(1000, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();*/

	//TetrisViewer v1 = new TetrisViewer(b2);
	//b2.addBoardListener(v1);
	//v1.doStep();

	//v1.show();



	//clockTimer.stop();


    }
}

