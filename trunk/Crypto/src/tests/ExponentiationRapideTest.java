package tests;

import java.math.BigInteger;
import java.util.Random;

import junit.framework.TestCase;
import logger.CryptoLogger;

import org.apache.log4j.Logger;
import org.junit.Test;

import utils.ExponentiationRapide;

/**
 * La classe ExponentiationRapideTest. Permet de tester
 * la classe <code>ExponentiationRapide</code>.
 * 
 * @author MAXIME DUMON
 * @version 0.1 24/09/08
 * @since JDK 1.6
 * @see <code>ExponentiationRapide</code>
 */
public class ExponentiationRapideTest extends TestCase {

	/** Le logger. */
	private static Logger logger;
	
	/**
	 * Teste la méthode <code>getResultat</code>.
	 */
	@Test
	public void testGetResultat() {
		logger = CryptoLogger.getInstance(this.getClass().getName());
		BigInteger exposant;
		exposant = new BigInteger(3, new Random());
		assertNotNull("L'exposant n'est pas créé", exposant);
		BigInteger nombre;
		nombre = new BigInteger(2, new Random());
		assertNotNull("L'exposant n'est pas créé", exposant);
		BigInteger resultat;
		resultat = ExponentiationRapide.getResultat(exposant, nombre);
		logger.debug("exposant : " + exposant);
		logger.debug("nombre : " + nombre);
		logger.debug("resultat : " + resultat);
	}

}
