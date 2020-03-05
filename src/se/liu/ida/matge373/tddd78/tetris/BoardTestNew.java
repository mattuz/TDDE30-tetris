package se.liu.ida.matge373.tddd78.tetris;


public class BoardTestNew
{
    public static void main(String[] args) {
	Board b2 = new Board(8, 8);
	HighscoreList hs = new HighscoreList();
	TetrisViewer v1 = new TetrisViewer(b2, hs);
	v1.startGame(true);
	v1.show();
	b2.addBoardListener(v1.getBoardgraphics());
	v1.keyBindings();
	v1.doStep();

    }
}

