package tests;

import java.math.BigInteger;

import logger.CryptoLogger;

import org.apache.log4j.Logger;
import org.junit.Test;

import cryptobjets.BezoutGCD;


import utils.Bezout;

/**
 * La classe BezoutTest permet de tester
 * la classe <code>Bezout</code>.
 * 
 * @author Romain Macureau
 * @version 0.1 24/09/08
 * @since JDK 1.6
 * @see <code>Bezout</code>
 */
public class BezoutTest {
	
	/** Le logger */
	private final static Logger logger = CryptoLogger.getInstance(BezoutTest.class.getName());
	
	/**
	 * Teste la méthode <code>calc</code>
	 */
	@Test
	public void testCalc() {
		BigInteger a,b;

		a = new BigInteger("27");
		b = new BigInteger("15");

		BezoutGCD res;
		res = Bezout.calc(a,b);
		logger.debug("pgcd = "+res.getD());
		logger.debug("u = "+res.getU());
		logger.debug("v = "+res.getV());
	}
}
