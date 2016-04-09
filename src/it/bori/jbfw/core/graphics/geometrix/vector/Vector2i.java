package it.bori.jbfw.core.graphics.geometrix.vector;

import java.io.Serializable;

/**
 * Basic Vector2 of any kind of primitive type, data or object
 * 
 * @author Andrea Bori
 */
public class Vector2i implements Serializable
{

	/**
	 * serialVersionUID used for serialize
	 */
	private static final long serialVersionUID = -3792719471593135163L;
	/**
	 * The x Value
	 */
	private int x;
	/**
	 * The y Value
	 */
	private int y;

	/**
	 * Constructor of the class, need to specify 2 variable: x and y
	 * 
	 * @param x
	 *            variable x
	 * @param y
	 *            variable y
	 */
	public Vector2i(int x, int y)
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
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Define the Y
	 * 
	 * @param y
	 *            variable Y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Retrieve the X
	 * 
	 * @return the variable X
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Retrieve the Y
	 * 
	 * @return the variable Y
	 */
	public int getY() {
		return this.y;
	}

}
