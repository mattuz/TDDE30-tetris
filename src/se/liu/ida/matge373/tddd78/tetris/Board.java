package se.liu.ida.matge373.tddd78.tetris;

import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width;
    private int height;
    Random rdn = new Random();


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

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public SquareType getSquares(int x, int y) {
	return squares[x][y];
    }

    public static void main(String[] args) {
	Board b1 = new Board(10, 10);
    }
}
