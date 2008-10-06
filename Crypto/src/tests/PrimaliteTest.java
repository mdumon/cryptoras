package tests;

import java.math.BigInteger;
import java.util.Random;

import junit.framework.TestCase;
import logger.CryptoLogger;

import org.apache.log4j.Logger;
import org.junit.Test;

import utils.Primalite;

/**
 * The Class PrimaliteTest. Permet de tester la
 * classe <code>Primalite</code>.
 * 
 * @author MAXIME DUMON, ROMAIN MACUREAU
 * @version 1.0 06/10/08
 * @since JDK 1.6
 * @see <code>Primalite</code>
 */
public class PrimaliteTest extends TestCase {

	/**
	 * Teste la méthode <code>isPremier</code>.
	 */
	@Test
	public void testIsPremier() {
		Logger logger = CryptoLogger.getInstance(this.getClass().getName());
		BigInteger N;
		N = new BigInteger(1024, new Random());
		assertNotNull("Le nombre à tester n'est pas créé", N);
		boolean nIsPremier;
		nIsPremier = false;
		nIsPremier = Primalite.isPremier(N);
		logger.debug(N + " est-il premier : " + nIsPremier);
	}
	
	/**
	 * Test la méthode <code>getPremier</code>.
	 */
	@Test
	public void testGetPremier() {
		Logger logger = CryptoLogger.getInstance(this.getClass().getName());
		BigInteger entier;
		entier = Primalite.getPremier(10, true);
		logger.debug("Entier premier : " + entier);
		logger.debug("Nb bits : " + entier.bitLength());
	}
}