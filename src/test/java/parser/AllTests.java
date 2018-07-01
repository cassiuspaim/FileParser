package parser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CustomerParserBlankFieldsTest.class,
		CustomerParserEmptyLineTest.class, CustomerParserHappyPathTest.class,
		CustomerParserInvalidTokenSeparatorTest.class,
		ItemParserBlankFieldsTest.class, ItemParserEmptyLineTest.class,
		ItemParserHappyPathTest.class,
		ItemParserInvalidTokenSeparatorTest.class,
		ListItemsParserBlankFieldsTest.class,
		ListItemsParserEmptyLineTest.class, ListItemsParserHappyPathTest.class,
		ListItemsParserInvalidTokenSeparatorTest.class,
		SaleParserBlankFieldsTest.class, SaleParserEmptyLineTest.class,
		SaleParserHappyPathTest.class,
		SaleParserInvalidTokenSeparatorTest.class,
		SalesmanParserBlankFieldsTest.class, SalesmanParserEmptyLineTest.class,
		SalesmanParserHappyPathTest.class,
		SalesmanParserInvalidTokenSeparatorTest.class })
public class AllTests {

}
