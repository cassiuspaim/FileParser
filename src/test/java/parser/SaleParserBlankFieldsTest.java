package parser;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import parser.common.exception.ContainerRecordParserException;

public class SaleParserBlankFieldsTest {

	private static SaleParser sp;
	private static String line;

	@BeforeClass
	public static void setUpBeforeClass() {
		line = "003ç ç ç ";
	}

	@Before
	public void setUp() {
		sp = new SaleParser();
	}

	@Test(expected=ContainerRecordParserException.class)
	public void testGet() throws ContainerRecordParserException {
		sp.accept(line);
		sp.get();
	}

	@Test
	public void testAccept() {
		assertTrue(sp.accept(line));
	}

}
