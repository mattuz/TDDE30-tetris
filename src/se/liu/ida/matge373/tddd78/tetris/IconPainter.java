package se.liu.ida.matge373.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;

public class IconPainter extends JComponent
{
    final private ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("aa.jpg"));
   private JFrame frame;


    public IconPainter(final JFrame frame) {
	this.frame = frame;
    }

    public void paintComponent(final Graphics g) {
        //TODO BILDEN ska läsas in i ett separat fönster först (eller att spelet inte syns när bilden är uppe).
	final Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(	RenderingHints.KEY_ANTIALIASING,
				     RenderingHints.VALUE_ANTIALIAS_ON);

	final AffineTransform old = g2d.getTransform();

	// Steg 4: Gör ingenting (skala faktor 1)
	final AffineTransform at = AffineTransform.getScaleInstance(1, 1);

	// Steg 3:  Flytta (i "oskalade" koordinater)
	at.translate(50,50);

	// Steg 2:  Skala ner alla koordinater
	at.scale(1, 1);

	g2d.setTransform(at);

	// Steg 1:  Starta på (0,0)
	icon.paintIcon(this, g, 0, 0);

	g2d.setTransform(old);
    }
    public void pictureMaker(IconPainter pic) {
	frame.setLayout(new GridLayout(1, 1));
	frame.setSize(800, 800);
	frame.add(pic);
	frame.setVisible(true);
    }
}

