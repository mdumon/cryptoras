package utils;
import java.math.BigInteger;
import java.util.Random;

/**
 * La classe Primalite. Permet de tester si un nombre
 * est premier et d'en générer aléatoirement
 * 
 * @author MAXIME DUMON, ROMAIN MACUREAU
 * @version 1.0 06/10/08
 * @since JDK 1.6
 * @see <code>ExponentiationRapide</code>, <code>ExponentiationModulaire</code>
 */
public class Primalite {
	
	/**
	 * Méthode isPremier. Test si le nombre N est premier
	 * 
	 * @param N le nombre N à tester
	 * 
	 * @return vrai si N est premier, faux sinon
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
		a = new BigInteger(N.bitLength(), new Random());
		
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
					b = b.multiply(b).mod(N);
				}
			}
			return false;
		}
	}
	
	/**
	 * Méthode getPremier. Permet de générer
	 * un nombre premier avec un nombre de bits fixe ou non.
	 * 
	 * @param nbBits le nombre de bits maximum du nombre à générer
	 * @param nbBitsFixe vrai si le nombre de bits est fixe, faux sinon
	 * 
	 * @return entier le nombre premier généré
	 */
	public static BigInteger getPremier(int nbBits, boolean nbBitsFixe) {
		BigInteger entier;
		entier = null;
		boolean isPremier;
		isPremier = false;
		
		entier = BigRandom.nextBigInt(nbBits, nbBitsFixe);
		entier = entier.setBit(0);
		while(!isPremier) {
			entier = entier.add(new BigInteger("2"));
			isPremier = Primalite.isPremier(entier);
		}
		return entier;
	}
}