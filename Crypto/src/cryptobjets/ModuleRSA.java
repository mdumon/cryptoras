package cryptobjets;

import java.math.BigInteger;

import utils.Bezout;
import utils.BigRandom;
import utils.ExponentiationModulaire;
import utils.Primalite;

public class ModuleRSA {

	private BigInteger cleSecrete;
	private BigInteger modulo;
	private BigInteger clePublique;
	
	public ModuleRSA (int nbBits) {
		BigInteger p;
		do {
			p = Primalite.getPremier(nbBits, true);
		} while (!Primalite.isPremier(p));
		BigInteger q;
		do {
			q = Primalite.getPremier(nbBits, true);
		} while ((Primalite.isPremier(q) != true) || (p.compareTo(q) == 0));
		
		modulo = p.multiply(q);
		BigInteger phyN;
		phyN = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		phyN.setBit(0);
		BezoutGCD coeffs;		
		do {
			clePublique = BigRandom.nextBigInt(nbBits, true);
			clePublique.setBit(clePublique.bitLength() - 1);
			coeffs = Bezout.calc(clePublique, phyN);
		} while (coeffs.getD().compareTo(BigInteger.ONE) != 0);
				
		System.out.println("PhyN vaut : " + phyN);
		System.out.println("PGDC = " + coeffs.getD());
		System.out.println("Cle secrete = " + coeffs.getU());
		System.out.println("Cle publique = " + clePublique);
		System.out.println("F = " + coeffs.getV());
		System.out.println("N = " + modulo);
		cleSecrete = coeffs.getU();
		if (cleSecrete.signum() == -1) {
			cleSecrete = cleSecrete.add(phyN);
		}
		System.out.println("Cle secrete = " + coeffs.getU());
		BigInteger resultat;
		resultat = clePublique.multiply(cleSecrete);
		resultat = resultat.mod(phyN);
		if (resultat.compareTo(BigInteger.ONE) == 0) {
			System.out.println("E * D mod phyN = " + resultat);
		}
	}
	
	public BigInteger chiffrer(BigInteger clair) {
		BigInteger chiffre;
		chiffre = ExponentiationModulaire.getResultat(clePublique, clair, modulo);
		return chiffre;
	}
	
	public BigInteger dechiffrer(BigInteger chiffre) {
		BigInteger clair;
		clair = ExponentiationModulaire.getResultat(cleSecrete, chiffre, modulo);
		return clair;
		
	}
}
