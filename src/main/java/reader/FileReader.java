package reader;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Customer;
import model.Sale;
import model.Salesman;
import output.OutputData;
import parser.ParserProducer;
import parser.common.RecordParser;
import parser.common.exception.ContainerRecordParserException;

public class FileReader {

	private static final String FILE_ENCODING_DEFAULT = "UTF-8";

	static final Logger logger = LogManager
			.getLogger(FileReader.class.getName());

	public final static OutputData readFile(File file) {

		String pathFile = file.getPath();
		logger.info("Reading file " + pathFile);

		long salesmanCount = 0, clientCount = 0;
		double totalSalePrice = 0, highestPrice = 0;
		String idMostExpensiveSale = "";

		Map<String, Double> mapSale = new HashMap<String, Double>();
		SortedSet<Map.Entry<String, Double>> sortedset = new TreeSet<Map.Entry<String, Double>>(
				new Comparator<Map.Entry<String, Double>>() {
					@Override
					public int compare(Map.Entry<String, Double> e1,
							Map.Entry<String, Double> e2) {
						return e1.getValue().compareTo(e2.getValue());
					}
				});

		try (LineIterator it = FileUtils.lineIterator(file,
				FileReader.FILE_ENCODING_DEFAULT)) {

			long lineNumber = 0;

			while (it.hasNext()) {

				final String line = it.nextLine();
				lineNumber++;

				Optional<RecordParser<Object>> suitableParser = ParserProducer
						.get(line);
				if (suitableParser.isPresent()) {

					RecordParser<Object> parser = suitableParser.get();
					logger.info(
							"Parser found is " + parser.getClass().getName());

					try {
						Object object = parser.get();
						if (object instanceof Salesman) {
							salesmanCount++;
						} else if (object instanceof Customer) {
							clientCount++;
						} else if (object instanceof Sale) {
							Sale sale = (Sale) object;
							totalSalePrice = sale.getTotalPrice();
							if (totalSalePrice > highestPrice) {
								highestPrice = totalSalePrice;
								idMostExpensiveSale = sale.getSaleId();
							}

							String salesmanName = sale.getSalesmanName();
							if (mapSale.containsKey(salesmanName)) {
								totalSalePrice = mapSale.get(salesmanName);
							}
							mapSale.put(salesmanName, totalSalePrice);

						} else {
							logger.warn(
									"Parser found but there is no action assigned to this parser. Line processed ["
											+ lineNumber + "] = " + line);
						}
					} catch (ContainerRecordParserException e) {
						logger.warn("Error parsing line [" + lineNumber + "] = "
								+ line, e);
					}
				} else {
					logger.warn(
							"Unable to find parser. Unidentified line format in line["
									+ lineNumber + "] = " + line);
				}

			}

			if (mapSale.size() > 0) {
				sortedset.addAll(mapSale.entrySet());
			}

		} catch (IOException e) {
			logger.fatal("Error reading file " + pathFile, e);
		}

		String worstSalesMan = "";
		if (sortedset.size() > 0) {
			Map.Entry<String, Double> firstEntry = sortedset.first();
			worstSalesMan = firstEntry.getKey();
		}

		return new OutputData(file.getName(), salesmanCount, clientCount,
				idMostExpensiveSale, worstSalesMan);
	}

}
