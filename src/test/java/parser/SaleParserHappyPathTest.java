package parser;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Item;
import model.Sale;
import parser.common.exception.ContainerRecordParserException;

public class SaleParserHappyPathTest {

	private static SaleParser sp;
	private static String line;

	@BeforeClass
	public static void setUpBeforeClass() {
		line = "003Á10Á[1-10-100,2-30-2.50,3-40-3.10]ÁPedro";
	}

	@Before
	public void setUp() {
		sp = new SaleParser();
	}

	@Test
	public void testGet() throws ContainerRecordParserException {
		if (sp.accept(line)) {
			Sale sale = sp.get();
			List<Item> items = new ArrayList<Item>();
			items.add(new Item("1", 10, 100));
			items.add(new Item("2", 30, 2.5));
			items.add(new Item("3", 40, 3.1));
			Sale saleExpected = new Sale("10", items, "Pedro");
			assertTrue(sale.equals(saleExpected));
		}
	}

	@Test
	public void testAccept() {
		assertTrue(sp.accept(line));
	}

}
