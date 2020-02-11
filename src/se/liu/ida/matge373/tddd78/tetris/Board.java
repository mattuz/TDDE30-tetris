package se.liu.ida.matge373.tddd78.tetris;

import java.util.EmptyStackException;
import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width;
    private int height;
    private Random rdn = new Random();
    Poly falling = new TetrominoMaker().getPoly(5);
    int fallingX = 3;
    int fallingY = 1;


    public Board(final int width, final int height) {
	this.width = width;
	this.height = height;
	this.squares = new SquareType[height][width];
	for (int i = 0; i < width; i++) {
	    for (int j = 0; j < height; j++) {
		squares[j][i] = SquareType.EMPTY;
	    }
	}
    }

    public void rdnBoard(Board board) {
	for (int i = 0; i < board.getHeight(); i++) {
	    for (int j = 0; j < board.getWidth(); j++) {
		squares[i][j] = SquareType.values()[rdn.nextInt(7)];
	    }
	}
    }

    public SquareType getSquareAt(int x, int y) {
	int tetroheight = falling.getPolyHeight() - 1; //Kollar höjden på falling
	int tetrowidth = falling.getPolyWidth() - 1; //Bredden

	if (getFallingX() <= x && x <= getFallingX() + tetroheight &&
	    getFallingY() <= y && y <= getFallingY() + tetrowidth &&
	    falling.getPolymino()[1][1] != SquareType.EMPTY) { //kollar om mitten är EMPTY. Funkar inte för I tetrominon dock (roterad).
	    for (int i = 0; i < falling.getPolyWidth(); i++) {
		for (int j = 0; j < falling.getPolyHeight(); j++) {
		    if (falling.getPolyminoAt(i, j) == SquareType.EMPTY) {
			return squares[x][y];
		    }
		    else {
			//squares[getFallingX() + i][getFallingY() + j] = falling.getPolyminoAt(i, j);
			return falling.getPolyminoAt(j, i);
		    }
		}
	    }
		//return squares[][y];
	    return squares[x][y];
	}
	return squares[x][y];
    }




    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public SquareType getSquares(int x, int y) {
	return squares[x][y];
    }

    public Poly getFalling() {
	return falling;
    }

    public int getFallingX() {
	return fallingX;
    }

    public int getFallingY() {
	return fallingY;
    }

    public static void main(String[] args) {
	Board b1 = new Board(10, 10);
	System.out.println(b1.getSquares(1,2));
    }
}
