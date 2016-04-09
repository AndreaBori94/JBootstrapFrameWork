package it.bori.jbfw.core.graphics.geometrix.vector;

import java.io.Serializable;

/**
 * Basic Vector4 of any kind of primitive type, data or object
 * 
 * @author Andrea Bori
 */
public class Vector4d implements Serializable
{

	/**
	 * serialVersionUID used for serialize
	 */
	private static final long	serialVersionUID	= 1453239367055696345L;
	/**
	 * The x Value
	 */
	private double				x;
	/**
	 * The y Value
	 */
	private double				y;
	/**
	 * The z Value
	 */
	private double				z;
	/**
	 * The a Value
	 */
	private double				a;

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
	public Vector4d(double x, double y, double z, double a)
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
	 * Define the A
	 * 
	 * @param a
	 *            variable a
	 */
	public void setA(double a) {
		this.a = a;
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

	/**
	 * Retrieve the A
	 * 
	 * @return the variable A
	 */
	public double getA() {
		return this.a;
	}

}
