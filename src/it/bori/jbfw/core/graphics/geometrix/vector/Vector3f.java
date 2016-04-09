package it.bori.jbfw.core.graphics.geometrix.vector;

import java.io.Serializable;

/**
 * Basic Vector3 of any kind of primitive type, data or object
 * 
 * @author Andrea Bori
 */
public class Vector3f implements Serializable
{

	/**
	 * serialVersionUID used for serialize
	 */
	private static final long serialVersionUID = -2265487703769576291L;
	/**
	 * The x Value
	 */
	private float x;
	/**
	 * The y Value
	 */
	private float y;
	/**
	 * The z Value
	 */
	private float z;

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
	public Vector3f(float x, float y, float z)
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
	 * Define the Z
	 * 
	 * @param z
	 *            variable Z
	 */
	public void setZ(float z) {
		this.z = z;
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

	/**
	 * Retrieve the Z
	 * 
	 * @return the variable Z
	 */
	public float getZ() {
		return this.z;
	}

}
