package tests;

import java.math.BigInteger;
import java.util.Random;

import junit.framework.TestCase;

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
	private final static Logger logger = Logger.getRootLogger();
	
	/**
	 * Teste la méthode <code>getResultat</code>.
	 */
	@Test
	public void testGetResultat() {
		BigInteger exposant;
		exposant = new BigInteger(4096, new Random());
		assertNotNull("L'exposant n'est pas créé", exposant);
		BigInteger nombre;
		nombre = new BigInteger(200, new Random());
		assertNotNull("Le nombre à tester n'est pas créé", nombre);
		BigInteger modulo;
		modulo = new BigInteger(4096, new Random());
		assertNotNull("Le modulo n'est pas créé", modulo);
		ExponentiationModulaire expoModulaire;
		expoModulaire = new ExponentiationModulaire();
		BigInteger resultat;
		resultat = expoModulaire.getResultat(exposant, nombre, modulo);
		logger.debug(exposant);
		logger.debug(nombre);
		logger.debug(modulo);
		logger.debug(resultat);
	}
}
