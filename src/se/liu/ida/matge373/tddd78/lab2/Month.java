package se.liu.ida.matge373.tddd78.lab2;

public class Month
{
    private String name;
    private int number;
    private int days;

    public Month(final String name, final int number, final int days) {
	this.name = name;
	this.number = number;
	this.days = days;
    }

    public String getName() {
	return name;
    }

    public int getNumber() {
	return number;
    }

    public int getDays() {
	return days;
    }

    public static void main(String[] args) {

	System.out.println(getMonthNumber("March"));
    }

    @Override public String toString() {
	return name;
    }

    public static int getMonthNumber(String name) {
	int monthnumber = 0;
	switch (name) {
	    case ("January"):
		monthnumber = 1;
		break;
	    case "February":
		monthnumber = 2;
		break;
	    case "March":
		monthnumber = 3;
		break;
	    case "April":
		monthnumber = 4;
		break;
	    case "May":
		monthnumber = 5;
		break;
	    case "June":
		monthnumber = 6;
		break;
	    case "July":
		monthnumber = 7;
		break;
	    case "August":
		monthnumber = 8;
		break;
	    case "September":
		monthnumber = 9;
		break;
	    case "October":
		monthnumber = 10;
		break;
	    case "November":
		monthnumber = 11;
		break;
	    case "December":
		monthnumber = 12;
		break;
	    default:
		return -1;
	}
	return monthnumber;
    }

    public static int getMonthDays(String name) {
	int monthdays = 0;
	switch (name) {
	    case "January": //Kan man göra if-satser här och kolla ex. case if (name == "January" || "March" || osv..){}:??
	    case "March":
		monthdays = 31;
		break;

	    case "February":
		monthdays = 27;
		break;

	    case "April":
		monthdays = 30;
		break;
	    case "May":
		monthdays = 31;
		break;
	    case "June":
		monthdays = 30;
		break;
	    case "July":
		monthdays = 31;
		break;
	    case "August":
		monthdays = 31;
		break;
	    case "September":
		monthdays = 30;
		break;
	    case "October":
		monthdays = 31;
		break;
	    case "November":
		monthdays = 30;
		break;
	    case "December":
		monthdays = 31;
		break;
	    default:
		return -1;
	}
	return monthdays;
    }
}
