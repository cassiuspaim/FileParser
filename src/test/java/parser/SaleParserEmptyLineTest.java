package parser;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import parser.common.exception.ContainerRecordParserException;

public class SaleParserEmptyLineTest {

	private static SaleParser sp;
	private static String line;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		line = "";
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
		assertFalse(sp.accept(line));
	}
	
}
