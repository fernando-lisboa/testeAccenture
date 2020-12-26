package br.com.desafio.qa.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVUtil {

	public List<String> leCSV() throws FileNotFoundException, IOException, CsvException {

		String targetLocation = Paths.get("target").toAbsolutePath().toString();
		String fileLocation = targetLocation + File.separator +"download";
		
		Date date = Calendar.getInstance().getTime();

		DateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");

		String hoje = formatter.format(date);

		String extratoCSV = "Extrato_Alelo_" + hoje + ".csv";
		
		List<String> records = new ArrayList<String>();

		Charset inputCharset = Charset.forName("ISO-8859-1");

		try (CSVReader csvReader = new CSVReader(new InputStreamReader(
				new FileInputStream(fileLocation + File.separator + extratoCSV), inputCharset));) {

			List<String[]> values = csvReader.readAll();

			for (String[] value : values) {

				records.add(Arrays.toString(value));
			}
		}

		return records;
	}
	
	public void limpaDiretorioDownload() throws IOException {
		
		String targetLocation = Paths.get("target").toAbsolutePath().toString();
		String fileLocation = targetLocation + File.separator +"download" + File.separator;
		
		File directory = new File(fileLocation);
		
	    if (! directory.exists()){
	        directory.mkdir();
	    }else {
	    	FileUtils.cleanDirectory(directory); 
	    }
	}

}
