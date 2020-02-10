package se.liu.ida.matge373.tddd78.lab3;

import java.awt.Color;

public class Text implements Shape
{
    private int x;
    private int y;
    private int size;
    private Color color;
    private String text;

    public Text(final int x, final int y, final int size, final Color color, final String text) {
	this.x = x;
	this.y = y;
	this.size = size;
	this.color = color;
	this.text = text;
    }

    @Override public String toString() {
	return "Text{" + "x=" + x + ", y=" + y + ", size=" + size + ", color=" + color + ", text='" + text + '\'' + '}';
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
