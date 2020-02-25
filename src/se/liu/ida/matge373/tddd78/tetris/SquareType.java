package se.liu.ida.matge373.tddd78.tetris;

import java.util.Random;

public enum SquareType
{
    EMPTY, I, O, T, S, Z, J, L, OUTSIDE;

    public static void main(String[] args) {
	Random rdn = new Random();
	for (int i = 0; i < 25; i++) { //används ej, kan tas bort. 25 är från gamla tester i lab 2.
	    System.out.println(rdn.nextInt(100));
	}
	for (int i = 0; i < 25; i++) {
	    System.out.println(SquareType.values()[rdn.nextInt(7)]);
	}
    }
}


