package parser.common.exception;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class RecordParserException extends Exception {

	private String tokens[];
	private List<RecordParserException> exceptions = new ArrayList<RecordParserException>();
	private String line;

	public RecordParserException(String message, String line) {
		super(message);
		this.line = line;
	}

	public void addException(RecordParserException recordParserException) {
		exceptions.add(recordParserException);
	}

	public String[] getTokens() {
		return tokens;
	}

	public String getLine() {
		return line;
	}

}
