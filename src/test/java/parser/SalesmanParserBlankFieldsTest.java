package parser;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import parser.common.exception.ContainerRecordParserException;

public class SalesmanParserBlankFieldsTest {

	private static SalesmanParser sp;
	private static String line;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		line = "001ç ç ç ";
	}

	@Before
	public void setUp() {
		sp = new SalesmanParser();
	}
	
	@Test
	public void testAccept() {
		assertTrue(sp.accept(line));
	}
	
	@Test(expected=ContainerRecordParserException.class)
	public void testGet() throws ContainerRecordParserException {
		sp.accept(line);
		sp.get();
	}

}