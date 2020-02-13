package se.liu.ida.matge373.tddd78.lab3;

import se.liu.ida.matge373.tddd78.lab2.Person;

import java.util.ArrayList;
import java.util.List;

public class ListManipulator
{
    protected List<Person> elements = new ArrayList<>();

    public int size() {return elements.size();}

    public boolean isEmpty() {return elements.isEmpty();}

    public boolean contains(final Object o) {return elements.contains(o);}

    public void clear() {elements.clear();}
}
