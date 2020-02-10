package se.liu.ida.matge373.tddd78.lab3;

import java.awt.Color;

public class Rectangle implements Shape
{
    private int x;
    private int y;
    private int height;
    private int width;
    private Color color;

    public Rectangle(final int x, final int y, final int height, final int width, final Color color) {
	this.x = x;
	this.y = y;
	this.height = height;
	this.width = width;
	this.color = color;
    }

    @Override public String toString() {
	return "Rectangle{" + "x=" + x + ", y=" + y + ", height=" + height + ", width=" + width + ", color=" + color + '}';
    }

    @Override public int getX() {
	return 0;
    }

    @Override public int getY() {
	return 0;
    }

    @Override public Color getColor() {
	return null;
    }

    @Override public void draw() {
	System.out.println("Ritar: " + this);
    }
}
