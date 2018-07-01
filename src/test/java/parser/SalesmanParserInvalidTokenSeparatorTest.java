package parser;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import parser.common.exception.ContainerRecordParserException;

public class SalesmanParserInvalidTokenSeparatorTest {

	private static SalesmanParser sp;
	private static String line;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		line = "001x2345675434544345xJosedaSilvax10000";
	}

	@Before
	public void setUp() {
		sp = new SalesmanParser();
	}
	
	@Test
	public void testAccept() {
		assertFalse(sp.accept(line));
	}
	
	@Test(expected=ContainerRecordParserException.class)
	public void testGet() throws ContainerRecordParserException {
		sp.accept(line);
		sp.get();
	}

}


