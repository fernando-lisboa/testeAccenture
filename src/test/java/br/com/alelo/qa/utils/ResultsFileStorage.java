package br.com.alelo.qa.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResultsFileStorage {

	static File file;
	static String fileName = "results.dat";

	public static void createTestResultsFile() throws IOException {
		
	
		
		file = new File(fileName);
		
		if (file.createNewFile())
		{
		    System.out.println("File is created!");
		} else {
		    System.out.println("File already exists.");
		}
		
		System.out.println(file.getAbsolutePath());
	}
	

	public static void saveResult(String result) {
		file = new File(fileName);
		try (FileWriter writer = new FileWriter(file, true);
				 BufferedWriter bw = new BufferedWriter(writer)) {
				bw.append(result);

			} catch (IOException e) {
				System.err.format("IOException: %s%n", e);
			}
	}
	
	public static void deleteFile() {
		file.delete();
	}

	

}
