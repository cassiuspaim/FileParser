package parser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import parser.common.exception.ContainerRecordParserException;

public class ItemParserInvalidTokenSeparatorTest {

	private static ItemParser ip;
	private static String line;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		line = "1x10x1000.10";
	}

	@Before
	public void setUp() {
		ip = new ItemParser();
	}
	
	@Test
	public void testAccept() {
		assertFalse(ip.accept(line));
	}
	
	@Test(expected=ContainerRecordParserException.class)
	public void testGet() throws ContainerRecordParserException {
		ip.accept(line);
		ip.get();
	}

}
