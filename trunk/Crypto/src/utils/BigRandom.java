package utils;

import java.math.BigInteger;
import java.util.Random;

public class BigRandom {

	public static BigInteger nextBigInt(int nbBitsMax, boolean nbBitsFixe) {

		BigInteger rand = new BigInteger(nbBitsMax,new Random());

		if (nbBitsFixe) {
			if (rand.bitLength() < nbBitsMax) {
				rand = rand.setBit(nbBitsMax - 1);
			}
		} else {
			byte[] tab;
			tab = rand.toByteArray();
			tab[tab.length - 1] &= 0;
			rand = new BigInteger(tab);
		}
		return rand;
	}
}
