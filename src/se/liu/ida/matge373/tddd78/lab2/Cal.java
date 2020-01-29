package se.liu.ida.matge373.tddd78.lab2;

import java.util.ArrayList;
import java.util.List;

public class Cal
{
    private List<Appointment> appointments;

    public Cal() {
	this.appointments = new ArrayList<>();
    }

    public void show() {
	for (Appointment appointment : appointments) {
	    System.out.println(appointment);
	}
    }

    public void book(int year, String month, int day,
		     int startHour, int startMinute, int endHour,
		     int endMinute, String subject) {
        if (year < 1970) {
            throw new IllegalArgumentException("Year lower than 1970.");
	}
        if ((0 > startHour && startHour > 23) ||
	    (0 > startMinute && startMinute > 59) ||
	    (0 > endHour && endHour > 23) ||
	    (0 > endMinute && endMinute > 59)) {
            throw new IllegalArgumentException("Start or end time (hr or min) out of bounds.");
	}
        if (Month.getMonthDays(month) == -1) {
            throw new IllegalArgumentException(month + " is not a month.");
	}
	if (Month.getMonthNumber(month) == -1) {
	    throw new IllegalArgumentException(month + " is not a month.");
	}
        else {
            Month month2 = new Month(month, Month.getMonthNumber(month), Month.getMonthDays(month));
            Date date = new Date(year, month2, day);
            TimePoint timepointstart = new TimePoint(startHour, startMinute);
            TimePoint timepointend = new TimePoint(endHour, endMinute);
            TimeSpan tspan = new TimeSpan(timepointstart, timepointend);
            Appointment appointment = new Appointment(subject, date, tspan);
            appointments.add(appointment);
	}

    }
}
