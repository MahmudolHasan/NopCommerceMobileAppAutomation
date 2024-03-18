package utils;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class ConfigReader {
	private Properties properties;

	public ConfigReader(String configFilePath) {
		try {
			properties = new Properties();
			FileInputStream fileInputStream = new FileInputStream(configFilePath);
			properties.load(fileInputStream);
		} catch (Exception e) {
			System.out.println("Error in reading the config file!Check ConfigReader Script!");
			e.printStackTrace();
		}
	}
	
	public String readConfig(String parameter) {
		return properties.getProperty(parameter);
	}

}
