package se.liu.ida.matge373.tddd78.tetris;

import java.util.ArrayList;
import java.util.List;

public class HighscoreList
{
    private List<Highscore> highscores = new ArrayList<>();


    public void addHighscore(Highscore highscore) {
        highscores.add(highscore);
    }



    public List<Highscore> getHighscores() {
	return highscores;
    }

}
