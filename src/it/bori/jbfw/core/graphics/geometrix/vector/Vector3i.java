package it.bori.jbfw.core.graphics.geometrix.vector;

import java.io.Serializable;

/**
 * Basic Vector3 of any kind of primitive type, data or object
 * 
 * @author Andrea Bori
 */
public class Vector3i implements Serializable
{

	/**
	 * serialVersionUID used for serialize
	 */
	private static final long	serialVersionUID	= 2653726109321165970L;
	/**
	 * The x Value
	 */
	private int					x;
	/**
	 * The y Value
	 */
	private int					y;
	/**
	 * The z Value
	 */
	private int					z;

	/**
	 * Constructor of the class, need to specify 3 variable: x, y and z
	 * 
	 * @param x
	 *            variable x
	 * @param y
	 *            variable y
	 * @param z
	 *            variable z
	 */
	public Vector3i(int x, int y, int z)
	{
		setX(x);
		setY(y);
		setZ(z);
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
	 * Define the Z
	 * 
	 * @param z
	 *            variable Z
	 */
	public void setZ(int z) {
		this.z = z;
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

	/**
	 * Retrieve the Z
	 * 
	 * @return the variable Z
	 */
	public int getZ() {
		return this.z;
	}

}
