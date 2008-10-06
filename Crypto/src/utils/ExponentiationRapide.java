package utils;

import java.math.BigInteger;

/**
 * La classe ExponentiationRapide. Propose une méthode
 * statique pour calculer une exponentiation rapide.
 * Utile pour les tests de primalité de grands entiers
 * 
 * @author MAXIME DUMON, ROMAIN MACUREAU
 * @version 1.0 06/10/08
 * @since JDK 1.6
 * @see <code>Primalite</code>
 */
public class ExponentiationRapide {

	/**
	 * Méthode getResultat. Calcul le résultat
	 * 
	 * @param exposant l'exposant
	 * @param nombre le nombre à élever
	 * 
	 * @return le resultat
	 */
	public static BigInteger getResultat(final BigInteger exposant, final BigInteger nombre) {
		BigInteger resultat;
		resultat = BigInteger.ONE;
		for (int i = exposant.bitLength() - 1; i >= 0; i--) {
			resultat = resultat.multiply(resultat);
			if (exposant.testBit(i)) {
				resultat = resultat.multiply(nombre);
			}
		}
		return resultat;
	}
}