package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class CompositeGObject extends GObject {

	private List<GObject> gObjects;

	public CompositeGObject() {
		super(0, 0, 0, 0);
		gObjects = new ArrayList<GObject>();
	}

	public void add(GObject gObject) {
		gObjects.add(gObject);
	}

	public void remove(GObject gObject) {
		gObjects.remove(gObject);
	}

	@Override
	public void move(int dX, int dY) {
		this.x += dX;
		this.y += dY;
		for(GObject gObject:gObjects){
			gObject.move(dX,dY);
		}
	}
	
	public void recalculateRegion() {
		GObject lastPointGObject = gObjects.get(0);
		int minX = lastPointGObject.x;
		int minY = lastPointGObject.y;
		int maxX = lastPointGObject.x + lastPointGObject.width;
		int maxY = lastPointGObject.y + lastPointGObject.height;

		for(GObject gObject:gObjects){
			if(minX > gObject.x) {
				minX = gObject.x;
			}
			if(maxX < gObject.x + gObject.width){
				maxX = gObject.x + gObject.width;
			}
			if(minY > gObject.y){
				minY = gObject.y;
			}
			if(maxY < gObject.y + gObject.height){
				maxY = gObject.y + gObject.height;
			}
		}
		this.x = minX;
		this.y = minY;
		this.width = maxX - minX;
		this.height = maxY - minY;
	}

	@Override
	public void paintObject(Graphics g) {
		for(GObject gObject:gObjects){
			gObject.paintObject(g);
		}
	}

	@Override
	public void paintLabel(Graphics g) {
		for(GObject gObject:gObjects){
			g.drawString("Group",x,y+70);
		}
	}
	
}
