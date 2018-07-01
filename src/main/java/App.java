import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import watcher.DirectoryWatcher;

public class App {

	static final Logger logger = LogManager.getLogger(App.class.getName());

	public static void main(String[] args) {
		try {
			logger.info("Starting the application.");
			DirectoryWatcher dw = new DirectoryWatcher();
			dw.watch();

		} catch (Exception e) {
			logger.error("Error running the application.", e);
		}
	}

}
