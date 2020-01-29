package se.liu.ida.matge373.tddd78.tetris;

public class Board
{
    private SquareType[][] squares;
    private int width;
    private int height;

    public Board(final int width, final int height) {
	this.width = width;
	this.height = height;
	this.squares = new SquareType[height][width];
	squares[height-1][width-1] = SquareType.EMPTY;
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
        Board b1 = new Board(10,10);
    }
}
