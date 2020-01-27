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
	getMonthDays("January");
    }

    public static int getMonthNumber(String name) {
	int monthnumber = 0;
        switch (name) {
	    case "January":
		return 1;
	    	break;
	    case "February":
		return 2;
	    break;
	    case "March":
		return 3;
	    break;
	    case "April":
		return 4;
	    break;
	    case "May":
		return 5;
	    break;
	    case "June":
		return 6;
	    break;
	    case "July":
		return 7;
	    break;
	    case "August":
		return 8;
	    break;
	    case "September":
		return 9;
	    break;
	    case "October":
		return 10;
	    break;
	    case "November":
		return 11;
	    break;
	    case "December":
		return 12;
	    break;
	    default:
		return -1;
	    break;
	}
    }

    public static int getMonthDays(String name) {
	switch (name) {
	    case "January":
		return 31;
	    break;
	    case "February":
		return 27;
	    break;
	    case "March":
		return 31;
	    break;
	    case "April":
		return 30;
	    break;
	    case "May":
		return 31;
	    break;
	    case "June":
		return 30;
	    break;
	    case "July":
		return 31;
	    break;
	    case "August":
		return 31;
	    break;
	    case "September":
		return 30;
	    break;
	    case "October":
		return 31;
	    break;
	    case "November":
		return 30;
	    break;
	    case "December":
		return 31;
	    break;
	    default:
		return -1;
	    break;
	}
    }
}
