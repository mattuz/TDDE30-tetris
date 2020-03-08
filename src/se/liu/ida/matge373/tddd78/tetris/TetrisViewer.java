package se.liu.ida.matge373.tddd78.tetris;

import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;


public class TetrisViewer extends AbstractAction //Kan jag ta bort detta? På något sätt lägga in menyalternativet i metoden nedan.
{
    private JFrame frame = new JFrame();
    private TetrisComponent boardgraphics;
    private Board board;
    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu options = new JMenu("Options");
    private JMenuItem menuItem = null;
    private IconPainter picture = null;
    private JMenuItem scoreItem = null;
    private String name = null;
    private HighscoreList highscorelist;
    private StringBuilder score = new StringBuilder();


    public TetrisViewer(final Board board, final HighscoreList highscorelist) { //TODO kolla om detta ska göras såhär (Piotr)
	this.board = board;
	this.highscorelist = highscorelist;
	this.boardgraphics = new TetrisComponent(board); //Här tar den in boarden som i sin tur kommer hanteras av paintcomponent och dylikt.
	menuOptions();
}

    public void startGame(boolean visible) { //Lägger till bilden på spelplanen. Tas bort när det finns en falling.
        this.picture = new IconPainter(frame);
        picture.pictureMaker(picture);
    }

    public String hiscoreLooper() { //TODO se till att detta fungerar!
	for (int i = 0; i < highscorelist.getHighscores().size(); i++) {
	    score.append(highscorelist.getHighscores().get(i).getPerson()).append(": "); //Gör tyå såhär här. Ful lösning men funkar
	    score.append(highscorelist.getHighscores().get(i).getScore()).append("\n");
	}
	String scorestring = score.toString();
	return scorestring;
    }



    public void gameOverFunctions() throws IOException, FileNotFoundException {
        if (board.isGameover() && name == null) {
            name = JOptionPane.showInputDialog("Your score was: " + board.getScore() + "\n" + "Insert name gamer!");
	    if (name != null) {
		//highscorelist.iterHighscores();

		Highscore highscore = new Highscore(board.getScore(), name);
		highscorelist.addHighscore(highscore);
		System.out.println("HIGHSCORE: " + highscore.getPerson() + ": " + highscore.getScore() + " HAR LAGTS TILL!");
		highscorelist.getHighscores().sort(new ScoreComparator());

		//JOptionPane.showMessageDialog(frame, hiscoreLooper()); //nullpointer
		//JOptionPane.showMessageDialog(frame, hiscoreLooper());
		/*Gson gson = new Gson();
		String listAsJson = gson.toJson(highscorelist);
		JOptionPane.showMessageDialog(frame, listAsJson);*/


	    }
	}
    }


    public void menuOptions() {
        menuItem = new JMenuItem("Avsluta", MouseEvent.BUTTON1);
        scoreItem = new JMenuItem("Score: " + board.getScore());
        JMenuItem menuItem2 = new JMenuItem("Nytt spel", MouseEvent.BUTTON1);
	options.add(menuItem);
	options.add(menuItem2);
	menuBar.add(options);
	menuItem2.addActionListener(this);
	menuItem.addActionListener(this);
	menuBar.add(Box.createHorizontalGlue());
	menuBar.add(scoreItem);
    }


    public void keyBindings() {
	InputMap im = boardgraphics.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	ActionMap am = boardgraphics.getActionMap();


	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "LeftArrow");
	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "RightArrow");
	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UpArrow");
	im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DownArrow");


	am.put("LeftArrow", new ArrowMovement("LeftArrow"));
	am.put("RightArrow", new ArrowMovement("RightArrow"));
	am.put("UpArrow", new ArrowMovement("UpArrow"));
	am.put("DownArrow", new ArrowMovement("DownArrow"));
	am.put("Avsluta", new ArrowMovement("Avsluta"));
    }

    @Override public void actionPerformed(final ActionEvent actionEvent) { //Hur gör jag för att få denna att fungera i den ovan? Eller tvärtom? //TODO 2 actions i samma klass..
	if ("Avsluta".equals(actionEvent.getActionCommand())) {
	    if (JOptionPane.showConfirmDialog(null, "Vill du avsluta?", "Varning",
					      JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
	        System.exit(0);
	    }
	}
	else if ("Nytt spel".equals(actionEvent.getActionCommand())) {
	    if (JOptionPane.showConfirmDialog(null, "Spela igen?", "Nytt spel",
					      JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
	        frame.dispose();
		Board b2 = new Board(8, 8);
		TetrisViewer v1 = new TetrisViewer(b2, highscorelist);
		v1.startGame(true);
		b2.addBoardListener(v1.getBoardgraphics());
		v1.keyBindings();
		try {
		    v1.show();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		v1.doStep();
	    }
	    else {
	        System.exit(0); //Får man ha med detta?
	    }
	}
    }


    private class ArrowMovement extends AbstractAction {
        private String command;

	private ArrowMovement(final String command) {
	    this.command = command;
	}


	@Override public void actionPerformed(final ActionEvent actionEvent) {
	    if (command.equalsIgnoreCase("LeftArrow")) {
		board.moveLeft();
	    }
	    else if (command.equalsIgnoreCase("RightArrow")) {
	        board.moveRight();
	    }
	    else if (command.equalsIgnoreCase("UpArrow")) {
	        board.rotate(true);
	    }
	    else if (command.equalsIgnoreCase("DownArrow")) {
	        board.rotate(false);
	    }
	    else if (command.equalsIgnoreCase("Avsluta")) {
	        System.exit(0);
	    }
	}
    }


    public void doStep() {
	final Action doOneStep = new AbstractAction()
	{

	    public void actionPerformed(final ActionEvent actionEvent) {
		board.tick();
		scoreItem.setText("Score: " + board.getScore()); //FUNKAR!!! Ha den inte här dock, inte optimalt
		frame.remove(picture); //tar bort bilden. Inte säker om denna ska ligga och köras varje tick dock.. Gör en ny timer kke?
		try {
		    gameOverFunctions();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	};
	final Timer clockTimer = new Timer(200, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();

    }




    public TetrisComponent getBoardgraphics() {
	System.out.println("hello");
	return boardgraphics;
    }

    public void show() throws IOException, FileNotFoundException {
	frame.setLayout(new BorderLayout());
	frame.add(boardgraphics, BorderLayout.CENTER);
	frame.pack();
	frame.setVisible(true);
	frame.setJMenuBar(menuBar);
	highscorelist.iterHighscores();

    }


}
