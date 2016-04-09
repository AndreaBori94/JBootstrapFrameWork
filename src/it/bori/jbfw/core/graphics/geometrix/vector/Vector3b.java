package it.bori.jbfw.core.graphics.geometrix.vector;

import java.io.Serializable;

/**
 * Basic Vector3 of any kind of primitive type, data or object
 * 
 * @author Andrea Bori
 */
public class Vector3b implements Serializable {

	/**
	 * serialVersionUID used for serialize
	 */
	private static final long serialVersionUID = -4415199675754249202L;
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
	 * Constructor of the class, need to specify 3 variable: x, y and z
	 * 
	 * @param x
	 *            variable x
	 * @param y
	 *            variable y
	 * @param z
	 *            variable z
	 */
	public Vector3b(byte x, byte y, byte z) {
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

}
