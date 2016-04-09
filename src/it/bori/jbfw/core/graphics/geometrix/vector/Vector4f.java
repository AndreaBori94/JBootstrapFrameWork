package it.bori.jbfw.core.graphics.geometrix.vector;

import java.io.Serializable;

/**
 * Basic Vector4 of any kind of primitive type, data or object
 * 
 * @author Andrea Bori
 */
public class Vector4f implements Serializable
{

	/**
	 * serialVersionUID used for serialize
	 */
	private static final long	serialVersionUID	= 1667912288184457619L;
	/**
	 * The x Value
	 */
	private float				x;
	/**
	 * The y Value
	 */
	private float				y;
	/**
	 * The z Value
	 */
	private float				z;
	/**
	 * The a Value
	 */
	private float				a;

	/**
	 * Constructor of the class, need to specify 3 variable: x, y and z
	 * 
	 * @param x
	 *            variable x
	 * @param y
	 *            variable y
	 * @param z
	 *            variable z
	 * @param a
	 *            variable a
	 */
	public Vector4f(float x, float y, float z, float a)
	{
		setX(x);
		setY(y);
		setZ(z);
		setA(a);
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
	 * Define the A
	 * 
	 * @param a
	 *            variable a
	 */
	public void setA(float a) {
		this.a = a;
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

	/**
	 * Retrieve the A
	 * 
	 * @return the variable A
	 */
	public float getA() {
		return this.a;
	}

}
