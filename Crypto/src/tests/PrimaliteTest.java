package tests;

import java.math.BigInteger;

import junit.framework.TestCase;
import logger.CryptoLogger;

import org.apache.log4j.Logger;
import org.junit.Test;

import utils.Primalite;

/**
 * The Class PrimaliteTest. Permet de tester la
 * classe <code>Primalite</code>.
 * 
 * @author MAXIME DUMON
 * @version 0.2 24/09/08
 * @since JDK 1.6
 * @see <code>Primalite</code>
 */
public class PrimaliteTest extends TestCase {

	/** Le logger. */
	private static Logger logger;
	
	/**
	 * Teste la m�thode <code>isPremier</code>.
	 */
	@Test
	public void testIsPremier() {
		logger = CryptoLogger.getInstance(this.getClass().getName());
		BigInteger N;
		N = new BigInteger("130789230115889184784687160560183330862845320123630249361959922787096514371561069039536010388297549680036717397016729122705912051578191868140133406412253415776054381188624532347280935490459396955950093807767606447166194932353319423440935993781596351983977630807078712375116205416759372699722121728093163824717");
		assertNotNull("Le nombre � tester n'est pas cr��", N);
		boolean nIsPremier;
		nIsPremier = false;
		nIsPremier = Primalite.isPremier(N);
		logger.debug(N + " est-il premier : " + nIsPremier);
	}
	
	@Test
	public void testGetPremier() {
		logger = CryptoLogger.getInstance(this.getClass().getName());
		BigInteger entier;
		entier = Primalite.getPremier(10, true);
		logger.debug("Entier premier : " + entier);
		logger.debug("Nb bits : " + entier.bitLength());
		boolean isPremier;
		isPremier = Primalite.isPremier(entier);
		logger.debug("Est-il premier ? : " + isPremier);
		logger.debug("Nombre de bits : " + entier.bitLength());
	}
}
