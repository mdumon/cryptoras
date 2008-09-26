package utils;

import java.math.BigInteger;

/**
 * La classe ExponentiationModulaire. Propose une méthode statique
 * permettant de faire une exponentiation modulaire. Utile pour les tests
 * de primalité de grands entiers.
 * 
 * @author MAXIME DUMON
 * @version 0.1 24/09/08
 * @since JDK 1.6
 * @see <code>Primalite</code>
 */
public class ExponentiationModulaire {

	/**
	 * Calcul le résultat.
	 * 
	 * @param exposant l'exposant
	 * @param nombre the nombre à élever
	 * @param modulo le modulo du calcul
	 * 
	 * @return le resultat
	 */
	public static BigInteger getResultat(final BigInteger exposant, final BigInteger nombre, final BigInteger modulo) {
		BigInteger resultat;
		resultat = BigInteger.ONE;
		for (int i = exposant.bitLength() - 1; i >= 0; i--) {
			resultat = resultat.multiply(resultat).mod(modulo);
			if (exposant.testBit(i)) {
				resultat = resultat.multiply(nombre).mod(modulo);
			}
		}
		return resultat;
	}
}
