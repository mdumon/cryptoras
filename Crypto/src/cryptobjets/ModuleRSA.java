package cryptobjets;

import java.math.BigInteger;

import utils.Bezout;
import utils.ExponentiationModulaire;
import utils.Primalite;

/**
 * La classe ModuleRSA. Cette classe permet de cr�er
 * un objet moduleRSA qui permet de g�n�rer les cl�s
 * et de chiffrer et d�chiffrer
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
	 * M�thode chiffrer. Permet de chiffrer un message
	 * 
	 * @param clair le message clair � chiffrer
	 * 
	 * @return chiffre le message chiffr�
	 */
	public BigInteger chiffrer(BigInteger clair) {
		BigInteger chiffre;
		chiffre = ExponentiationModulaire.getResultat(clePublique, clair, modulo);
		return chiffre;
	}
	
	/**
	 * M�thode dechiffrer. Permet de d�chiffrer un message par exponentiation modulaire
	 * 
	 * @param chiffre le chiffr� � d�chiffrer
	 * 
	 * @return clair le message clair
	 */
	public BigInteger dechiffrer(BigInteger chiffre) {
		BigInteger clair;
		clair = ExponentiationModulaire.getResultat(cleSecrete, chiffre, modulo);
		return clair;
	}
	
	/**
	 * M�thode decipher. Permet de d�chiffrer un message en utilisant le th�or�me des
	 * restes chinois
	 * 
	 * @param chiffre le chiffr� � d�chiffrer
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
