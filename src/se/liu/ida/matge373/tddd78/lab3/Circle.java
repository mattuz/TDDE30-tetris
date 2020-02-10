package se.liu.ida.matge373.tddd78.lab3;

import java.awt.Color;

public class Circle implements Shape
{
    private int radius;
    private int x;
    private int y;
    private Color color;

    public Circle(final int radius, final int x, final int y, final Color color) {
	if (radius < 0) {
	    throw new IllegalArgumentException("Negativ radie!");
	}
	this.radius = radius;
	this.x = x;
	this.y = y;
	this.color = color;
    }

    public int getRadius() {
	return radius;
    }

    @Override public int getX() {
	return x;
    }

    @Override public int getY() {
	return y;
    }

    @Override public Color getColor() {
	return color;
    }

    @Override public void draw() {
	System.out.println("Ritar: " + this);
    }

    @Override public String toString() {
	return "Circle{" + "radius=" + radius + ", x=" + x + ", y=" + y + ", color=" + color + '}';
    }
}
