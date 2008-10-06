package utils;
import java.math.BigInteger;
import java.util.Random;

/**
 * The Class Primalite.
 * 
 * @author MAXIME DUMON
 * @version 0.3 24/09/08
 * @since JDK 1.6
 * @see <code>ExponentiationRapide</code>, <code>ExponentiationModulaire</code>
 */
public class Primalite {
	
	/**
	 * Test si le nombre entierATester est premier.
	 * 
	 * @param entierATester l'entier à tester
	 * 
	 * @return vrai si entierATester est premier, faux sinon
	 */
	public static boolean isPremier(final BigInteger N) {
		// Trouver k et m tels que N - 1 = ( 2^k ) * m ( N est l'entier à tester )
		BigInteger temp;
		temp = N;
		temp = temp.subtract(BigInteger.ONE);
		int k;
		k = temp.getLowestSetBit();
		BigInteger m;
		m = temp.shiftRight(k);

		// Tirer aléatoirement un entier a tel que 1 <= a <= N - 1 ( N est l'entier à tester )
		BigInteger a;
		do {
			a = new BigInteger(N.bitLength(), new Random());
		} while (a.compareTo(temp) == 1);
		
		// Créer b tel que b = a^m mod N
		BigInteger b;
		b = ExponentiationModulaire.getResultat(m, a, N);
		
		if (b.compareTo(BigInteger.ONE) == 0) {
			return true;
		} else {
			for (int i = 0; i < k; i++) {
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
	
	public static BigInteger getPremier(int nbBits, boolean nbBitsFixe) {
		BigInteger entier;
		entier = null;
		boolean isPremier;
		isPremier = false;
		while(!isPremier) {
			entier = BigRandom.nextBigInt(nbBits, nbBitsFixe);
			isPremier = Primalite.isPremier(entier);
		}
		return entier;
	}
}