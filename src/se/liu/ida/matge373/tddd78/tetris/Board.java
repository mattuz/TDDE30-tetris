package se.liu.ida.matge373.tddd78.tetris;

import javax.swing.*;
import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width;
    private int height;
    private Random rdn = new Random();
    private Poly falling = new TetrominoMaker().getPoly(0);
    private int fallingX = 12;
    private int fallingY = 8;


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

    public void rdnBoard(/*Board board*/) {
	for (int i = 0; i < height; i++) {
	    for (int j = 0; j < width; j++) {
		squares[i][j] = SquareType.values()[rdn.nextInt(7)];
	    }
	}
    }

    public SquareType getSquareAt(int x, int y) {
	int tetroheight = falling.getPolyHeight() - 1; //Kollar höjden på falling
	int tetrowidth = falling.getPolyWidth() - 1; //Bredden

	if (fallingX <= x && x <= fallingX + tetroheight && fallingY <= y &&
	    y <= fallingY + tetrowidth) { //Kollar om (x,y) är inom falling. Om inte --> titta på board.
	    int i = x - fallingX; //Båda dessa ger x respektive y index inom falling, beroende av var på boarden vi kollar.
	    int j = y - fallingY;

	    if (falling.getPolyminoAt(i, j) == SquareType.EMPTY) { //Empty --> Kolla på board.
		return squares[x][y];
	    }
	    return falling.getPolyminoAt(i, j); // Annars --> Kolla falling.
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
	System.out.println(b1.getSquares(1, 2));
    }
}
