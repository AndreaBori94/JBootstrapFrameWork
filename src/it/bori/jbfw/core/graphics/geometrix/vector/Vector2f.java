package it.bori.jbfw.core.graphics.geometrix.vector;

import java.io.Serializable;

/**
 * Basic Vector2 of any kind of primitive type, data or object
 * 
 * @author Andrea Bori
 */
public class Vector2f implements Serializable
{

	/**
	 * serialVersionUID used for serialize
	 */
	private static final long serialVersionUID = 6831432151348818709L;
	/**
	 * The x Value
	 */
	private float x;
	/**
	 * The y Value
	 */
	private float y;

	/**
	 * Constructor of the class, need to specify 2 variable: x and y
	 * 
	 * @param x
	 *            variable x
	 * @param y
	 *            variable y
	 */
	public Vector2f(float x, float y)
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
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Define the Y
	 * 
	 * @param y
	 *            variable Y
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Retrieve the X
	 * 
	 * @return the variable X
	 */
	public float getX() {
		return this.x;
	}

	/**
	 * Retrieve the Y
	 * 
	 * @return the variable Y
	 */
	public float getY() {
		return this.y;
	}

}
