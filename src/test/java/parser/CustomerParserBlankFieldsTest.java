package parser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import parser.common.exception.ContainerRecordParserException;

public class CustomerParserBlankFieldsTest {

	private static CustumerParser cp;
	private static String line;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		line = "002ç ç ç ";
	}

	@Before
	public void setUp() {
		cp = new CustumerParser();
	}
	
	@Test
	public void testAccept() {
		assertTrue(cp.accept(line));
	}
	
	@Test(expected=ContainerRecordParserException.class)
	public void testGet() throws ContainerRecordParserException {
		cp.accept(line);
		cp.get();
	}

}
