package parser.common;

import parser.common.exception.ContainerRecordParserException;

public abstract class RecordParser<T> implements RecordParserInterface<T> {

	protected String tokens[] = null;
	protected boolean isAcceptable = false;

	/**
	 * Check if the token has the needed identifier and the number of tokens is
	 * right
	 * 
	 * @return boolean
	 */
	protected abstract boolean hasCorrectNumberOfTokens();

	/**
	 * Return the String separator for this record
	 * 
	 * @return String
	 */
	protected abstract String getValueSeparator();

	/**
	 * Return the exact number of tokens for this record
	 * 
	 * @return int
	 */
	protected abstract int getNumberOfTokens();

	/**
	 * Validate if the tokens are valid
	 * 
	 * @param tokens
	 * @throws ContainerRecordParserException
	 */
	protected abstract void validateTokens()
			throws ContainerRecordParserException;

}
