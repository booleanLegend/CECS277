/**
* @Class Rectangle Class that represents characteristics of rectangle, used for grid and to display user's amount of rectangles
*/

public class Rectangle
{
	private int x;
	private int y;
	private int width;
	private int height;

	/**
	* Default constructor for rectangle setting all values to zero 
	*/
	public Rectangle() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}

	/**
	* Specific constructor that sets specific values for each data member
	*/ 
	public Rectangle(int newX, int newY, int newWidth, int newHeight) {
		x = newX;
		y = newY;
		width = newWidth;
		height = newHeight;
	}

	/**
	* getX returns the x coordinate of the rectangle
	* 
	* @return x coordinate of rectangle 
	*/ 
	public int getX() {
		return x;
	}
  
	/**
	* getY returns the Y coordinate of the rectangle
  	*
  	* @return Y coordinate of rectangle
	*/
	public int getY() {
		return y;
	}
  
	/**
	* getWidth returns the width of the rectangle
	*
	* @return Width of rectangle 
	*/
	public int getWidth() {
		return width;
	}

	/**
	* getHeight returns the height of the rectangle
	*
	* @return height of rectangle
	*/
	public double getHeight() {
		return height;
	}
}