package it.bori.jbfw.core.localdb;

import it.bori.jbfw.core.debug.logger.Logger;
import it.bori.jbfw.core.exception.LocalDatabaseFieldRangeException;
import it.bori.jbfw.core.exception.LocalDatabaseNamingException;
import it.bori.jbfw.core.graphics.geometrix.vector.Vector2i;

/**
 * Column object, contains basic information for building a simply Table for
 * local database
 * 
 * @author Andrea Bori
 *
 */
public class Column
{

	/**
	 * Name of column
	 */
	private String name;
	/**
	 * Unique ID
	 */
	private int uid;
	/**
	 * Class define the type of column, can be for example Boolean.class
	 */
	private Class<?> type;

	/**
	 * Contains the size of the single value. The X means the minimum required,
	 * the Y it's the maximum allowed
	 */
	private Vector2i dimension;

	/**
	 * Default constructor, set name, uid, type and range min, max
	 * 
	 * @param name
	 *            Name of column ( must be unique, no other column inside same
	 *            table can have the same )
	 * @param uid
	 *            UID of the column ( must be unique, no other column inside
	 *            other table can have the same )
	 * @param type
	 *            Type of column, use for example Boolean.class if wan't this
	 *            column contains Boolean object
	 * @param min
	 *            the minimum value required for the field
	 * @param max
	 *            the maximum value allowed for the field
	 * @throws LocalDatabaseNamingException
	 *             Throw when the name it's less than 0, if it's more than 128
	 *             it will "strip" from 0 to 128
	 * @throws LocalDatabaseFieldRangeException
	 *             Throw when the minimum length exceed the maximum given value.
	 */
	public Column(String name, int uid, Class<?> type, int min, int max)
			throws LocalDatabaseNamingException,
			LocalDatabaseFieldRangeException
	{
		setName(name);
		setUID(uid);
		setType(type);
		setRange(min, max);
		Logger.log("Initializing Column with " + name + "," + uid + "," + type
				+ "," + min + "," + max);
	}

	/**
	 * Less specific constructor, only accept name, uid and column type, the
	 * range will be setted as default 0 and 500
	 * 
	 * @param name
	 *            Name of column ( must be unique, no other column inside same
	 *            table can have the same )
	 * @param uid
	 *            UID of the column ( must be unique, no other column inside
	 *            other table can have the same )
	 * @param type
	 *            Type of column, use for example Boolean.class if wan't this
	 *            column contains Boolean object the maximum value allowed for
	 *            the field
	 * @throws LocalDatabaseNamingException
	 *             Throw when the name it's less than 0, if it's more than 128
	 *             it will "strip" from 0 to 128
	 */
	public Column(String name, int uid, Class<?> type)
			throws LocalDatabaseNamingException
	{
		setName(name);
		setUID(uid);
		setType(type);

		try
		{
			setRange(0, 500);
		}
		catch (LocalDatabaseFieldRangeException e)
		{
		}
		Logger.log("Initializing Column with " + name + "," + uid + "," + type
				+ "," + 0 + "," + 500);
	}

	/**
	 * Basic constructor, only accept name, uid and define Object.class as
	 * default type and set the range by default of 0 to 500
	 * 
	 * @param name
	 *            Name of column ( must be unique, no other column inside same
	 *            table can have the same )
	 * @param uid
	 *            UID of the column ( must be unique, no other column inside
	 *            other table can have the same )
	 * @throws LocalDatabaseNamingException
	 *             Throw when the name it's less than 0, if it's more than 128
	 *             it will "strip" from 0 to 128
	 */
	public Column(String name, int uid) throws LocalDatabaseNamingException
	{
		setName(name);
		setUID(uid);
		setType(Object.class);
		try
		{
			setRange(0, 500);
		}
		catch (LocalDatabaseFieldRangeException e)
		{
		}
		Logger.log("Initializing Column with " + name + "," + uid + ","
				+ Object.class + "," + 0 + "," + 500);
	}

