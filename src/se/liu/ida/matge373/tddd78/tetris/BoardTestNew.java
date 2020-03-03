package se.liu.ida.matge373.tddd78.tetris;


public class BoardTestNew
{
    public static void main(String[] args) {
	Board b2 = new Board(8, 8);
	TetrisViewer v1 = new TetrisViewer(b2);
	v1.startGame(true);
	b2.addBoardListener(v1.getBoardgraphics());
	v1.keyBindings();
	v1.show();
	v1.doStep();




    }
}

