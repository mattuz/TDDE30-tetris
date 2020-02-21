package se.liu.ida.matge373.tddd78.tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board
{
    private SquareType[][] squares;
    private int width;
    private int height;
    private Random rdn = new Random();
    private Poly falling; //Idea tycker att denna ska sättas till null. Är det verkligen nödvändigt?
    private int fallingX;
    private int fallingY;
    private List<BoardListener> listenerlist = new ArrayList<>();

    public Board(final int width, final int height) {
	this.width = width;
	this.height = height;
	this.squares = new SquareType[height][width];
	for (int i = 0; i < width; i++) {
	    for (int j = 0; j < height; j++) {
		squares[j][i] = SquareType.EMPTY;
		notifyListeners();
	    }
	}
    }


    public void rdnBoard(/*Board board*/) {
	for (int i = 0; i < height; i++) {
	    for (int j = 0; j < width; j++) {
		squares[i][j] = SquareType.values()[rdn.nextInt(7)];
		notifyListeners();
	    }
	}
    }

    public SquareType getSquareAt(int x, int y) {
        if (falling != null) {
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
        }
	return squares[x][y];
    }

    public void addBoardListener (BoardListener bl) {
        listenerlist.add(bl);
	System.out.println("Nu finns det en listener");
    }

    private void notifyListeners() {

	for (BoardListener listeners : listenerlist){
	    System.out.println("Nu ska den ha uppdaterats");
	    listeners.boardChanged();
	}
    }

    public void moveRight() {
        fallingX += 1;
        notifyListeners();
	System.out.println(fallingX);
    }

    public void moveLeft() {
        fallingX -= 1;
        notifyListeners();
	System.out.println(fallingX);
    }


    public void tick() {
        if (falling != null && fallingY < height) {
            fallingY += 1;
            notifyListeners();
	}
	if (falling == null || fallingY > height + 2) {
	    falling = new TetrominoMaker().getPoly(rdn.nextInt(7));
	    fallingY = 0;
	    fallingX = width / 2;
	    notifyListeners();
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

    public Poly getFalling() {
	return falling;
    }

    public int getFallingX() {
	return fallingX;
    }

    public int getFallingY() {
	return fallingY;
    }


}
