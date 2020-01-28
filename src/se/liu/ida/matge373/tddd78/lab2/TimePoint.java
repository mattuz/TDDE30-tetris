package se.liu.ida.matge373.tddd78.lab2;

public class TimePoint
{
    private int hour;
    private int minute;

    public TimePoint(final int hour, final int minute) {
	this.hour = hour;
	this.minute = minute;
    }

    public int getHour() {
	return hour;
    }

    public int getMinute() {
	return minute;
    }

    @Override public String toString() {
	return hour + ":" + minute;
	//String.format("%02d:%02d")
    }

    public static void main(String[] args) {
	TimePoint h1 = new TimePoint(11, 22);
	TimePoint h2 = new TimePoint(12, 25);
	TimeSpan t1 = new TimeSpan(h1, h2);

	System.out.println(t1);
    }
}
