/**
class Point - The Point class allows points to be referenced and set, including when points that have to be moved
*/
public class Point {
	/**
	* X coordinate of point
	*/
	private int x;
	/**
	* Y coordinate of point
	*/
	private int y;
	/**
	* Constructor that passes in the x and y values of the coordinate to be set
	* @param initX - X value of coordinate
	* @param initY - Y value of coordinate
	*/
	public Point(int initX, int initY) {
		x = initX;
		y = initY;
	}
	/**
	* Method that gets the x coordinate of a point
	* @return An int
	*/
	public int getX() {
		return x;
	}
	/**
	* Method that gets the y coordinate of a point
	* @return An int
	*/
	public int getY() {
		return y;
	}
	/**
	* Method that allows points to be moved or translated by amount dictated by x and y parameters passed in
	* @param dx - amount that will be applied to x coordinate
	* @param dy - amount that will be applied to y coordinate
	*/
	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}
}