package lab10;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Portrait15IMM extends Portrait
{
	public Portrait15IMM()
	{
		super(0.2);
		setSpreadEagleness(0.2);
		setBodyHeight(0.25);
		setArmSpan(0.2);
		setArmRaise(0.1);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("me.jpg"));
		} catch (IOException e) {
			System.err.println("Could not find the image \'me.jpg\'");
			System.err.println("Painting sad face instead.\n");
			paintError(g);
			
			return;
		}
		
		super.paintComponent(g);
		int midpoint = getWidth()/2;
		g.drawImage(img, midpoint-headRadius, 0, headRadius*2+2, headRadius*2+2, null);
	}
	
	public void paintError(Graphics g)
	{
		super.paintComponent(g);
		int midpoint = getWidth()/2;
		g.drawArc(midpoint-headRadius/2, headRadius, headRadius, headRadius, 0, 180);
		
		double x0 = midpoint - headRadius/2;
		double x1 = midpoint + headRadius/2;
		double y = headRadius-Math.sin(x0/headRadius)*headRadius;
		
		g.fillOval((int)x0-6, (int)y, 6, 6);
		g.fillOval((int)x1, (int)y, 6, 6);
	}
}