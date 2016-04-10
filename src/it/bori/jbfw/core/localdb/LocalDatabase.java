package it.bori.jbfw.core.localdb;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import it.bori.jbfw.core.debug.logger.Logger;

/**
 * A local database, useful for storing information in a local environment This
 * database take table inside RAM memory, if table it's not used, it's will
 * flush on HDD else it's will load inside the RAM
 * 
 * @author Andrea Bori
 *
 */
public class LocalDatabase
{

	private static Table table;

	private static boolean setTable(String tableName) {
		try
		{
			FileInputStream fis = new FileInputStream(tableName);
			ObjectInputStream reader = new ObjectInputStream(fis);
			LocalDatabase.table = (Table) reader.readObject();
			reader.close();
		}
		catch (Exception e)
		{
			Logger.log(e);
		}
		return false;
	}
}