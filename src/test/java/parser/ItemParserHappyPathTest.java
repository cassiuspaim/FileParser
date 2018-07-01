package parser;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Item;
import parser.common.exception.ContainerRecordParserException;

public class ItemParserHappyPathTest {
	
	private static ItemParser ip;
	private static String line;

	private static final String TOKEN_SEPARATOR = "-";

	private static final String ITEM_ID = "1";
	private static final long ITEM_QUANTITY = 10L;
	private static final double ITEM_PRICE = 1000.10;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		line = ITEM_ID + TOKEN_SEPARATOR + ITEM_QUANTITY
				+ TOKEN_SEPARATOR + ITEM_PRICE;
	}
	
	@Before
	public void setUp() {
		ip = new ItemParser();
	}
	
	@Test
	public void testGet() throws ContainerRecordParserException {
		if (ip.accept(line)) {
			Item item = ip.get();
			Item itemExpected = new Item(ITEM_ID, ITEM_QUANTITY, ITEM_PRICE);
			assertTrue(item.equals(itemExpected));
		}
	}

	@Test
	public void testAccept() {
		assertTrue(ip.accept(line));
	}

}
