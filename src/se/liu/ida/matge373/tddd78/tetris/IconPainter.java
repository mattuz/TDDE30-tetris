package se.liu.ida.matge373.tddd78.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class IconPainter extends JComponent
{
    final private ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("aa.jpg"));
   private JFrame frame = new JFrame();


    public IconPainter() {

    }

    public void paintComponent(final Graphics g) {
	final Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(	RenderingHints.KEY_ANTIALIASING,
				     RenderingHints.VALUE_ANTIALIAS_ON);

	final AffineTransform old = g2d.getTransform();

	final AffineTransform at = AffineTransform.getScaleInstance(1, 1);

	at.translate(50,50); //Hur bilden ska ritas upp, tycker inte det behövs konstanter här heller.

	at.scale(1, 1);

	g2d.setTransform(at);

	// Steg 1:  Starta på (0,0)
	icon.paintIcon(this, g, 0, 0);

	g2d.setTransform(old);
    }
    public void pictureMaker(IconPainter pic) {
	frame.setLayout(new GridLayout(1, 1));
	frame.setSize(400, 400); //Storlek på frame, säger sig självt och kräver inga konstanter.
	frame.add(pic);
	frame.setVisible(true);
    }

    public void pictureRemover() {
        frame.dispose();
    }
}

