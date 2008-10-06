package tests;

import java.math.BigInteger;

import junit.framework.TestCase;
import logger.CryptoLogger;

import org.apache.log4j.Logger;
import org.junit.Test;

import utils.ExponentiationModulaire;

/**
 * La classe ExponentiationModulaireTest. Permet de tester
 * la classe <code>ExponentiationModulaire</code>
 * 
 * @author MAXIME DUMON, ROMAIN MACUREAU
 * @version 1.0 06/10/08
 * @since JDK 1.6
 * @see <code>ExponentiationModulaire</code>
 */
public class ExponentiationModulaireTest extends TestCase {

	/** Le logger */
	private static Logger logger;
	
	/**
	 * Teste la méthode <code>getResultat</code>
	 */
	@Test
	public void testGetResultat() {
		logger = CryptoLogger.getInstance(this.getClass().getName());
		BigInteger exposant;
		exposant = new BigInteger("3");
		assertNotNull("L'exposant n'est pas créé", exposant);
		BigInteger nombre;
		nombre = new BigInteger("4");
		assertNotNull("Le nombre à tester n'est pas créé", nombre);
		BigInteger modulo;
		modulo = new BigInteger("7");
		assertNotNull("Le modulo n'est pas créé", modulo);
		BigInteger resultat;
		resultat = ExponentiationModulaire.getResultat(exposant, nombre, modulo);
		logger.debug("exposant : " + exposant);
		logger.debug("nombre : " + nombre);
		logger.debug("modulo : " + modulo);
		logger.debug("resultat : " + resultat);
	}
}
