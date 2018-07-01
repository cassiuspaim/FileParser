package reader;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import output.OutputData;

public class FileReaderTest {

	public static File tempFile;

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	public void testOutputData() throws IOException {
		tempFile = tempFolder.newFile("tempFile.txt");
		List<String> linhas = new ArrayList<String>();
		linhas.add("001Á1234567891234ÁPedroÁ50000");
		linhas.add("001Á3245678865434ÁPauloÁ40000.99");
		linhas.add("002Á2345675434544345ÁJose da SilvaÁRural");
		linhas.add("002Á2345675433444345ÁEduardo PereiraÁRural");
		linhas.add("003Á10Á[1-10-100,2-30-2.50,3-40-3.10]ÁPedro");
		linhas.add("003Á08Á[1-34-10,2-33-1.50,3-40-0.10]ÁPaulo");
		FileUtils.writeLines(tempFile, "UTF-8", linhas);
		OutputData outputData = FileReader.readFile(tempFile);
		OutputData outputDataExpected = new OutputData("tempFile.txt", 2, 2, "10", "Paulo");
		assertEquals(outputData, outputDataExpected);
	}
	
	@Test
	public void testOutputData2() throws IOException {
		tempFile = tempFolder.newFile("tempFile.txt");
		List<String> linhas = new ArrayList<String>();
		linhas.add("001Á1234567891234ÁPedroÁ50000");
		linhas.add("001Á3245678865434ÁPauloÁ40000.99");
		linhas.add("002Á2345675434544345ÁJose da SilvaÁRural");
		linhas.add("002Á2345675433444345ÁEduardo PereiraÁRural");
		linhas.add("003Á10Á[1-10-100,2-30-2.50,3-40-3.10]ÁPedro");
		linhas.add("003Á08Á[1-34-10,2-33-1.50,3-40-0.10]ÁPaulo");
		linhas.add("003Á09Á[1-34-0.10,2-1-0.10,3-1-0.10]ÁPaulo");
		FileUtils.writeLines(tempFile, "UTF-8", linhas);
		OutputData outputData = FileReader.readFile(tempFile);
		OutputData outputDataExpected = new OutputData("tempFile.txt", 2, 2, "10", "Paulo");
		assertEquals(outputData, outputDataExpected);
	}
	
	@Test
	public void testOutputData3() throws IOException {
		tempFile = tempFolder.newFile("tempFile.txt");
		List<String> linhas = new ArrayList<String>();
		linhas.add("001Á1234567891234ÁPedroÁ50000");
		linhas.add("001Á3245678865434ÁPauloÁ40000.99");
		linhas.add("002Á2345675434544345ÁJose da SilvaÁRural");
		linhas.add("002Á2345675433444345ÁEduardo PereiraÁRural");
		linhas.add("003Á10Á[1-10-100,2-30-2.50,3-40-3.10]ÁPedro");
		linhas.add("003Á11Á[1-34-1000,2-33-1.50,3-40-0.10]ÁPaulo");
		linhas.add("003Á09Á[1-34-0.10,2-1-0.10,3-1-0.10]ÁPaulo");
		FileUtils.writeLines(tempFile, "UTF-8", linhas);
		OutputData outputData = FileReader.readFile(tempFile);
		OutputData outputDataExpected = new OutputData("tempFile.txt", 2, 2, "11", "Pedro");
		assertEquals(outputData, outputDataExpected);
	}
	
	@Test
	public void testOutputData4() throws IOException {
		tempFile = tempFolder.newFile("tempFile.txt");
		List<String> linhas = new ArrayList<String>();
		linhas.add("001Á1234567891234ÁPedroÁ50000");
		linhas.add("001Á3245678865434ÁPauloÁ40000.99");
		linhas.add("001Á888888229ÁRonaldoÁ10000");
		linhas.add("002Á2345675434544345ÁJose da SilvaÁRural");
		linhas.add("002Á2345675433444345ÁEduardo PereiraÁRural");
		linhas.add("003Á10Á[1-10-100,2-30-2.50,3-40-3.10]ÁPedro");
		linhas.add("003Á11Á[1-34-1000,2-33-1.50,3-40-0.10]ÁPaulo");
		linhas.add("003Á09Á[1-34-0.10,2-1-0.10,3-1-0.10]ÁPaulo");
		FileUtils.writeLines(tempFile, "UTF-8", linhas);
		OutputData outputData = FileReader.readFile(tempFile);
		OutputData outputDataExpected = new OutputData("tempFile.txt", 3, 2, "11", "Pedro");
		assertEquals(outputData, outputDataExpected);
	}
	
	@Test
	public void testOutputData5() throws IOException {
		tempFile = tempFolder.newFile("tempFile.txt");
		List<String> linhas = new ArrayList<String>();
		linhas.add("001Á1234567891234ÁPedroÁ50000");
		linhas.add("001Á3245678865434ÁPauloÁ40000.99");
		linhas.add("001Á888888229ÁRonaldoÁ10000");
		linhas.add("002Á2345675433444345ÁEduardo PereiraÁRural");
		linhas.add("003Á10Á[1-10-100,2-30-2.50,3-40-3.10]ÁPedro");
		linhas.add("003Á11Á[1-34-1000,2-33-1.50,3-40-0.10]ÁPaulo");
		linhas.add("003Á09Á[1-34-0.10,2-1-0.10,3-1-0.10]ÁPaulo");
		FileUtils.writeLines(tempFile, "UTF-8", linhas);
		OutputData outputData = FileReader.readFile(tempFile);
		OutputData outputDataExpected = new OutputData("tempFile.txt", 3, 1, "11", "Pedro");
		assertEquals(outputData, outputDataExpected);
	}

}
