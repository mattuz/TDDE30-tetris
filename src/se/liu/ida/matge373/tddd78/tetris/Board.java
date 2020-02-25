package se.liu.ida.matge373.tddd78.tetris;

import java.util.ArrayList;
import java.util.EmptyStackException;
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
	this.squares = new SquareType[height + 4][width + 4]; //Skriva en "Frameconstant"?
	for (int i = 2; i < width + 2; i++) {
	    for (int j = 2; j < height + 2; j++) {
		squares[j][i] = SquareType.EMPTY;
		notifyListeners();
	    }

	    }
	for (int i = 0; i < 2; i++) {
	    for (int j = 0; j < height + 2; j++) {
		squares[i][j] = SquareType.OUTSIDE;
	    }
	}
	for (int i = 0; i < width + 4; i++) {
	    for (int j = 0; j < 2; j++) {
		squares[i][j] = SquareType.OUTSIDE;
	    }
	}
	for (int i = width + 2; i < width + 4; i++) {
	    for (int j = 0; j < height + 4; j++) {
	        squares[i][j] = SquareType.OUTSIDE;
	    }
	}
	for (int i = 0; i < width + 4; i++) {
	    for (int j = height + 2; j < height + 4; j++) {
		squares[i][j] = SquareType.OUTSIDE;
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


	if (fallingX <= x+2 && x+2 <= fallingX + tetroheight && fallingY <= y+2 && //+2 överallt!!!!
	    y+2 <= fallingY + tetrowidth) { //Kollar om (x,y) är inom falling. Om inte --> titta på board.
	    int i = x+2 - fallingX; //Båda dessa ger x respektive y index inom falling, beroende av var på boarden vi kollar.
	    int j = y+2 - fallingY;

	    if (falling.getPolyminoAt(i, j) == SquareType.EMPTY) { //Empty --> Kolla på board.
	        return squares[x+2][y+2];
	    }
	    return falling.getPolyminoAt(i, j); // Annars --> Kolla falling.
	}
        }
	return squares[x+2][y+2];
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
	if (hasCollision()) {
	    fallingX -= 1;
	    notifyListeners();
	} else {
	    fallingX += 1;
	    notifyListeners();
	    System.out.println(fallingX);
	    System.out.println(getSquares(fallingX, fallingY));
	}
    }

    public void moveLeft() {
	if (hasCollision()) {
	    fallingX += 1;
	    notifyListeners();
	} else {
	    fallingX -= 1;
	    notifyListeners();
	    System.out.println(fallingX);
	    System.out.println(getSquares(fallingX, fallingY));
	}
    }


    public void tick() {
        if (falling != null && fallingY < height + 2) {
           /*if (hasCollision()) {
                fallingY -= 1;
                notifyListeners();
	       for (int i = 0; i < falling.getPolyWidth(); i++) { //"Fäster" tetrominon på boarden.
		   for (int j = 0; j < falling.getPolyHeight(); j++) {
		       if (falling.getPolyminoAt(i,j) != SquareType.EMPTY) {
			   squares[fallingX + i][fallingY + j] = falling.getPolyminoAt(i, j);
			   notifyListeners();
		       }
		   }

	       }
	       falling = null;
	    } else {*/
            fallingY += 1;
	    System.out.println(hasCollision());
            notifyListeners();}
	//}
	if (falling == null || fallingY > height + 2) {
	    falling = new TetrominoMaker().getPoly(rdn.nextInt(7));
	    fallingY = 2;
	    fallingX = (width+2) / 2; //ändrat dessa
	    notifyListeners();
	}
    }

    /*public boolean collisionHelperRight() {
	if ()
    }*/

    public boolean hasCollision() {
	if (falling != null) {
	    for (int i = 0; i < falling.getPolyWidth(); i++) {
		for (int j = 0; j < falling.getPolyHeight(); j++) {
		    if (falling.getPolyminoAt(i, j) != SquareType.EMPTY) {
			if (squares[fallingX + i + 1][fallingY + j] != SquareType.EMPTY ||
			    squares[fallingX + i - 1][fallingY + j] != SquareType.EMPTY) {
			    System.out.println("Stoppa");
			    return true;
			}
		    }

		}
	    }
	}
	return false;
    }



    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public SquareType getSquares(int x, int y) {
	return squares[x+2][y+2]; //+2 här
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
