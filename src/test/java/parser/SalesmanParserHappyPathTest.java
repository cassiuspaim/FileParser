package parser;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Salesman;
import parser.common.exception.ContainerRecordParserException;

public class SalesmanParserHappyPathTest {

	private static SalesmanParser sp;
	private static String line;

	private static final String RECORD_IDENTIFIER = "001";
	private static final String TOKEN_SEPARATOR = "ç";

	private static final String CPF = "2345675434544345";
	private static final String NAME = "JosedaSilva";
	private static final double SALARY = 10000;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		line = RECORD_IDENTIFIER + TOKEN_SEPARATOR + CPF + TOKEN_SEPARATOR + NAME
				+ TOKEN_SEPARATOR + SALARY;
	}

	@Before
	public void setUp() {
		sp = new SalesmanParser();
	}
	
	@Test
	public void testGet() throws ContainerRecordParserException {
		if (sp.accept(line)) {
			Salesman salesman = sp.get();
			Salesman salesmanExpected = new Salesman(CPF, NAME, SALARY);
			assertTrue(salesman.equals(salesmanExpected));
		}
	}
	
	@Test
	public void testAccept() {
		assertTrue(sp.accept(line));
	}

}
