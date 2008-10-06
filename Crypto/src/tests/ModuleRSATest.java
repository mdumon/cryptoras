package tests;

import java.math.BigInteger;
import java.util.Random;

import logger.CryptoLogger;

import org.apache.log4j.Logger;
import org.junit.Test;

import cryptobjets.ModuleRSA;

/**
 * La classe ModuleRSATest. Permet de tester la classe <code>ModuleRSA</code>
 * 
 * @author MAXIME DUMON, ROMAIN MACUREAU
 * @version 1.0 06/10/08
 * @since JDK 1.6
 * @see <code>ModuleRSA</code>
 */
public class ModuleRSATest {

	/** Le logger */
	private static Logger logger;
	
	/**
	 * Teste le constructeur <code>moduleRSA</code>
	 */
	@Test
	public void testRSA() {
		logger = CryptoLogger.getInstance(this.getClass().getName());
		
		ModuleRSA rsa;
		rsa = new ModuleRSA(1024);
		BigInteger clair;
		clair = new BigInteger(2048, new Random());
		logger.debug("Message en clair : " + clair);
		
		BigInteger chiffre;
		chiffre = rsa.chiffrer(clair);
		logger.debug("Message chiffre : " + chiffre);
		BigInteger dechiffre = null;
		
		for (int i = 0; i < 100; i++){
			dechiffre = rsa.dechiffrer(chiffre);
		}
		logger.debug("Message dechiffre : " + dechiffre);
		
		for (int i = 0; i < 100; i++){
			dechiffre = rsa.decipher(chiffre);
		}
		logger.debug("Message dechiffre CRT : " + dechiffre);
	}
}
