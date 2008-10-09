package utils;

import java.math.BigInteger;

/**
 * La classe Cryptanalyse. Implémentation de 2 attaques :
 * l'attaque de Wiener, basé sur le fait que la clé secrète est petite,
 * l'attaque d'"Astad" basée sur le calcul de la racine cubique d'un nombre
 * 
 * @author MAXIME DUMON, ROMAIN MACUREAU
 * @version 0.5 06/10/08
 * @since JDK 1.6
 */
public class Cryptanalyse {

	/**
	 * Méthode calculReduites. Permet de calculer les réduites de N / e
	 * pour l'attaque de Wiener
	 * 
	 * @param numerateur le numerateur (le modulo N)
	 * @param denominateur le denominateur (la clé publique e)
	 * @param maximum le maximum d'itérations que l'on doit faire
	 * 
	 * @return D[] l'ensemble des clés secrètes possibles
	 */
	public static BigInteger[] calculReduites(BigInteger numerateur, BigInteger denominateur, int maximum) {
		// Création des Qi
		BigInteger[] Q;
		Q = new BigInteger[maximum];
		// Création de Q0
		BigInteger a;
		a = numerateur;
		BigInteger b;
		b = denominateur;
		BigInteger reste;
		reste = new BigInteger("0");
		// Calcul des Qi
		int i = 0;
		while ((i < maximum) && (b.compareTo(BigInteger.ZERO) != 0)) {
			Q[i] = a.divide(b);
			reste = a.remainder(b);
			a = b;
			b = reste;
			i++;
		}

		// Création des Di
		BigInteger[] D;
		D = new BigInteger[Q.length];
		// Création de D0 et D1
		D[0] = BigInteger.ONE;
		D[1] = Q[1];
		// Calcul des Di
		for (i = 2; i < Q.length; i++) {
			D[i] = Q[i].multiply(D[i - 1]).add(D[i - 2]);
		}

		// Retour de Di
		return(D);
	}
}
