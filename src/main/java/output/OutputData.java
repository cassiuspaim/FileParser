package output;

import java.util.Locale;
import java.util.ResourceBundle;

public class OutputData {

	private String inputFile;

	private long salesmanCount;
	private long clientCount;
	private String idMostExpensiveSale;
	private String worstSalesman;

	public OutputData(String inputFile, long salesmanCount, long clientCount,
			String idMostExpensiveSale, String worstSalesman) {
		super();
		this.inputFile = inputFile;
		this.salesmanCount = salesmanCount;
		this.clientCount = clientCount;
		this.idMostExpensiveSale = idMostExpensiveSale;
		this.worstSalesman = worstSalesman;
	}

	public String getInputFile() {
		return inputFile;
	}

	@Override
	public String toString() {

		String lb = System.getProperty("line.separator");

		ResourceBundle bundle = ResourceBundle.getBundle("messages",
				new Locale("pt", "BR"));

		return bundle.getString("AMOUNT_OF_CLIENTS") + ": " + clientCount + lb
				+ bundle.getString("AMOUNT_OF_SALESMAN") + ": " + salesmanCount
				+ lb + bundle.getString("ID_MOST_EXPENSIVE_SALE") + ": "
				+ idMostExpensiveSale + lb + bundle.getString("WORST_SALESMEN")
				+ ": " + worstSalesman + lb;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OutputData other = (OutputData) obj;
		if (clientCount != other.clientCount)
			return false;
		if (idMostExpensiveSale == null) {
			if (other.idMostExpensiveSale != null)
				return false;
		} else if (!idMostExpensiveSale.equals(other.idMostExpensiveSale))
			return false;
		if (inputFile == null) {
			if (other.inputFile != null)
				return false;
		} else if (!inputFile.equals(other.inputFile))
			return false;
		if (salesmanCount != other.salesmanCount)
			return false;
		if (worstSalesman == null) {
			if (other.worstSalesman != null)
				return false;
		} else if (!worstSalesman.equals(other.worstSalesman))
			return false;
		return true;
	}

}
