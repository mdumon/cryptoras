package utils;

import java.math.BigInteger;

/**
 * La classe ExponentiationRapide. Propose une méthode
 * statique pour calculer une exponentiation rapide.
 * Utile pour les tests de primalité de grands entiers.
 * 
 * @author MAXIME DUMON
 * @version 0.1 24/09/08
 * @since JDK 1.6
 * @see <code>Primalite</code>
 */
public class ExponentiationRapide {

	/**
	 * Calcul le résultat.
	 * 
	 * @param exposant l'exposant
	 * @param nombre le nombre à élever
	 * 
	 * @return le resultat
	 */
	public BigInteger getResultat(final BigInteger exposant, final BigInteger nombre) {
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
