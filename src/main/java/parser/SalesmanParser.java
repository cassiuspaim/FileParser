package parser;

import java.util.ArrayList;
import java.util.List;

import model.Salesman;
import parser.common.SingleRecordParser;
import parser.common.exception.ContainerRecordParserException;
import parser.common.exception.RecordParserException;
import parser.utils.ParserUtils;

public class SalesmanParser extends SingleRecordParser<Salesman> {

	private final static int INDEX_CPF = 1;
	private final static int INDEX_NAME = 2;
	private final static int INDEX_SALARY = 3;

	private String cpf;
	private String name;
	private String salary;

	protected String getValueSeparator() {
		return "ç";
	}

	@Override
	protected String getIdentifierRecord() {
		return "001";
	}

	protected int getNumberOfTokens() {
		return 4;
	}

	protected void validateTokens() throws ContainerRecordParserException {
		List<RecordParserException> exceptions = new ArrayList<RecordParserException>();

		cpf = tokens[INDEX_CPF];
		if (!ParserUtils.isValidString(cpf)) {
			exceptions.add(new RecordParserException("Invalid CPF", cpf));
		}

		name = tokens[INDEX_NAME];
		if (!ParserUtils.isValidString(name)) {
			exceptions.add(new RecordParserException("Invalid name", name));
		}

		salary = tokens[INDEX_SALARY];
		if (!ParserUtils.isValidDouble(salary)) {
			exceptions.add(new RecordParserException("Invalid salary", salary));
		}

		if (exceptions.size() > 0) {
			throw new ContainerRecordParserException(
					"Invalid tokens found for Salesman record.", tokens,
					exceptions);
		}

	}

	@Override
	public Salesman get() throws ContainerRecordParserException {
		if (!isAcceptable) {
			throw new ContainerRecordParserException("Unacceptable Record",
					tokens, null);
		}
		validateTokens();
		return new Salesman(cpf, name, Double.parseDouble(salary));
	}

}
