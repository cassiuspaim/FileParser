package parser;

import java.util.ArrayList;
import java.util.List;

import model.Item;
import parser.common.MultiRecordParser;
import parser.common.exception.ContainerRecordParserException;
import parser.common.exception.RecordParserException;

public class ListItemsParser extends MultiRecordParser<List<Item>> {

	private ItemParser ip = new ItemParser();
	private List<Item> listItems = new ArrayList<Item>();

	@Override
	protected String getInitialCharacter() {
		return "[";
	}

	@Override
	protected String getFinalCharacter() {
		return "]";
	}

	@Override
	protected String getValueSeparator() {
		return ",";
	}

	@Override
	protected int getNumberOfTokens() {
		return tokens.length;
	}

	@Override
	protected void validateTokens() throws ContainerRecordParserException {

		List<RecordParserException> exceptions = new ArrayList<RecordParserException>();

		for (String token : tokens) {
			if (ip.accept(token)) {
				listItems.add(ip.get());
			} else {
				exceptions.add(
						new RecordParserException("Invalid sale item", token));
			}
		}

		if (exceptions.size() > 0) {
			throw new ContainerRecordParserException(
					"Invalid tokens found for list of items", tokens,
					exceptions);
		}
	}

	protected boolean hasIdentifier() {
		return false;
	}

	@Override
	public List<Item> get() throws ContainerRecordParserException {
		if (!isAcceptable) {
			throw new ContainerRecordParserException("Unacceptable Record",
					tokens, null);
		}
		validateTokens();
		return listItems;
	}

}
