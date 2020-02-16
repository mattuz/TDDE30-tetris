package se.liu.ida.matge373.tddd78.lab3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestShapes
{
    public static void main(String[] args) {
	final List<Shape> shapes = new ArrayList<>();
	Circle c1 = new Circle(2, 0, 0, Color.red);
	Circle c2 = new Circle(5, 1, 2, Color.green);
	Circle c3 = new Circle(7, 5, 5, Color.blue);
	Rectangle r1 = new Rectangle(5, 4, 3, 5, Color.black);
	Rectangle r2 = new Rectangle(0, 0, 3, 2, Color.pink);
	Text t1 = new Text(5, 5, 10, Color.blue,"Hello World");
	Text t2 = new Text(10, 10, 15, Color.green, "Green World Hello :)"); //Testfall. Behöver inte förtydligas.
	shapes.add(t1);
	shapes.add(t2);
	shapes.add(c1);
	shapes.add(c2);
	shapes.add(c3);
	shapes.add(r1);
	shapes.add(r2);
	for (Shape shape : shapes) {
	//shape.draw();
	}


    }
}
