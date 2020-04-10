package br.com.alelo.qa.web.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.opencsv.exceptions.CsvValidationException;

public class PDFUtil {

	public List<String> lePDF() throws FileNotFoundException, IOException, CsvValidationException {

		String targetLocation = Paths.get("target").toAbsolutePath().toString();
		String fileLocation = targetLocation + File.separator + "download";

		Date date = Calendar.getInstance().getTime();

		DateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");

		String hoje = formatter.format(date);

		String extratoPDF = "Extrato_Alelo_" + hoje + ".pdf";

		List<String> dataLines = new ArrayList<>();

		PDDocument pdfFile = PDDocument.load(new File(fileLocation + File.separator + extratoPDF));

		if (!pdfFile.isEncrypted()) {
			PDFTextStripper stripper = new PDFTextStripper();

			String content = stripper.getText(pdfFile);

			String[] lines = content.split("\r\n|\r|\n");

			int count = 0;
			String linha = "";

			dataLines.add(lines[0]);

			for (int i = 0; i < lines.length; i++) {

				if (i != 0) {
					linha = linha + " " + lines[i];
				}

				if (count == 7) {
					dataLines.add(linha);
					count = 0;
					linha = "";
				}
				count++;
			}

		}

		pdfFile.close();
		
		return dataLines;
	}

	public void limpaDiretorioDownload() throws IOException {

		String targetLocation = Paths.get("target").toAbsolutePath().toString();
		String fileLocation = targetLocation + File.separator + "download" + File.separator;

		File directory = new File(fileLocation);

		if (!directory.exists()) {
			directory.mkdir();
		} else {
			FileUtils.cleanDirectory(directory);
		}
	}

}
