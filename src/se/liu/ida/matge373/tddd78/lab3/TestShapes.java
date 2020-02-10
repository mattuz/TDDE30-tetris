package se.liu.ida.matge373.tddd78.lab3;

import java.awt.*;
import java.util.ArrayList;

public class TestShapes
{
    public static void main(String[] args) {
	final ArrayList<Shape> shapes = new ArrayList<>();
	Circle c1 = new Circle(2, 0, 0, Color.red);
	Circle c2 = new Circle(5, 1, 2, Color.green);
	Circle c3 = new Circle(7, 5, 5, Color.blue);
	Rectangle r1 = new Rectangle(5, 4, 3, 5, Color.black);
	Rectangle r2 = new Rectangle(0, 0, 3, 2, Color.pink);
	shapes.add(c1);
	shapes.add(c2);
	shapes.add(c3);
	shapes.add(r1);
	shapes.add(r2);
	for (Shape shape : shapes) {
	shape.draw();
	}


    }
}
