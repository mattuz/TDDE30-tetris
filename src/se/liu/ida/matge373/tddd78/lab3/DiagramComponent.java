package se.liu.ida.matge373.tddd78.lab3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DiagramComponent extends JComponent
{
    private List<Shape> shapes;

    public DiagramComponent(final List shapes) {
	this.shapes = new ArrayList<Shape>();
    }

    public void addShape(Shape s) {
      	shapes.add(s)

    }

    @Override protected void paintComponent(final Graphics g) {
	super.paintComponent(g);

	// Senare ska vi rita upp alla former här!
    }
}
