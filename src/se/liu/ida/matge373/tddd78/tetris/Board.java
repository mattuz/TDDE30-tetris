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
    private Poly falling = null; //Idea tycker att denna ska sättas till null. Är det verkligen nödvändigt?
    private int fallingX;
    private int fallingY;
    private List<BoardListener> listenerlist = new ArrayList<>();
    private boolean gameover = false;
    private int score = 0;

    public Board(final int width, final int height) {
	this.width = width;
	this.height = height;
	this.squares = new SquareType[width + 4][height + 4];  //Bytt här (height +4 , width +4)
	for (int i = 2; i < width + 2; i++) {
	    for (int j = 2; j < height + 2; j++) {
		squares[i][j] = SquareType.EMPTY; //Bytt här (j, i)
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


    public void rdnBoard() {
	for (int i = 0; i < width; i++) {
	    for (int j = 0; j < height; j++) {
		squares[i][j] = SquareType.values()[rdn.nextInt(7)];
		notifyListeners();
	    }
	}
    }

    public SquareType getSquareAt(int x, int y) {
	if (falling != null) {
	    int tetroheight = falling.getPolyHeight() - 1; //Kollar höjden på falling
	    int tetrowidth = falling.getPolyWidth() - 1; //Bredden
	    int boardX = x + 2;
	    int boardY = y + 2;


	    if (fallingX <= boardX && boardX <= fallingX + tetroheight && fallingY <= boardY &&
		boardY <= fallingY + tetrowidth) { //Kollar om (x,y) är inom falling. Om inte --> titta på board.

	        int i = boardX - fallingX; //Båda dessa ger x respektive y index inom falling, beroende av var på boarden vi kollar.
		int j = boardY - fallingY;

		if (falling.getPolyminoAt(i, j) == SquareType.EMPTY) { //Empty --> Kolla på board.
		    return getSquares(x, y);
		}
		return falling.getPolyminoAt(i, j); // Annars --> Kolla falling.
	    }
	}
	return getSquares(x,y);
    }

    public void addBoardListener(BoardListener bl) {
	listenerlist.add(bl);
	System.out.println("Nu finns det en listener");
    }

    private void notifyListeners() {
	for (BoardListener listeners : listenerlist) {
	    listeners.boardChanged();
	}
    }

    public void moveRight() {
	fallingX += 1;
	if (hasCollision()) {
	    fallingX -= 1;
	}
	notifyListeners();
    }

    public void moveLeft() {
	fallingX -= 1;
	if (hasCollision()) {
	    fallingX += 1;
	}
	notifyListeners();
    }

    public void rotate(boolean right) {
	Poly oldfalling = falling;
        if (right) {
	    falling = rotateRight();
	    if (hasCollision()) {
		System.out.println("Det trodde du va");
	        falling = oldfalling;
	    }
	}
        if (!right) {
	    for (int i = 0; i < 3; i++) { //Rotera 3 ggr för att få en vänsterrotation.
		falling = rotateRight();
	    }
	    if (hasCollision()) {
		System.out.println("Det trodde du va");
	        falling = oldfalling;
	    }
	}
	notifyListeners();
    }

    public Poly rotateRight() {
        int size = falling.getPolyHeight(); //samma height som width

	Poly newPoly = new Poly(new SquareType[size][size]);

	for (int r = 0; r < size; r++) {
	    for (int c = 0; c < size; c++){
		newPoly.getPolymino()[c][size-1-r] = falling.getPolymino()[r][c];
	    }
	}
	return newPoly;
    }

    public void fallingToBoard() {//"Fäster" tetrominon på boarden.
	for (int i = 0; i < falling.getPolyWidth(); i++) {
	    for (int j = 0; j < falling.getPolyHeight(); j++) {
		if (falling.getPolyminoAt(i, j) != SquareType.EMPTY) {
		    squares[fallingX + i][fallingY + j] = falling.getPolyminoAt(i, j);
		}
	    }
	}
    }

    public void tick() {
	if (!gameover) {
	    if (falling != null && fallingY < height + 2) {
		fallingY += 1;
		if (hasCollision()) {
		    fallingY -= 1;
		    fallingToBoard();
		    removeLines();
		    falling = null;
		}
	    }
	    if (falling == null) {
		int boardmiddle = (width + 2) / 2; //width +2 för att tetrominon ska hamna ett steg till höger. Snyggare.
		//falling = new TetrominoMaker().getPoly(rdn.nextInt(7));
		falling = new TetrominoMaker().getPoly(0); //Används bara för test
		fallingY = 2; //outside är på 0 & 1, därför sätts den till 2.
		fallingX = boardmiddle;
		if (hasCollision()) {
		    falling = null;
		    gameover = true;
		}
	    }
	}
	notifyListeners();
    }

    public boolean checkLines(int y) { //Ändra samtliga squares till getSquares istället. Då behövs inte +2.
        SquareType memorysquare = null;
        int memorycounter = 0;

	for (int i = 0; i < width ; i++) {
	    if (memorysquare == null) {
	        memorysquare = getSquares(i, y);
	    }
	    if (getSquares(i, y) != SquareType.EMPTY) {
	        memorysquare = getSquares(i, y);
	        memorycounter += 1;
	    }
	}
	return memorycounter == width;
    }

    public void removeLines() {
	for (int y = 0; y < height; y++) {
	    if (checkLines(y)) {
		score += 100; //Testar score
		System.out.println(score);

		for (int x = 0; x < width; x++) {
		    for (int k = y ; k > 2 ; k--) {
			squares[x+2][k+2] = getSquares(x, k-1);
		    }
		}
	    }
	}
	notifyListeners();
    }


    public boolean hasCollision() {
	if (falling != null) {
	    for (int i = 0; i < falling.getPolyWidth(); i++) {
		for (int j = 0; j < falling.getPolyHeight(); j++) {
		    if (falling.getPolyminoAt(i, j) != SquareType.EMPTY) {
			if (squares[fallingX + i][fallingY + j] != SquareType.EMPTY) {
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
	return squares[x + 2][y + 2]; //+2 här
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
