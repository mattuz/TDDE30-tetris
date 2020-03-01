package se.liu.ida.matge373.tddd78.tetris;

public class BoardTestNew
{
    public static void main(String[] args) {
	Board b2 = new Board(10, 20);
	TetrisViewer v1 = new TetrisViewer(b2);
	b2.addBoardListener(v1.getBoardgraphics());
	b2.hasCollision();
	v1.keyBindings();
	v1.show();
	v1.doStep();



    }
}

