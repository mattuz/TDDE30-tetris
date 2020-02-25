package se.liu.ida.matge373.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class TetrisViewer
{
    private JFrame frame = new JFrame();
    private TetrisComponent boardgraphics;
    private Board board;


    public TetrisViewer(final Board board) {
	this.board = board;
	this.boardgraphics = new TetrisComponent(board); //Här tar den in boarden som i sin tur kommer hanteras av paintcomponent och dylikt.
    }


    public void keyBindings() {
	InputMap im = boardgraphics.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	ActionMap am = boardgraphics.getActionMap();

	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "LeftArrow");
	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "RightArrow");
	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UpArrow");
	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DownArrow");

	am.put("LeftArrow", new ArrowMovement("LeftArrow"));
	am.put("RightArrow", new ArrowMovement("RightArrow"));
	am.put("UpArrow", new ArrowMovement("UpArrow"));
	am.put("DownArrow", new ArrowMovement("DownArrow"));
    }

    private class ArrowMovement extends AbstractAction {
        private String command;

	private ArrowMovement(final String command) {
	    this.command = command;
	}

	@Override public void actionPerformed(final ActionEvent actionEvent) {
	    if (command.equalsIgnoreCase("LeftArrow")) {
		board.moveLeft();
	    }
	    else if (command.equalsIgnoreCase("RightArrow")) {
	        board.moveRight();
	    }
	    else if (command.equalsIgnoreCase("UpArrow")) {
	        board.rotate(true);
	    }
	    else if (command.equalsIgnoreCase("DownArrow")) {
	        board.rotate(false);
	    }
	}
    }


    public void doStep() {
	final Action doOneStep = new AbstractAction()
	{

	    public void actionPerformed(final ActionEvent actionEvent) {
		board.tick();
	    }
	};
	final Timer clockTimer = new Timer(1000, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
    }



    public TetrisComponent getBoardgraphics() {
	System.out.println("hello");
	return boardgraphics;
    }

    public void show() {
	frame.setLayout(new BorderLayout());
	frame.add(boardgraphics, BorderLayout.CENTER);
	frame.pack();
	frame.setVisible(true);
	//keyBindings();
    }
}
