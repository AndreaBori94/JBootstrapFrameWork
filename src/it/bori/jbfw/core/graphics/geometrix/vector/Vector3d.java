package it.bori.jbfw.core.graphics.geometrix.vector;

import java.io.Serializable;

/**
 * Basic Vector3 of any kind of primitive type, data or object
 * 
 * @author Andrea Bori
 */
public class Vector3d implements Serializable
{

	/**
	 * serialVersionUID used for serialize
	 */
	private static final long serialVersionUID = 5116645385990768952L;
	/**
	 * The x Value
	 */
	private double x;
	/**
	 * The y Value
	 */
	private double y;
	/**
	 * The z Value
	 */
	private double z;

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
	public Vector3d(double x, double y, double z)
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
	 * Define the Z
	 * 
	 * @param z
	 *            variable Z
	 */
	public void setZ(double z) {
		this.z = z;
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

	/**
	 * Retrieve the Z
	 * 
	 * @return the variable Z
	 */
	public double getZ() {
		return this.z;
	}

}
