package it.bori.jbfw.core.localdb;

public class Test
{

	public static void main(String[] args) {
		Table t = new Table(new String[] { "col1", "col2" });
		t.addRow();

		t.setElement("col1", 0, "valore1");
		t.setElement("col2", 0, "valore2");
		
		t.debug();
	}

}
