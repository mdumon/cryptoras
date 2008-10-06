package utils;

import java.math.BigInteger;
import java.util.Random;

/**
 * La classe BigRandom. Permet de g�n�rer des
 * entiers al�atoires avec un nombre de bits
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
	 * M�thode nextBigInt. Retourne un entier al�atoire
	 * avec un nombre de bits fixe ou non
	 * 
	 * @param nbBitsMax le nombre de bits maximum de l'entier � g�n�rer
	 * @param nbBitsFixe bool�en permettant de savoir si le nombre de bits est fixe ou non
	 * 
	 * @return rand le nombre al�atoire g�n�r�
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