package br.com.alelo.integrations.vsts.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipController {
	
	private List<String> fileList = new ArrayList<>();
	 

	 public void compressDirectory(String dir, String zipFile) {
	        File directory = new File(dir);
	        getFileList(directory);

	        try (FileOutputStream fos = new FileOutputStream(zipFile);
	             ZipOutputStream zos = new ZipOutputStream(fos)) {

	            for (String filePath : fileList) {
	                System.out.println("Compressing: " + filePath);

	                // Creates a zip entry.
	                String name = filePath.substring(
	                    directory.getAbsolutePath().length() + 1,
	                    filePath.length());

	                ZipEntry zipEntry = new ZipEntry(name);
	                zos.putNextEntry(zipEntry);

	                // Read file content and write to zip output stream.
	                try (FileInputStream fis = new FileInputStream(filePath)) {
	                    byte[] buffer = new byte[1024];
	                    int length;
	                    while ((length = fis.read(buffer)) > 0) {
	                        zos.write(buffer, 0, length);
	                    }

	                    // Close the zip entry.
	                    zos.closeEntry();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Get files list from the directory recursive to the sub directory.
	     */
	    private void getFileList(File directory) {
	        File[] files = directory.listFiles();
	        if (files != null && files.length > 0) {
	            for (File file : files) {
	                if (file.isFile()) {
	                    fileList.add(file.getAbsolutePath());
	                } else {
	                    getFileList(file);
	                }
	            }
	        }

	    } 


}
