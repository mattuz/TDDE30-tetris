package se.liu.ida.matge373.tddd78.lab3;

import java.awt.*;

public interface Shape
{
    int getX();

    int getY();

    Color getColor();

    public void draw(final Graphics g);
}
