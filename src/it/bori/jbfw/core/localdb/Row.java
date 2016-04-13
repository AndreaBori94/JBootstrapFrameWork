package it.bori.jbfw.core.localdb;

import java.util.ArrayList;
import java.util.List;

public class Row
{

	private List<Object> content;

	public Row(int length)
	{
		content = new ArrayList<Object>();
		for (int i = 0; i < length; i++)
		{
			content.add(new Object());
		}
	}

}
