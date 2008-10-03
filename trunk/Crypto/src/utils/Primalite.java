package utils;
import java.math.BigInteger;
import java.util.Random;

import logger.CryptoLogger;

import org.apache.log4j.Logger;

/**
 * The Class Primalite.
 * 
 * @author MAXIME DUMON
 * @version 0.3 24/09/08
 * @since JDK 1.6
 * @see <code>ExponentiationRapide</code>, <code>ExponentiationModulaire</code>
 */
public class Primalite {

	
	private static Logger logger;
	
	/**
	 * Test si le nombre entierATester est premier.
	 * 
	 * @param entierATester l'entier à tester
	 * 
	 * @return vrai si entierATester est premier, faux sinon
	 */
	public static boolean isPremier(final BigInteger N) {
		logger = CryptoLogger.getInstance(Primalite.class.getName());
		// Trouver k et m tels que N - 1 = ( 2^k ) * m ( N est l'entier à tester )
		logger.debug("N vaut : " + N + " sur " + N.bitLength() + " bits");
		BigInteger temp;
		temp = N;
		temp = temp.subtract(BigInteger.ONE);
		logger.debug("Temp vaut : " + temp);
		int k;
		k = temp.getLowestSetBit();
		logger.debug("k vaut : " + k);
		BigInteger m;
		m = temp.shiftRight(k);
		logger.debug("m vaut : " + m);

		// Tirer aléatoirement un entier a tel que 1 <= a <= N - 1 ( N est l'entier à tester )
		BigInteger a;
		do {
			a = new BigInteger(N.bitLength(), new Random());
		} while (a.compareTo(temp) == 1);
		logger.debug("a vaut : " + a);
		// Créer b tel que b = a^m mod N
		BigInteger b;
		b = ExponentiationModulaire.getResultat(m, a, N);
		logger.debug("b vaut : " + b);
		
		b = b.mod(N);
		logger.debug("b mod N vaut : " + b);
		
		if (b.compareTo(BigInteger.ONE) == 0) {
			return true;
		} else {
			for (int i = 0; i < k; i++) {
				logger.debug("b vaut : " + b);
				logger.debug("i vaut : " + i);
				if (b.compareTo(temp) == 0) {
					return true;
				} else {
					b = b.multiply(b);
					b = b.mod(N);
				}
			}
			return false;
		}
	}
}