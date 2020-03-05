package se.liu.ida.matge373.tddd78.tetris;

import com.google.gson.annotations.Expose;

public class Highscore
{
    @Expose
    private int score;
    @Expose
    private String person = null;

    public Highscore(final int score, final String person) { //TODO Står att det ska vara en tom konstruktor. Det går ju inte?
	this.score = score;
	this.person = person;
    }

    public int getScore() {
	return score;
    }

    public String getPerson() {
	return person;
    }
}
