package se.liu.ida.matge373.tddd78.tetris;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoardTestNew
{
    public static void main(String[] args) {
	Board b2 = new Board(10, 20);
	TetrisViewer v1 = new TetrisViewer(b2);
	//IconPainter testis = new IconPainter(); //Vet inte hur jag ska få denna att visas nån sek innan spelet börjar..
	b2.addBoardListener(v1.getBoardgraphics());
	b2.hasCollision();
	v1.keyBindings();
	v1.show();
	v1.doStep();
	//testis.pictureMaker();




    }
}

