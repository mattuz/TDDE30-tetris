package se.liu.ida.matge373.tddd78.lab2;

import javax.xml.namespace.QName;
import java.time.LocalDate;
import java.time.Period;

public class Person
{
    private String name;
    private LocalDate birthDay;

    public Person(final String name, final LocalDate birthDay) {
	this.name = name;
	this.birthDay = birthDay;
    }

    public static void main(String[] args) {
	Person p1 = new Person("Matthias", LocalDate.of(1998, 11, 25));
	Person p2 = new Person("Gustav", LocalDate.of(2003,03,17));
	Person p3 = new Person("Felicia", LocalDate.of(1965,3,10));
	Person p4 = new Person("Overklig", LocalDate.of(1255, 11, 19));
	System.out.println(p1);
	System.out.println(p2);
	System.out.println(p3);
	System.out.println(p4);
    }

    public int getAge() {
        Period timespan = Period.between(birthDay, LocalDate.now());
        int age = timespan.getYears();
        return age;
    }

    @Override public String toString() {
	return name + " " + getAge();
    }
}

