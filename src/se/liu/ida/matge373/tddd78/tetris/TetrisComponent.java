package se.liu.ida.matge373.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

import static java.awt.Color.*;
import static se.liu.ida.matge373.tddd78.tetris.SquareType.*;

public class TetrisComponent extends JComponent
{
    private Board board;
    private EnumMap<SquareType, Color> tetromino = new EnumMap<>(SquareType.class);
    private int squareconstant = 40;

    public TetrisComponent(final Board board) {
	this.board = board;
    }



    @Override public Dimension getPreferredSize() { //Används inte denna så är det egentligen ingen mening att den extendar JComponent.
	super.getPreferredSize();
	return new Dimension(board.getWidth() * squareconstant, board.getHeight() * squareconstant); //Ska den bara vara såhär kanske?

    }

    /*@Override public Dimension getPreferredSize() {
	return super.getPreferredSize();
    }*/



    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	tetromino.put(EMPTY, WHITE);
	tetromino.put(I, BLUE);
	tetromino.put(L, GREEN);
	tetromino.put(J, RED);
	tetromino.put(O, yellow);
	tetromino.put(T, GRAY);
	tetromino.put(S, BLACK);
	tetromino.put(Z, PINK);

	for (int i = 0; i < board.getHeight(); i++) {
	    for (int j = 0; j < board.getWidth(); j++) {
	        g2d.setColor(BLACK);//tetromino.get(board.getSquareAt(i,j)));
	        g2d.setPaint(tetromino.get(board.getSquareAt(i,j)));

	        g2d.drawRect(i * squareconstant, j * squareconstant, squareconstant, squareconstant);
		g2d.fillRect(i*squareconstant, j*squareconstant,j*squareconstant + squareconstant, i*squareconstant + squareconstant);
	    }
	}



    }


}

