package cryptobjets;

import java.math.BigInteger;

import utils.Bezout;
import utils.ExponentiationModulaire;
import utils.Primalite;

/**
 * La classe ModuleRSA. Cette classe permet de créer
 * un objet moduleRSA qui permet de générer les clés
 * et de chiffrer et déchiffrer
 * 
 * @author MAXIME DUMON, ROMAIN MACUREAU
 * @version 1.0 06/10/08
 * @since JDK 1.6
 * @see <code>Primalite</code>, <code>ExponentiationModulaire</code>
 */
public class ModuleRSA {

	/** La cle secrete */
	private BigInteger cleSecrete;
	
	/** Le modulo */
	private BigInteger modulo;
	
	/** Le cle publique */
	private BigInteger clePublique;
	
	/** p */
	private BigInteger p;
	
	/** q */
	private BigInteger q;
	
	/**
	 * Instanties un nouveau module rsa
	 * 
	 * @param nbBits le nombre de bits du module
	 */
	public ModuleRSA (int nbBits) {
		p = Primalite.getPremier(nbBits / 2, true);
		
		do {
			q = Primalite.getPremier(nbBits - nbBits / 2, true);
		} while (p.compareTo(q) == 0);
		
		modulo = p.multiply(q);
		BigInteger phyN;
		phyN = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		
		BezoutGCD coeffs;
		do {
			clePublique = Primalite.getPremier(nbBits / 2, false);
			coeffs = Bezout.calc(clePublique, phyN);
		} while (coeffs.getD().compareTo(BigInteger.ONE) != 0);
		
		cleSecrete = coeffs.getU();
		if (cleSecrete.signum() == -1) {
			cleSecrete = cleSecrete.add(phyN);
		}
	}
	
	/**
	 * Méthode chiffrer. Permet de chiffrer un message
	 * 
	 * @param clair le message clair à chiffrer
	 * 
	 * @return chiffre le message chiffré
	 */
	public BigInteger chiffrer(BigInteger clair) {
		BigInteger chiffre;
		chiffre = ExponentiationModulaire.getResultat(clePublique, clair, modulo);
		return chiffre;
	}
	
	/**
	 * Méthode dechiffrer. Permet de déchiffrer un message par exponentiation modulaire
	 * 
	 * @param chiffre le chiffré à déchiffrer
	 * 
	 * @return clair le message clair
	 */
	public BigInteger dechiffrer(BigInteger chiffre) {
		BigInteger clair;
		clair = ExponentiationModulaire.getResultat(cleSecrete, chiffre, modulo);
		return clair;
	}
	
	/**
	 * Méthode decipher. Permet de déchiffrer un message en utilisant le théorème des
	 * restes chinois
	 * 
	 * @param chiffre le chiffré à déchiffrer
	 * 
	 * @return clair le message clair
	 */
	public BigInteger decipher(BigInteger chiffre) {
		BigInteger a = ExponentiationModulaire.getResultat(cleSecrete.mod(p.subtract(BigInteger.ONE)), chiffre.mod(p), p);
		BigInteger b = ExponentiationModulaire.getResultat(cleSecrete.mod(q.subtract(BigInteger.ONE)), chiffre.mod(q), q);
		BezoutGCD res = Bezout.calc(q, p);
		return a.subtract(b).multiply(q).multiply(res.getU()).add(b).mod(modulo);
	}
}
