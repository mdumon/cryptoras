package utils;

import java.math.BigInteger;
import java.util.Random;

/**
 * La classe BigRandom. Permet de générer des
 * entiers aléatoires avec un nombre de bits
 * fixe ou non
 * 
 * @author MAXIME DUMON, ROMAIN MACUREAU
 * @version 1.0 06/10/08
 * @since JDK 1.6
 */
public class BigRandom {

	/** The random. */
	private static Random random;
	
	/**
	 * Méthode nextBigInt. Retourne un entier aléatoire
	 * avec un nombre de bits fixe ou non
	 * 
	 * @param nbBitsMax le nombre de bits maximum de l'entier à générer
	 * @param nbBitsFixe booléen permettant de savoir si le nombre de bits est fixe ou non
	 * 
	 * @return rand le nombre aléatoire généré
	 */
	public static BigInteger nextBigInt(int nbBitsMax, boolean nbBitsFixe) {
		if (random == null) {
			random = new Random();
		}
		
		BigInteger rand = new BigInteger(nbBitsMax, random);

		if (nbBitsFixe) {
			if (rand.bitLength() < nbBitsMax) {
				rand = rand.setBit(nbBitsMax - 1);
			}
		} else {
			byte[] tab;
			tab = rand.toByteArray();
			tab[tab.length - 1] = 0;
			rand = new BigInteger(tab);
		}
		return rand;
	}
}