	/**
	 * Set the range allowed for this field, must be more than less and less
	 * than maximum
	 * 
	 * @param min
	 *            Minimum value required
	 * @param max
	 *            Maximum value allowed
	 * @throws LocalDatabaseFieldRangeException
	 *             Throw when the minimum length exceed the maximum given value
	 */
	public void setRange(int min, int max)
			throws LocalDatabaseFieldRangeException {
		if (min < max)
		{
			this.dimension = new Vector2i(min, max);
		}
		else
			throw new LocalDatabaseFieldRangeException(min, max);
	}

	/**
	 * Set the range object {@link Vector2i} allowed for this field, must have X
	 * more than Y
	 * 
	 * @param range
	 *            the object {@link Vector2i} with range value
	 * @throws LocalDatabaseFieldRangeException
	 *             Throw when the minimum length exceed the maximum given value
	 */
	public void setRange(Vector2i range)
			throws LocalDatabaseFieldRangeException {
		if (range.getX() < range.getY())
		{
			this.dimension = range;
		}
		else
			throw new LocalDatabaseFieldRangeException(range.getX(),
					range.getY());
	}

	/**
	 * Get the Vector containing the range, X it's the mimimum value, Y it's the
	 * maximum Value
	 * 
	 * @return Vector2i object with value X=less and Y=max
	 */
	public Vector2i getRange() {
		return this.dimension;
	}

	/**
	 * Get the minimum value calling {@link Column#getRange()} that return
	 * {@link Vector2i} then call {@link Vector2i#getX()}
	 * 
	 * @return the Integer corresponding to the minimum value required
	 */
	public int getMin() {
		return getRange().getX();
	}

	/**
	 * Get the maximum value allowed by calling {@link Column#getRange()} that
	 * return {@link Vector2i} then call {@link Vector2i#getY()}
	 * 
	 * @return the Integer corresponding to the maximum value allowed
	 */
	public int getMax() {
		return getRange().getY();
	}

	/**
	 * Set the name of the column, if length it's less than 0 it will thrown a
	 * {@link LocalDatabaseNamingException} else if it's more than 128 it will
	 * strip from 0 to 128. The name of the column must be unique inside the
	 * table, no other column ( of the same table ) can have the same name
	 * 
	 * @param name
	 *            Name of the column
	 * @throws LocalDatabaseNamingException
	 *             throw when the name it's less than 0, if it's more than 128
	 *             it will "strop" from 0 to 128
	 */
	public void setName(String name) throws LocalDatabaseNamingException {
		if (name.length() > 1)
		{
			if (name.length() <= 128)
			{
				this.name = name;
			}
			else
				this.name = name.substring(0, 128);
		}
		else
			throw new LocalDatabaseNamingException(name.length());
	}

	/**
	 * Get the name of the column
	 * 
	 * @return the name of the column
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set unique ID, if it's a negative number, it will reset to 0. The ID must
	 * be unique for all column of all table, no other column of other table can
	 * have the same value
	 * 
	 * @param uid
	 *            unique ID of the column
	 */
	public void setUID(int uid) {
		if (uid < 0)
		{
			this.uid = 0;
			Logger.log(Logger.LEVEL_WARNING, "Column " + getName()
					+ " UID it's negative. settings 0 as default", false);
		}
		else
			this.uid = uid;
	}

	/**
	 * Get Unique ID of the column
	 * 
	 * @return the unique id of the column
	 */
	public int getUID() {
		return this.uid;
	}

	/**
	 * Set type of the column, if want the column to store Boolean value call
	 * this and set: Boolean.class as parameter
	 * 
	 * @param type
	 *            define what it's stored inside this column
	 */
	public void setType(Class<?> type) {
		this.type = type;
	}

	/**
	 * Get the type of the column ( what this column store inside )
	 * 
	 * @return the type of the column
	 */
	public Class<?> getType() {
		return this.type;
	}

	/**
	 * Ask to the column, if the given value will be accepted, if false, means
	 * that the object that it's trying to insert in this column, it's not the
	 * same value obtained with {@link Column#getType()} and it's not accepted,
	 * if return true, means than ( for example ) the column it's Boolean and
	 * it's receiving true or false i.e: new
	 * Column(boolean.class).isAccepted(boolean.class);
	 * 
	 * @param object
	 *            the object that will trying to be inserted
	 * @return boolean true if the object it's accepted else false.
	 */
	public boolean isAccepted(Class<?> object) {
		return getType().equals(object);
	}
}
