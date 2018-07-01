package parser.common;

import java.util.regex.PatternSyntaxException;

public abstract class MultiRecordParser<T> extends RecordParser<T> {

	/**
	 * Check if the multi-record is acceptable.
	 * 
	 * @param identifierTypeRecord
	 * @return boolean
	 */
	@Override
	public boolean accept(String line) {

		isAcceptable = false;

		try {
			String firstCharacter = line.substring(0, 1);
			String lastCharacter = line.substring(line.length() - 1,
					line.length());

			if (firstCharacter.equals(getInitialCharacter())
					&& lastCharacter.equals(getFinalCharacter())) {
				tokens = line.substring(1, line.length() - 1)
						.split(getValueSeparator());
				isAcceptable = hasCorrectNumberOfTokens();
			}

		} catch (PatternSyntaxException | IndexOutOfBoundsException e) {
			isAcceptable = false;
		}

		return isAcceptable;

	}

	protected abstract String getInitialCharacter();

	protected abstract String getFinalCharacter();

	public boolean hasCorrectNumberOfTokens() {
		return getNumberOfTokens() > 0;
	}

}
