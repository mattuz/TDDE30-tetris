package se.liu.ida.matge373.tddd78.lab3;

import java.awt.*;
import java.util.ArrayList;

public class TestCircle
{
    public static void main(String[] args) {
	final ArrayList<Circle> circles = new ArrayList<>();
	Circle c1 = new Circle(2, 0, 0, Color.red);
	Circle c2 = new Circle(5, 1, 2, Color.green);
	Circle c3 = new Circle(7, 5, 5, Color.blue);
	circles.add(c1);
	circles.add(c2);
	circles.add(c3);
	for (Circle circle : circles) {
	    System.out.println(circle.getX() + " " + circle.getY());
	}

    }
}
