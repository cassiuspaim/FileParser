package watcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import output.OutputWriter;
import reader.FileReader;

public class DirectoryWatcher {

	private static final String FILE_EXTENSION_WATCHED = ".dat";

	static final Logger logger = LogManager
			.getLogger(DirectoryWatcher.class.getName());

	WatchService watcher = null;

	private static final String DIRECTORY_PATH = System.getProperty("user.home")
			+ System.getProperty("file.separator") + "data"
			+ System.getProperty("file.separator") + "in"
			+ System.getProperty("file.separator");

	public void watch() throws InterruptedException {

		try {
			logger.info("Starting to watch directory " + DIRECTORY_PATH);
			watcher = FileSystems.getDefault().newWatchService();
			Path dir = Paths.get(DIRECTORY_PATH);
			logger.info(
					"Watching StandardWatchEventKinds.ENTRY_CREATE event on directory.");
			dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
			analyzeEvents();
		} catch (IOException e) {
			logger.fatal("Error on watching directory " + DIRECTORY_PATH, e);
		}
	}

	private void analyzeEvents() throws InterruptedException {
		while (true) {

			WatchKey watchKey = null;
			logger.info("Analysing events every 10 seconds.");
			watchKey = watcher.poll(10, TimeUnit.SECONDS);

			if (watchKey != null) {
				watchKey.pollEvents().stream().forEach(event -> {
					final Path fileName = (Path) event.context();
					logger.info("Watched file is " + fileName);
					if (fileName.toString().endsWith(FILE_EXTENSION_WATCHED)) {

						String filePath = DIRECTORY_PATH + fileName.toString();
						OutputWriter.renderOutput(
								FileReader.readFile(new File(filePath)));

					} else {
						logger.info("File " + fileName + " discarted.");
					}
				});

				watchKey.reset();
			}

		}
	}

}
