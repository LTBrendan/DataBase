package tests;

import org.junit.*;
import static org.junit.Assert.*;
import static consoleMode.Delete.*;

public class DeleteTest {
	
	@Test()
	public void testDeleteAllValues () {
		
		String tableName = null;
		assertTrue (deleteAllValues (tableName) == null);
		tableName = "testTable";
		assertEquals (deleteAllValues (tableName), "DELETE FROM "+tableName);
		
	}
}