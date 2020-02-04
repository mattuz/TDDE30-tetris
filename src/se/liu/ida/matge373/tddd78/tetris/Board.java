package se.liu.ida.matge373.tddd78.tetris;

import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width;
    private int height;
    private Random rdn = new Random();
    Poly falling;
    int fallingX;
    int fallingY;


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
        //if-sats som kollar ifall x,y ligger mellan fallingx,fallingy, fallingx2,fallingy2. (som är bredd/höjd av falling).
	//if-sats som kollar ifall x,y == fallingx,fallingy --> returnera fallings polymino.
	//else? som returnerar
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

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public static void main(String[] args) {
	Board b1 = new Board(10, 10);
    }
}
