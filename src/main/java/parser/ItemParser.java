package parser;

import java.util.ArrayList;
import java.util.List;

import model.Item;
import parser.common.SingleRecordParser;
import parser.common.exception.ContainerRecordParserException;
import parser.common.exception.RecordParserException;
import parser.utils.ParserUtils;

public class ItemParser extends SingleRecordParser<Item> {

	private final static int INDEX_ITEM_ID = 0;
	private final static int INDEX_ITEM_QUANTITY = 1;
	private final static int INDEX_ITEM_PRICE = 2;

	private String itemId;
	private String itemQuantity;
	private String itemPrice;

	@Override
	protected String getValueSeparator() {
		return "-";
	}

	@Override
	protected String getIdentifierRecord() {
		return "";
	}

	@Override
	protected int getNumberOfTokens() {
		return 3;
	}

	@Override
	protected void validateTokens() throws ContainerRecordParserException {
		List<RecordParserException> exceptions = new ArrayList<RecordParserException>();

		itemId = tokens[INDEX_ITEM_ID];
		if (!ParserUtils.isValidString(itemId)) {
			exceptions
					.add(new RecordParserException("Invalid item id", itemId));
		}

		itemQuantity = tokens[INDEX_ITEM_QUANTITY];
		if (!ParserUtils.isValidInteger(itemQuantity)) {
			exceptions.add(new RecordParserException("Invalid item quantity",
					itemQuantity));
		}

		itemPrice = tokens[INDEX_ITEM_PRICE];
		if (!ParserUtils.isValidDouble(itemPrice)) {
			exceptions.add(
					new RecordParserException("Invalid item price", itemPrice));
		}

		if (exceptions.size() > 0) {
			throw new ContainerRecordParserException(
					"Invalid tokens found for sale item record", tokens,
					exceptions);
		}

	}

	@Override
	protected boolean hasIdentifier() {
		return false;
	}

	@Override
	public Item get() throws ContainerRecordParserException {
		if (!isAcceptable) {
			throw new ContainerRecordParserException("Unacceptable Record",
					tokens, null);
		}
		validateTokens();
		return new Item(itemId, Long.parseLong(itemQuantity),
				Double.parseDouble(itemPrice));
	}

}
