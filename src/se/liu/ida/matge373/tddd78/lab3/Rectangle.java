package se.liu.ida.matge373.tddd78.lab3;

import java.awt.Color;

public class Rectangle extends AbstractShape
{
    private int height;
    private int width;

    public Rectangle(final int x, final int y, final int height, final int width, final Color color) {
	super(x, y, color);
	this.height = height;
	this.width = width;
    }

    @Override public String toString() {
	return "Rectangle{" + "x=" + x + ", y=" + y + ", height=" + height + ", width=" + width + ", color=" + color + '}';
    }

    @Override public void draw() {
	System.out.println("Ritar: " + this);
    }
}
