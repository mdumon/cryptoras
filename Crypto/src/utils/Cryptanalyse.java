package utils;

import java.math.BigInteger;

/**
 * La classe Cryptanalyse. Impl�mentation de 2 attaques :
 * l'attaque de Wiener, bas� sur le fait que la cl� secr�te est petite,
 * l'attaque d'"Astad" bas�e sur le calcul de la racine cubique d'un nombre
 * 
 * @author MAXIME DUMON, ROMAIN MACUREAU
 * @version 0.5 06/10/08
 * @since JDK 1.6
 */
public class Cryptanalyse {

	/**
	 * M�thode calculReduites. Permet de calculer les r�duites de N / e
	 * pour l'attaque de Wiener
	 * 
	 * @param numerateur le numerateur (le modulo N)
	 * @param denominateur le denominateur (la cl� publique e)
	 * @param maximum le maximum d'it�rations que l'on doit faire
	 * 
	 * @return D[] l'ensemble des cl�s secr�tes possibles
	 */
	public static BigInteger[] calculReduites(BigInteger numerateur, BigInteger denominateur, int maximum) {
		// Cr�ation des Qi
		BigInteger[] Q;
		Q = new BigInteger[maximum];
		// Cr�ation de Q0
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

		// Cr�ation des Di
		BigInteger[] D;
		D = new BigInteger[Q.length];
		// Cr�ation de D0 et D1
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
