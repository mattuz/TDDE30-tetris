package se.liu.ida.matge373.tddd78.tetris;

public class BoardTest
{
    public static void main(String[] args) {
	Board b2 = new Board(8, 10);
	for (int i = 0; i < 10; i++) {
	    b2.rdnBoard(b2);
	    String b2string = BoardToTextConverter.convertToTextBoard(b2);
	    System.out.println(b2string);
	}

    }
}
