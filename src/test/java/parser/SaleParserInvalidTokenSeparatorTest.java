package parser;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import parser.common.exception.ContainerRecordParserException;

public class SaleParserInvalidTokenSeparatorTest {
	
	private static SaleParser sp;
	private static String line;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		line = "003#08#[1-34-10,2-33-1.50,3-40-0.10]#Paulo";
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
