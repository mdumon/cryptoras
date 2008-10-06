package tests;

import java.math.BigInteger;

import logger.CryptoLogger;

import org.apache.log4j.Logger;
import org.junit.Test;

import cryptobjets.ModuleRSA;

public class ModuleRSATest {

	@Test
	public void testRSA() {
		Logger logger = CryptoLogger.getInstance(this.getClass().getName());
		ModuleRSA rsa;
		rsa = new ModuleRSA(1024);
		BigInteger clair;
		clair = new BigInteger("123456");
		logger.debug("Message en clair : " + clair);
		BigInteger chiffre;
		chiffre = rsa.chiffrer(clair);
		logger.debug("Message chiffre : " + chiffre);
		BigInteger dechiffre;
		dechiffre = rsa.dechiffrer(chiffre);
		logger.debug("Message dechiffre : " + dechiffre);
	}
}
