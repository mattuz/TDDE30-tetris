package se.liu.ida.matge373.tddd78.tetris;

import java.util.Random;

public enum SquareType
{
    EMPTY, I, O, T, S, Z, J, L;

    public static void main(String[] args) {
	Random rdn = new Random();
	for (int i = 0; i < 25; i++) {
	    System.out.println(rdn.nextInt(100));
	}
	for (int i = 0; i < 25; i++) {
	    System.out.println(SquareType.values()[rdn.nextInt(7)]);
	}
    }
}


