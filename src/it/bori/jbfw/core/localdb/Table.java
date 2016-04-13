package it.bori.jbfw.core.localdb;

import it.bori.jbfw.core.exception.LocalDatabaseRangeException;
import java.util.List;

public class Table
{

	private List<Column> header;
	private List<Row> rows;

	public List<Row> getRows() {
		return this.rows;
	}
	
	public Row getRow(int index) {
		if (getRows().size() > index || getRows().size() < index) {
			
		}
	}

	public void addHeader(Column c) {
		getHeaders().add(c);
	}

	public boolean hasHeader(Column c) {
		for (int i = 0; i < getHeaders().size(); i++)
		{
			if (c.getName().equals(getHeaders().get(i)))
				return true;
		}
		return false;

	}

	public void setHeader(Column toadd, int index)
			throws LocalDatabaseRangeException {
		if (getHeaders().size() > index || getHeaders().size() < index)
			throw new LocalDatabaseRangeException(0, getHeaders().size(), index);
		getHeaders().set(index, toadd);
	}

	public Column getHeader(int index) throws LocalDatabaseRangeException {
		if (getHeaders().size() > index || getHeaders().size() < index)
		{
			throw new LocalDatabaseRangeException(0, getHeaders().size(), index);
		}
		else
			return getHeaders().get(index);
	}

	public List<Column> getHeaders() {
		return this.header;
	}

}
