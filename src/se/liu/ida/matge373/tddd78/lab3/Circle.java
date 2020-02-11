package se.liu.ida.matge373.tddd78.lab3;

import java.awt.Color;

public class Circle extends AbstractShape
{
    private int radius;

    public Circle(final int radius, final int x, final int y, final Color color) {
	super(x, y, color);
	if (radius < 0) {
	    throw new IllegalArgumentException("Negativ radie!");
	}
	this.radius = radius;
    }

    public int getRadius() {
	return radius;
    }

    @Override public void draw() {
	System.out.println("Ritar: " + this);
    }

    @Override public String toString() {
	return "Circle{" + "radius=" + radius + ", x=" + getX() + ", y=" + getY() + ", color=" + getColor() + '}';
    }
}
