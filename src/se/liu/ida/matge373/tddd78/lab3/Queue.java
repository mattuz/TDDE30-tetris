package se.liu.ida.matge373.tddd78.lab3;

import se.liu.ida.matge373.tddd78.lab2.Person;

public class Queue extends ListManipulator
{
    public void enqueue(Person person) {
	elements.add(person);
    }

    public Person dequeue() {
	Person removedperson = elements.get(0);
	elements.remove(0);
	return removedperson;
    }
}
