package it.bori.jbfw.core.graphics.geometrix.vector;

import java.io.Serializable;

/**
 * Basic Vector2 of any kind of primitive type, data or object
 * 
 * @author Andrea Bori
 */
public class Vector2s implements Serializable
{

	/**
	 * SerialVersioUID
	 */
	private static final long	serialVersionUID	= 1698004861456305734L;
	/**
	 * The x Value
	 */
	private String				x;
	/**
	 * The y Value
	 */
	private String				y;

	/**
	 * Constructor of the class, need to specify 2 variable: x and y
	 * 
	 * @param x
	 *            variable x
	 * @param y
	 *            variable y
	 */
	public Vector2s(String x, String y)
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
	public void setX(String x) {
		this.x = x;
	}

	/**
	 * Define the Y
	 * 
	 * @param y
	 *            variable Y
	 */
	public void setY(String y) {
		this.y = y;
	}

	/**
	 * Retrieve the X
	 * 
	 * @return the variable X
	 */
	public String getX() {
		return this.x;
	}

	/**
	 * Retrieve the Y
	 * 
	 * @return the variable Y
	 */
	public String getY() {
		return this.y;
	}

}
