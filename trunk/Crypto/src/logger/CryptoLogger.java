package logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * La classe CryptoLogger. Permet l'instanciation unique
 * d'un logger.
 * 
 * @author MAXIME DUMON
 * @version 1.0 06/10/08
 * @since JDK 1.6
 */
public class CryptoLogger {

	/** L'instance du logger. */
	private static Logger instance;
	
	/** La variable initialize. */
	private static boolean initialize;
	
	/**
	 * Méthode getInstance. Retourne la seule instance du logger
	 * 
	 * @param className le nom de la classe
	 * 
	 * @return instance l'unique instance du logger
	 */
	public static Logger getInstance(String className) {
		if (!initialize) {
			
			File fileConfig;
			fileConfig = new File("./conf/logger.properties");
			Properties properties;
			properties = new Properties();
			FileInputStream fis;
			try {
				fis = new FileInputStream(fileConfig);
				properties.load(fis);
				fis.close();
			} catch (FileNotFoundException fnfex) {
				fnfex.printStackTrace();
			} catch (IOException ioex) {
				ioex.printStackTrace();
			}
			PropertyConfigurator.configure(properties);
			instance = Logger.getLogger(className);
		}
		if (!initialize) {
			instance.debug("CryptoLogger initialized (first access : " + !initialize + ") on " + new Date());
			initialize = true;
		}
		return instance;
	}
}
