package parser;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import parser.common.exception.ContainerRecordParserException;

public class CustomerParserInvalidTokenSeparatorTest {

	private static CustumerParser cp;
	private static String line;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		line = "002x1234567891234xDiegox50000";
	}

	@Before
	public void setUp() {
		cp = new CustumerParser();
	}
	
	@Test
	public void testAccept() {
		assertFalse(cp.accept(line));
	}
	
	@Test(expected=ContainerRecordParserException.class)
	public void testGet() throws ContainerRecordParserException {
		cp.accept(line);
		cp.get();
	}

}


