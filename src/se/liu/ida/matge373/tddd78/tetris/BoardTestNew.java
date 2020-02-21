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



    }
}

