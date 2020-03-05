package se.liu.ida.matge373.tddd78.tetris;

public class Highscore
{
    private int score;
    private String person = null;

    public Highscore(final int score, final String person) {
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
