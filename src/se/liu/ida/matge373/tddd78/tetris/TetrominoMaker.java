package se.liu.ida.matge373.tddd78.tetris;

import static se.liu.ida.matge373.tddd78.tetris.SquareType.*;

public class TetrominoMaker
{
    public int getNumberOfTypes() {
        return (values().length-1);
    }

    public Poly getPoly(int n) {
        SquareType[][] polymino;
        switch (n) {
	    case 0:
		polymino = createI();
	        break;
	    case 1:
		polymino = createJ();
	        break;
	    case 2:
		polymino = createL();
	        break;
	    case 3:
		polymino = createO();
	        break;
	    case 4:
	        polymino = createS();
	        break;
	    case 5:
		polymino = createT();
	        break;
	    case 6:
	        polymino = createZ();
	        break;
	    default:
	        throw new IllegalArgumentException("Invalid index: " + n);
	}
	return new Poly(polymino);
    }

    public SquareType[][] createI() {
        SquareType[][] polymino = new SquareType[4][4];
        polymino[0][0] = EMPTY;
	polymino[0][1] = EMPTY;
	polymino[0][2] = EMPTY;
	polymino[0][3] = EMPTY;
	polymino[1][0] = I;
	polymino[1][1] = I;
	polymino[1][2] = I;
	polymino[1][3] = I;
	polymino[2][0] = EMPTY;
	polymino[2][1] = EMPTY;
	polymino[2][2] = EMPTY;
	polymino[2][3] = EMPTY;
	polymino[3][0] = EMPTY;
	polymino[3][1] = EMPTY;
	polymino[3][2] = EMPTY;
	polymino[3][3] = EMPTY;
	return polymino;
    }
    public SquareType[][] createJ() {
	SquareType[][] polymino = new SquareType[3][3];
	polymino[0][0] = J;
	polymino[0][1] = EMPTY;
	polymino[0][2] = EMPTY;
	polymino[1][0] = J;
	polymino[1][1] = J;
	polymino[1][2] = J;
	polymino[2][0] = EMPTY;
	polymino[2][1] = EMPTY;
	polymino[2][2] = EMPTY;
	return polymino;
    }
    public SquareType[][] createL() {
	SquareType[][] polymino = new SquareType[3][3];
	polymino[0][0] = EMPTY;
	polymino[0][1] = EMPTY;
	polymino[0][2] = L;
	polymino[1][0] = L;
	polymino[1][1] = L;
	polymino[1][2] = L;
	polymino[2][0] = EMPTY;
	polymino[2][1] = EMPTY;
	polymino[2][2] = EMPTY;
	return polymino;
    }
    public SquareType[][] createO() {
	SquareType[][] polymino = new SquareType[2][2];
	polymino[0][0] = O;
	polymino[0][1] = O;
	polymino[1][0] = O;
	polymino[1][1] = O;
	return polymino;
    }
    public SquareType[][] createS() {
	SquareType[][] polymino = new SquareType[3][3];
	polymino[0][0] = EMPTY;
	polymino[0][1] = S;
	polymino[0][2] = S;
	polymino[1][0] = S;
	polymino[1][1] = S;
	polymino[1][2] = EMPTY;
	polymino[2][0] = EMPTY;
	polymino[2][1] = EMPTY;
	polymino[2][2] = EMPTY;
	return polymino;
    }
    public SquareType[][] createT() {
	SquareType[][] polymino = new SquareType[3][3];
	polymino[0][0] = EMPTY;
	polymino[0][1] = T;
	polymino[0][2] = EMPTY;
	polymino[1][0] = T;
	polymino[1][1] = T;
	polymino[1][2] = T;
	polymino[2][0] = EMPTY;
	polymino[2][1] = EMPTY;
	polymino[2][2] = EMPTY;
	return polymino;
    }
    public SquareType[][] createZ() {
	SquareType[][] polymino = new SquareType[3][3];
	polymino[0][0] = Z;
	polymino[0][1] = Z;
	polymino[0][2] = EMPTY;
	polymino[1][0] = EMPTY;
	polymino[1][1] = Z;
	polymino[1][2] = Z;
	polymino[2][0] = EMPTY;
	polymino[2][1] = EMPTY;
	polymino[2][2] = EMPTY;
	return polymino;
    }
}
