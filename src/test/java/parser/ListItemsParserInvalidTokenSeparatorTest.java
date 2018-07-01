package parser;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import parser.common.exception.ContainerRecordParserException;

public class ListItemsParserInvalidTokenSeparatorTest {

	private static ListItemsParser lip;
	private static String line;

	private static final String TOKEN_SEPARATOR = "&";
	private static final String INITIAL_CHARACTER = "[";
	private static final String FINAL_CHARACTER= "]";
	
	@BeforeClass
	public static void setUpBeforeClass() {
		line = INITIAL_CHARACTER 
				+ "1-10-100" + TOKEN_SEPARATOR 
				+ "2-30-2.50" + TOKEN_SEPARATOR
				+ "3-40-3.10" 
				+ FINAL_CHARACTER;
	}

	@Before
	public void setUp() {
		lip = new ListItemsParser();
	}
	
	@Test(expected=ContainerRecordParserException.class)
	public void testGet() throws ContainerRecordParserException {
		lip.accept(line);
		lip.get();
	}

}
