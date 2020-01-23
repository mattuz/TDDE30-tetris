package se.liu.ida.matge373.tddd78.lab2;

import java.time.LocalDate;

public class Person
{
    private String name;
    private LocalDate birthDay;

    public Person(final String name, final LocalDate birthDay) {
	this.name = name;
	this.birthDay = birthDay;
    }

    public static void main(String[] args) {
	LocalDate.of(1998, 11, 25);
    }
}
