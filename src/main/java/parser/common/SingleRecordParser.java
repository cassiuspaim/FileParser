package parser.common;

import java.util.regex.PatternSyntaxException;

import parser.common.exception.ContainerRecordParserException;

public abstract class SingleRecordParser<T> extends RecordParser<T> {

	private static int INDEX_IDENTIFIER_RECORD = 0;

	/**
	 * Check if the single record is acceptable.
	 * 
	 * @param identifierTypeRecord
	 * @return boolean
	 */
	@Override
	public boolean accept(String line) {

		isAcceptable = false;

		try {
			tokens = line.split(getValueSeparator());
			if (validateIdentificator() && hasCorrectNumberOfTokens()) {
				isAcceptable = true;
			}

		} catch (PatternSyntaxException e) {
			isAcceptable = false;

		}
		return isAcceptable;

	}

	/**
	 * Check if the line has the record identifier
	 * 
	 * @return
	 */
	protected boolean hasIdentifier() {
		return true;
	}

	private final boolean validateIdentificator() {
		boolean valid = false;
		if (hasIdentifier()) {
			valid = getIdentifierRecord()
					.equals(tokens[SingleRecordParser.INDEX_IDENTIFIER_RECORD]);
		} else {
			valid = true;
		}
		return valid;
	}

	/**
	 * Check if the token has the needed identifier and the number of tokens is
	 * right
	 * 
	 * @return boolean
	 */
	protected boolean hasCorrectNumberOfTokens() {
		return getNumberOfTokens() == tokens.length;
	}

	protected abstract String getIdentifierRecord();

	protected abstract void validateTokens()
			throws ContainerRecordParserException;

}
