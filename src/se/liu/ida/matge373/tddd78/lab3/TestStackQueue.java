package se.liu.ida.matge373.tddd78.lab3;

import se.liu.ida.matge373.tddd78.lab2.Person;

import java.time.LocalDate;

public class TestStackQueue
{
    public static void main(String[] args) {
	Stack s1 = new Stack();
	s1.push(new Person("Matthias", LocalDate.of(1998, 11, 25))); //Tester där jag lägger in datum
	s1.push(new Person("Gustav", LocalDate.of(2003,03,17)));     //Därför är det oviktigt om det är
	s1.push(new Person("Hilda", LocalDate.of(1999, 11, 11)));    //"magic number".
	s1.push(new Person("Kalle", LocalDate.of(1120, 11, 11)));
	s1.push(new Person("Jonas", LocalDate.of(1985, 11, 11)));
	while (!s1.isEmpty()) {
	    //s1.pop();
	    System.out.println(s1.pop());
	}
	Queue q1 = new Queue();
	q1.enqueue(new Person("Matthias", LocalDate.of(1998, 11, 25)));
	q1.enqueue(new Person("Gustav", LocalDate.of(2003,03,17)));
	q1.enqueue(new Person("Hilda", LocalDate.of(1999, 11, 11)));
	q1.enqueue(new Person("Kalle", LocalDate.of(1120, 11, 11)));
	q1.enqueue(new Person("Jonas", LocalDate.of(1985, 11, 11)));
	while (!q1.isEmpty()) {
	    //s1.pop();
	    System.out.println(q1.dequeue());
	}


    }
}
