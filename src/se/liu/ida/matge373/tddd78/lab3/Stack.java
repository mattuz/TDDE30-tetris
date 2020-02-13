package se.liu.ida.matge373.tddd78.lab3;

import se.liu.ida.matge373.tddd78.lab2.Person;

import java.util.ArrayList;
import java.util.List;

public class Stack extends ListManipulator
{

    public void push(Person person) {
	elements.add(0, person);
    }

    public Person pop() {
	Person removedperson = elements.get(0);
	elements.remove(0);
	return removedperson;
    }

}
