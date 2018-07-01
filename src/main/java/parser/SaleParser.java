package parser;

import java.util.ArrayList;
import java.util.List;

import model.Sale;
import parser.common.SingleRecordParser;
import parser.common.exception.ContainerRecordParserException;
import parser.common.exception.RecordParserException;
import parser.utils.ParserUtils;

public class SaleParser extends SingleRecordParser<Sale> {

	private final static int INDEX_SALE_ID = 1;
	private final static int INDEX_ITEMS = 2;
	private final static int INDEX_SALESMAN_NAME = 3;

	private String saleId;
	private String saleItems;
	private String salesmanName;

	private ListItemsParser lip;

	@Override
	protected String getValueSeparator() {
		return "ç";
	}

	@Override
	protected String getIdentifierRecord() {
		return "003";
	}

	@Override
	protected int getNumberOfTokens() {
		return 4;
	}

	@Override
	protected void validateTokens() throws ContainerRecordParserException {
		List<RecordParserException> exceptions = new ArrayList<RecordParserException>();

		saleId = tokens[INDEX_SALE_ID];
		if (!ParserUtils.isValidString(saleId)) {
			exceptions
					.add(new RecordParserException("Invalid sale id", saleId));
		}

		saleItems = tokens[INDEX_ITEMS];
		if (!ParserUtils.isValidString(saleItems)) {
			exceptions.add(
					new RecordParserException("Invalid sale items", saleItems));
		} else {
			lip = new ListItemsParser();
			if (!lip.accept(saleItems)) {
				exceptions.add(new RecordParserException(
						"Impossible to parse sale items", saleItems));
			}
		}
		salesmanName = tokens[INDEX_SALESMAN_NAME];
		if (!ParserUtils.isValidString(salesmanName)) {
			exceptions.add(new RecordParserException("Invalid salesman name",
					salesmanName));
		}

		if (exceptions.size() > 0) {
			throw new ContainerRecordParserException(
					"Invalid tokens found for Sales record.", tokens,
					exceptions);
		}

	}

	@Override
	public Sale get() throws ContainerRecordParserException {
		if (!isAcceptable) {
			throw new ContainerRecordParserException("Unacceptable Record",
					tokens, null);
		}
		validateTokens();
		return new Sale(saleId, lip.get(), salesmanName);
	}

}
