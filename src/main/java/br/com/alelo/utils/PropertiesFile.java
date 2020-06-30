package br.com.alelo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

public class PropertiesFile {

	private Properties prop = new Properties();
	private Properties propTemp = new Properties();
	private SimpleCacheManager cache = SimpleCacheManager.getInstance();
	private InputStream resource;
	private static File fileTemp = new File("temp.dat");

	public PropertiesFile() throws IOException {

		resource = new ClassPathResource("application.properties").getInputStream();

		prop.load(resource);

	}

	public String getValor(String key) {
		return this.prop.getProperty(key);
	}

	public void setValor(String key, String newValue) {

		try {
			loadProperties();
			if (this.propTemp.containsKey(key)) {
				String oldValue = getValor(key);
				this.propTemp.replace(key, oldValue, newValue);
			} else {
				this.propTemp.setProperty(key, newValue);
			}
			saveProperties();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeValor(String key) {
		this.prop.remove(key);
	}

	public boolean propExiste(String key) {
		return this.propTemp.containsKey(key);
	}

	public void configFile() {
		prop.forEach((k, v) -> System.out.println(k + " -> " + v));
		prop.forEach((k, v) -> cache.put((String) k, v));
	}

	public void saveProperties() throws IOException {
		FileOutputStream fr = new FileOutputStream(fileTemp);
		propTemp.store(fr, "Properties");
		fr.close();
		System.out.println("After saving properties: " + propTemp);
	}

	public void loadProperties() throws IOException {
		FileInputStream fi = new FileInputStream(fileTemp);
		propTemp.load(fi);
		fi.close();
		System.out.println("After Loading properties: " + propTemp);
	}

	public static void createTempFile() {
		try {
			fileTemp.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
