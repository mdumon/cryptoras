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
 * The Class CryptoLogger. Permet l'instanciation unique
 * d'un logger.
 * 
 * @author MAXIME DUMON
 * @version 0.1 24/09/08
 * @since JDK 1.6
 */
public class CryptoLogger {

	/** L'instance du logger. */
	private static Logger instance;
	
	/** La variable initialize. */
	private static boolean initialize;
	
	/**
	 * Retourne la seule instance d'un CryptoLogger.
	 * 
	 * @param className le nom de la classe
	 * 
	 * @return instance l'unique instance du CryptoLogger
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
