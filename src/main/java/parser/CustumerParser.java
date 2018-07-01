package parser;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import parser.common.SingleRecordParser;
import parser.common.exception.ContainerRecordParserException;
import parser.common.exception.RecordParserException;
import parser.utils.ParserUtils;

public class CustumerParser extends SingleRecordParser<Customer> {

	private final static int INDEX_CNPJ = 1;
	private final static int INDEX_NAME = 2;
	private final static int INDEX_BUSINESS_AREA = 3;

	private String cnpj;
	private String name;
	private String businessArea;

	@Override
	protected String getValueSeparator() {
		return "ç";
	}

	@Override
	protected String getIdentifierRecord() {
		return "002";
	}

	@Override
	protected int getNumberOfTokens() {
		return 4;
	}

	@Override
	protected void validateTokens() throws ContainerRecordParserException {

		List<RecordParserException> exceptions = new ArrayList<RecordParserException>();

		cnpj = tokens[INDEX_CNPJ];
		if (!ParserUtils.isValidString(cnpj)) {
			exceptions.add(new RecordParserException("Invalid CPNJ", cnpj));
		}

		name = tokens[INDEX_NAME];
		if (!ParserUtils.isValidString(name)) {
			exceptions.add(new RecordParserException("Invalid name", name));
		}

		businessArea = tokens[INDEX_BUSINESS_AREA];
		if (!ParserUtils.isValidString(businessArea)) {
			exceptions.add(new RecordParserException("Invalid business area",
					businessArea));
		}

		if (exceptions.size() > 0) {
			throw new ContainerRecordParserException(
					"Invalid tokens found for Customer record.", tokens,
					exceptions);
		}
	}

	@Override
	public Customer get() throws ContainerRecordParserException {
		if (!isAcceptable) {
			throw new ContainerRecordParserException("Unacceptable Record",
					tokens, null);
		}
		validateTokens();
		return new Customer(cnpj, name, businessArea);
	}

}
