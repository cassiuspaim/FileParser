package parser;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import parser.common.exception.ContainerRecordParserException;

public class ListItemsParserEmptyLineTest {
	
	private static ListItemsParser lip;
	private static String line;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		line = "";
	}

	@Before
	public void setUp() {
		lip = new ListItemsParser();
	}
	
	@Test
	public void testAccept() {
		assertFalse(lip.accept(line));
	}
	
	@Test(expected = ContainerRecordParserException.class)
	public void testGet() throws ContainerRecordParserException {
		lip.accept(line);
		lip.get();
	}
}
