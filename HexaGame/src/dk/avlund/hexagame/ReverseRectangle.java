package dk.avlund.hexagame;

import com.badlogic.gdx.math.Rectangle;

public class ReverseRectangle extends Rectangle {
	public ReverseRectangle(int x, int y, int width, int height, int worldHeight) {
		super.x = x;
		super.y = worldHeight - y;
		super.width = width;
		super.height = height;
	}
}
