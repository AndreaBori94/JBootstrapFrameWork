package it.bori.jbfw.core.graphics.geometrix.vector;

import java.io.Serializable;

/**
 * Basic Vector4 of any kind of primitive type, data or object
 * 
 * @author Andrea Bori
 */
public class Vector4s implements Serializable
{

	/**
	 * serialVersionUID used for serialize
	 */
	private static final long serialVersionUID = -2234492181240952472L;
	/**
	 * The x Value
	 */
	private String x;
	/**
	 * The y Value
	 */
	private String y;
	/**
	 * The z Value
	 */
	private String z;
	/**
	 * The a Value
	 */
	private String a;

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
	public Vector4s(String x, String y, String z, String a)
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
	 * Define the Z
	 * 
	 * @param z
	 *            variable Z
	 */
	public void setZ(String z) {
		this.z = z;
	}

	/**
	 * Define the A
	 * 
	 * @param a
	 *            variable a
	 */
	public void setA(String a) {
		this.a = a;
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

	/**
	 * Retrieve the Z
	 * 
	 * @return the variable Z
	 */
	public String getZ() {
		return this.z;
	}

	/**
	 * Retrieve the A
	 * 
	 * @return the variable A
	 */
	public String getA() {
		return this.a;
	}

}
