package utils;

import java.math.BigInteger;

/**
 * La classe ExponentiationModulaire. Propose une méthode statique
 * permettant de faire une exponentiation modulaire. Utile pour les tests
 * de primalité de grands entiers
 * 
 * @author MAXIME DUMON, ROMAIN MACUREAU
 * @version 1.0 06/10/08
 * @since JDK 1.6
 * @see <code>Primalite</code>
 */
public class ExponentiationModulaire {

	/**
	 * Méthode getResultat. Calcul le résultat
	 * 
	 * @param exposant l'exposant
	 * @param nombre le nombre à élever
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