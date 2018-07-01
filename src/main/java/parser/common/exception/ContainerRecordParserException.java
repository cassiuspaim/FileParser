package parser.common.exception;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class ContainerRecordParserException extends Exception {

	private List<RecordParserException> exceptions = new ArrayList<RecordParserException>();
	private String tokens[];

	public ContainerRecordParserException(String message, String[] tokens,
			List<RecordParserException> exceptions) {
		super(message);
		this.tokens = tokens;
		this.exceptions = exceptions;
	}

	public List<RecordParserException> getExceptions() {
		return exceptions;
	}

	public String[] getTokens() {
		return tokens;
	}
}
