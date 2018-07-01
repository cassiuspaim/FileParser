package parser.common;

import parser.common.exception.ContainerRecordParserException;

interface RecordParserInterface<T> {

	/**
	 * Return if the line is valid.
	 * 
	 * @param line
	 * @return
	 */
	public abstract boolean accept(String line);

	/**
	 * Return the parsed Object
	 * 
	 * @return
	 * @throws ContainerRecordParserException
	 */
	public abstract T get() throws ContainerRecordParserException;

}
