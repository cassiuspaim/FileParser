package parser;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Item;
import parser.common.exception.ContainerRecordParserException;

public class ListItemsParserHappyPathTest {

	private static ListItemsParser lip;
	private static String line;

	private static final String TOKEN_SEPARATOR = ",";
	private static final String INITIAL_CHARACTER = "[";
	private static final String FINAL_CHARACTER= "]";
	
	@BeforeClass
	public static void setUpBeforeClass() {
		line = INITIAL_CHARACTER 
				+ "1-10-100" + TOKEN_SEPARATOR 
				+ "2-30-2.50" + TOKEN_SEPARATOR
				+ "3-40-3.10" 
				+ FINAL_CHARACTER;
	}
	
	@Before
	public void setUp() {
		lip = new ListItemsParser();
	}

	@Test
	public void testGet() throws ContainerRecordParserException {
		if (lip.accept(line)) {
			List<Item> items = lip.get();
			List<Item> itemsExpected = new ArrayList<Item>();
			itemsExpected.add(new Item("1", 10, 100));
			itemsExpected.add(new Item("2", 30, 2.5));
			itemsExpected.add(new Item("3", 40, 3.1));
			assertTrue(items.equals(itemsExpected));
		}
	}
	
	@Test
	public void testAccept() {
		assertTrue(lip.accept(line));
	}

}
