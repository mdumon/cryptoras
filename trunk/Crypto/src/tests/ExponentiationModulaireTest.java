package tests;

import java.math.BigInteger;
import java.util.Random;

import junit.framework.TestCase;
import logger.CryptoLogger;

import org.apache.log4j.Logger;

import org.junit.Test;

import utils.ExponentiationModulaire;

/**
 * La classe ExponentiationModulaireTest. Permet de tester
 * la classe <code>ExponentiationModulaire</code>.
 * 
 * @author MAXIME DUMON
 * @version 0.1 24/09/08
 * @since JDK 1.6
 * @see <code>ExponentiationModulaire</code>
 */
public class ExponentiationModulaireTest extends TestCase {

	/** Le logger. */
	private static Logger logger;
	
	/**
	 * Teste la m�thode <code>getResultat</code>.
	 */
	@Test
	public void testGetResultat() {
		logger = CryptoLogger.getInstance(this.getClass().getName());
		BigInteger exposant;
		exposant = new BigInteger(4096, new Random());
		assertNotNull("L'exposant n'est pas cr��", exposant);
		BigInteger nombre;
		nombre = new BigInteger(200, new Random());
		assertNotNull("Le nombre � tester n'est pas cr��", nombre);
		BigInteger modulo;
		modulo = new BigInteger(4096, new Random());
		assertNotNull("Le modulo n'est pas cr��", modulo);
		BigInteger resultat;
		resultat = ExponentiationModulaire.getResultat(exposant, nombre, modulo);
		logger.debug("exposant : " + exposant);
		logger.debug("nombre : " + nombre);
		logger.debug("modulo : " + modulo);
		logger.debug("resultat : " + resultat);
	}
}
