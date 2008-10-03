/**
 * 
 */
package tests;

import static org.junit.Assert.*;

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
		BigInteger rand = BigRandom.nextBigInt(24,true);
		logger.debug("bigrand : "+rand);
		logger.debug("rand length = "+rand.bitLength());
		int i;
		for (i=0 ; i<rand.bitLength() ; i++)
			logger.debug(rand.testBit(i) ? "1":"0");
	}

	/**
	 * Test method for {@link utils.BigRandom#nextBigInt(java.math.BigInteger, java.math.BigInteger)}.
	 */
	@Test
	public void testNextBigIntBigIntegerBigInteger() {
		fail("Not yet implemented");
	}

}
