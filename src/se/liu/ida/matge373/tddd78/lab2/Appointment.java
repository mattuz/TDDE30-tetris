package se.liu.ida.matge373.tddd78.lab2;

public class Appointment
{
    private String subject;
    private Date date;
    private TimeSpan timespan;

    public Appointment(final String subject, final Date date, final TimeSpan timespan) {
	this.subject = subject;
	this.date = date;
	this.timespan = timespan;
    }

    public String getSubject() {
	return subject;
    }

    public Date getDate() {
	return date;
    }

    public TimeSpan getTimespan() {
	return timespan;
    }

    public static void main(String[] args) {
        Month month1 = new Month("January", 1, 31);
	Date date1 = new Date(2018,month1 , 21);
	TimePoint t1 = new TimePoint(10, 00);
	TimePoint t2 = new TimePoint(12, 15);
	TimeSpan span1 = new TimeSpan(t1, t2);
	Appointment app = new Appointment("Testkör", date1, span1);
	System.out.println(app);
    }

    @Override public String toString() {
	return "Appointment: " + subject + ", " + date + ", " + timespan;
    }
}
