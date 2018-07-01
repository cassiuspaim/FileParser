package parser;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Customer;
import parser.common.exception.ContainerRecordParserException;

public class CustomerParserHappyPathTest {

	private static CustumerParser cp;
	private static String line;

	private static final String RECORD_IDENTIFIER = "002";
	private static final String TOKEN_SEPARATOR = "ç";

	private static final String CNPJ = "2345675434544345";
	private static final String NAME = "JosedaSilva";
	private static final String BUSINESS_AREA = "Rural";

	@BeforeClass
	public static void setUpBeforeClass() {
		line = RECORD_IDENTIFIER + TOKEN_SEPARATOR + CNPJ + TOKEN_SEPARATOR + NAME
				+ TOKEN_SEPARATOR + BUSINESS_AREA;
	}

	@Before
	public void setUp() {
		cp = new CustumerParser();
	}

	@Test
	public void testGet() throws ContainerRecordParserException {
		if (cp.accept(line)) {
			Customer customer = cp.get();
			Customer customerExpected = new Customer(CNPJ, NAME, BUSINESS_AREA);
			assertTrue(customer.equals(customerExpected));
		}
	}

	@Test
	public void testAccept() {
		assertTrue(cp.accept(line));
	}

}
