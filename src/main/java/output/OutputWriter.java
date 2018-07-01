package output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OutputWriter {

	static final Logger logger = LogManager
			.getLogger(OutputWriter.class.getName());

	private static final String FILE_EXTENSION = ".done.dat";
	private static final String OUTPUT_PATH = System.getProperty("user.home")
			+ System.getProperty("file.separator") + "data"
			+ System.getProperty("file.separator") + "out";

	public static void renderOutput(OutputData outputData) {
		String inputFile = outputData.getInputFile();
		String fileName = OUTPUT_PATH + System.getProperty("file.separator")
				+ inputFile.substring(0, inputFile.lastIndexOf("."))
				+ FILE_EXTENSION;

		renderOutput(outputData, fileName);
	}

	private static void renderOutput(OutputData outputData, String fileName) {

		logger.info("File path defined to output is " + fileName);

		Path path = Paths.get(fileName);
		path.toFile().getParentFile().mkdirs();

		logger.info("File " + path + " created to output.");
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {

			logger.info("Starting to write content in output.");
			writer.write(outputData.toString());
			logger.info("All content writen in output.");

		} catch (IOException e) {
			logger.error("Unable to create output file.", e);
		}

	}
}
