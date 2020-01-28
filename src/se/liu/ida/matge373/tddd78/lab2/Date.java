package se.liu.ida.matge373.tddd78.lab2;

public class Date
{
    private int year;
    private Month month;
    private int day;

    public Date(final int year, final Month month, final int day) {
	this.year = year;
	this.month = month;
	this.day = day;
    }

    @Override public String toString() {
	return year + " - " + month + " - " + day;
    }
}
