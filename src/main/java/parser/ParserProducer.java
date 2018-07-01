package parser;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import parser.common.RecordParser;

public class ParserProducer {

	@SuppressWarnings("rawtypes")
	private static List<RecordParser> parsers = Arrays.asList(
			new SalesmanParser(), new SaleParser(), new CustumerParser());

	@SuppressWarnings("unchecked")
	public static <T> Optional<RecordParser<T>> get(String line) {

		for (RecordParser<T> parser : parsers) {
			if (parser.accept(line)) {
				return Optional.of(parser);
			}
		}
		return Optional.empty();

	}

}
