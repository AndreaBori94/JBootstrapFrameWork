package it.bori.jbfw.core.localdb;

import java.util.ArrayList;
import java.util.List;

public class Table
{

	/**
	 * ByDimensional List with the table content, it's [ROW x COL]
	 */
	private List<List<String>> content = new ArrayList<List<String>>();
	/**
	 * List with all the name of the column, the length MUST be always the same
	 * of content column
	 */
	private List<String> header = new ArrayList<String>();

	/**
	 * Default constructor, need to specify the table header
	 * 
	 * @param header
	 *            the table header
	 */
	public Table(String[] header)
	{
		for (int i = 0; i < header.length; i++)
		{
			getHeader().add(header[i]);
		}
	}

	/**
	 * Add a new header to the table, then iterate all table and add an empty
	 * column where "header" should be
	 * 
	 * @param position
	 *            the position where add the column, if less than 0 will be 0,
	 *            if more than header.length will be header.length
	 * @param header
	 *            the name of the new column
	 * @return integer representing the position inside the header array
	 */
	public int addHeader(int position, String header) {
		if (position > getHeader().size())
		{
			position = getHeader().size();
		}
		if (position < 0)
		{
			position = 0;
		}
		getHeader().add(position, header);
		for (int i = 0; i < getContent().size(); i++)
		{
			getContent().get(i).add(position, "");
		}
		return position;
	}

	/**
	 * Get the content of the table
	 * 
	 * @return the content of the table
	 */
	public List<List<String>> getContent() {
		return this.content;
	}

	/**
	 * Get the index position of the header by a given name
	 * 
	 * @param name
	 *            the given name where search
	 * @return integer with the header position, -1 if no record found
	 */
	public int getHeaderByName(String name) {
		return getHeader().indexOf(name);
	}

	/**
	 * Get the entire single row, by a given index
	 * 
	 * @param index
	 *            the index of the row
	 * @return Object representing the row
	 */
	public List<String> getRow(int index) {
		return this.content.get(index);
	}

	/**
	 * Get the entire header list
	 * 
	 * @return the entire header list
	 */
	public List<String> getHeader() {
		return this.header;
	}

	/**
	 * Add a new row inside the content
	 */
	public void addRow() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < getHeader().size(); i++)
		{
			list.add("");
		}
		getContent().add(list);
	}

	/**
	 * Set an element inside a specific row
	 * 
	 * @param header
	 *            used as parameter of {@link Table#getHeaderByName(String)} to
	 *            retrieve the column index
	 * @param row
	 *            the ID of the row
	 * @param element
	 *            the element to assign at specific given position
	 */
	public void setElement(String header, int row, String element) {
		int h = getHeaderByName(header);
		getRow(row).add(h, element);
	}

	public void debug() {
		for (int i = 0; i < getHeader().size(); i++)
		{
			System.out.print(getHeader().get(i) + "\t");
		}
		System.out.println();
		for (int i = 0; i < getHeader().size(); i++) {
			for (int j = 0; j < 8; j++)
			{
				System.out.print("#");
			}
		}
		System.out.println();
		for (int i = 0; i < getContent().size(); i++)
		{
			for (int j = 0; j < getContent().get(i).size(); j++)
			{
				System.out.print(getContent().get(i).get(j) + "\t");
			}
		}
	}
	
}