package parser.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class ParserUtils {

	public static boolean isValidString(String value) {
		return !StringUtils.isBlank(value);
	}

	public static boolean isValidInteger(String value) {
		return NumberUtils.isParsable(value);
	}

	public static boolean isValidDouble(String value) {
		return NumberUtils.isParsable(value);
	}

}
