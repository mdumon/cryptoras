package utils;

import java.math.BigInteger;
import java.util.Random;

public class BigRandom {
	
	public static BigInteger nextBigInt(int nbBitsMax, boolean nbBitsFixe) {
		
		BigInteger rand = new BigInteger(nbBitsMax,new Random());
		if (rand.bitLength() > nbBitsMax)
			rand = rand.clearBit(rand.bitLength());
		else if (rand.bitLength() < nbBitsMax)
			rand = rand.setBit(nbBitsMax);
		
		/*int length = nbBitsMax%8 == 0 ? nbBitsMax / 8 : (nbBitsMax / 8) + 1;
		byte[] tab = new byte[length];
		new Random().nextBytes(tab);
		
		int ecart = nbBitsMax%8;
		
		byte masque = (byte) 255;
		masque >>>= 8-ecart;
		tab[0] = masque;
		
		BigInteger rand = new BigInteger(tab);*/
		
		/*int ecart = length * 8 - nbBitsMax;
		int i;
		for (i=ecart+nbBitsMax ; i>nbBitsMax ; i--)
			rand.clearBit(i);
		if (nbBitsFixe)
			rand.setBit(nbBitsMax);*/
		return rand;
	}
}
