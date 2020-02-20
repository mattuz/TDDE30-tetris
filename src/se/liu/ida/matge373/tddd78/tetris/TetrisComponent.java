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

    public TetrisComponent(final Board board) {
	this.board = board;
    }


    /*public static Dimension getPreferredSize(Board board) { //Tror inte att denna ska användas på detta sätt egentligen. Tror den ska implementera med metoden från JComponent.
        return new Dimension(600,600); //Inte säker på om det är såhär man ska skriva.
    }*/

    @Override public Dimension getPreferredSize() { //Används inte denna så är det egentligen ingen mening att den extendar JComponent.
	super.getPreferredSize();
	return new Dimension(1000,1000); //Ska den bara vara såhär kanske?

    }

    public void setColors() {
	tetromino.put(EMPTY, WHITE);
	tetromino.put(I, BLUE);
	tetromino.put(L, GREEN);
	tetromino.put(J, RED);
	tetromino.put(O, yellow);
	tetromino.put(T, GRAY);
	tetromino.put(S, BLACK);
	tetromino.put(Z, PINK);
    }

    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	for (int i = 0; i < board.getHeight(); i++) {
	    for (int j = 0; j < board.getWidth(); j++) {
	       g2d.drawRect(i,j,1,1);
	    }
	}



	//g2d.setColor(Color.blue);
	//g2d.drawRect(399,399,40,40);




    }


}

