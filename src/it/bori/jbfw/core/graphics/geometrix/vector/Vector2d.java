package it.bori.jbfw.core.graphics.geometrix.vector;

import java.io.Serializable;

/**
 * Basic Vector2 of any kind of primitive type, data or object
 * 
 * @author Andrea Bori
 */
public class Vector2d implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7846703521982230525L;
	/**
	 * The x Value
	 */
	private double x;
	/**
	 * The y Value
	 */
	private double y;

	/**
	 * Constructor of the class, need to specify 2 variable: x and y
	 * 
	 * @param x
	 *            variable x
	 * @param y
	 *            variable y
	 */
	public Vector2d(double x, double y)
	{
		setX(x);
		setY(y);
	}

	/**
	 * Define the X
	 * 
	 * @param x
	 *            variable X
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Define the Y
	 * 
	 * @param y
	 *            variable Y
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Retrieve the X
	 * 
	 * @return the variable X
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * Retrieve the Y
	 * 
	 * @return the variable Y
	 */
	public double getY() {
		return this.y;
	}

}
