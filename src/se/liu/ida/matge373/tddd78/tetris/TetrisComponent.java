package se.liu.ida.matge373.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

import static java.awt.Color.*;
import static se.liu.ida.matge373.tddd78.tetris.SquareType.*;

public class TetrisComponent extends JComponent implements BoardListener
{
    private Board board;
    private EnumMap<SquareType, Color> tetromino = new EnumMap<>(SquareType.class);
    private static final int SQUARECONSTANT = 40; //Storleken på square och hur den ska ritas ut i fönstret.
    private static final int LOWERCORNER = 40; //Används för den koordinaten nere i högra hörnet på square.
    private static final int MENUHEIGHT = 24;




    public TetrisComponent(final Board board) {
	this.board = board;
    }

    @Override public void boardChanged() {
	repaint();
    }

    @Override public Dimension getPreferredSize() { //Används inte denna så är det egentligen ingen mening att den extendar JComponent.
	super.getPreferredSize();
	return new Dimension((board.getWidth()) * SQUARECONSTANT,
			     (board.getHeight()) * SQUARECONSTANT + MENUHEIGHT); //Ska den bara vara såhär kanske?
    }



    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	tetromino.put(EMPTY, WHITE);
	tetromino.put(I, cyan);
	tetromino.put(L, GREEN);
	tetromino.put(J, RED);
	tetromino.put(O, yellow);
	tetromino.put(T, GRAY);
	tetromino.put(S, BLUE);
	tetromino.put(Z, PINK);
	tetromino.put(OUTSIDE, ORANGE);

	for (int i = 0; i < board.getWidth(); i++) {
	    for (int j = 0; j < board.getHeight(); j++) {
	        g2d.setColor(tetromino.get(board.getSquareAt(i,j)));
		g2d.fillRect(i * SQUARECONSTANT, j * SQUARECONSTANT,
			     j * SQUARECONSTANT + LOWERCORNER, i * SQUARECONSTANT + LOWERCORNER);
		g2d.setColor(BLACK);
	        g2d.drawRect(i * SQUARECONSTANT, j * SQUARECONSTANT, SQUARECONSTANT, SQUARECONSTANT);
	    }
	}




    }


}

