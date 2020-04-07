package objects;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends GObject  {

	private Color color;
	
	public Rect(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		this.color = color;
	}

	@Override
	public void paintObject(Graphics g) {
		g.setColor(color); /* set rect color */
		g.fillRect(x, y, width, height); /* fill color in rect shape */
	}
	
	@Override
	public void paintLabel(Graphics g) {
		g.setColor(Color.darkGray); /* set text color */
		g.drawString("Rect", x, y+70); /* draw text */
	}
	
}
