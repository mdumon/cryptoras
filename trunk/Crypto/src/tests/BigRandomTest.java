/**
 * 
 */
package tests;

import java.math.BigInteger;

import logger.CryptoLogger;

import org.apache.log4j.Logger;
import org.junit.Test;

import utils.BigRandom;

/**
 * @author macureau
 *
 */
public class BigRandomTest {

	/**
	 * Test method for {@link utils.BigRandom#nextBigInt(java.math.BigInteger)}.
	 */
	@Test
	public void testNextBigIntBigInteger() {
		Logger logger = CryptoLogger.getInstance(this.getClass().getName());
		BigInteger rand = BigRandom.nextBigInt(27,true);
		logger.debug("bigRand : "+rand);
		logger.debug("rand length = "+rand.bitLength());
		
		BigInteger rand2 = BigRandom.nextBigInt(27,false);
		logger.debug("bigRand2 : "+rand2);
		logger.debug("rand2 length = "+rand2.bitLength());
	}
}
