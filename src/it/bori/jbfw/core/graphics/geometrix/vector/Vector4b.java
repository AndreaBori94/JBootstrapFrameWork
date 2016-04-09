package it.bori.jbfw.core.graphics.geometrix.vector;

import java.io.Serializable;

/**
 * Basic Vector3 of any kind of primitive type, data or object
 * 
 * @author Andrea Bori
 */
public class Vector4b implements Serializable {

	/**
	 * serialVersionUID used for serialize
	 */
	private static final long serialVersionUID = -2234492181240952472L;
	/**
	 * The x Value
	 */
	private byte x;
	/**
	 * The y Value
	 */
	private byte y;
	/**
	 * The z Value
	 */
	private byte z;
	/**
	 * The a Value
	 */
	private byte a;

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
	public Vector4b(byte x, byte y, byte z, byte a) {
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
	public void setX(byte x) {
		this.x = x;
	}

	/**
	 * Define the Y
	 * 
	 * @param y
	 *            variable Y
	 */
	public void setY(byte y) {
		this.y = y;
	}

	/**
	 * Define the Z
	 * 
	 * @param z
	 *            variable Z
	 */
	public void setZ(byte z) {
		this.z = z;
	}

	/**
	 * Define the A
	 * 
	 * @param a
	 *            variable a
	 */
	public void setA(byte a) {
		this.a = a;
	}

	/**
	 * Retrieve the X
	 * 
	 * @return the variable X
	 */
	public byte getX() {
		return this.x;
	}

	/**
	 * Retrieve the Y
	 * 
	 * @return the variable Y
	 */
	public byte getY() {
		return this.y;
	}

	/**
	 * Retrieve the Z
	 * 
	 * @return the variable Z
	 */
	public byte getZ() {
		return this.z;
	}

	/**
	 * Retrieve the A
	 * 
	 * @return the variable A
	 */
	public byte getA() {
		return this.a;
	}

}
