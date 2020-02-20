package se.liu.ida.matge373.tddd78.tetris;

public class BoardToTextConverter
{
    public static String convertToTextBoard(Board board) {
	StringBuilder textboard = new StringBuilder();
	for (int i = 0; i < board.getHeight(); i++) {
	    for (int j = 0; j < board.getWidth(); j++) {
		switch (board.getSquareAt(i, j)) {
		    case EMPTY:
			textboard.append(" - ");
			break;
		    case I:
			textboard.append(" # ");
			break;
		    case J:
			textboard.append(" % ");
			break;
		    case L:
			textboard.append(" & ");
			break;
		    case O:
			textboard.append(" ¤ ");
			break;
		    case S:
			textboard.append(" @ ");
			break;
		    case T:
			textboard.append(" § ");
			break;
		    case Z:
			textboard.append(" $ ");
			break;
		    default:
			return "Detta bör ej ske.";
		}
	    }
	    textboard.append("\n");
	}
	textboard.append("\n");
	String result = textboard.toString();
	return result;
    }
}
