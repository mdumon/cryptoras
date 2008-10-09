package cryptobjets;

import java.math.BigInteger;

import utils.ExponentiationModulaire;

/**
 * La classe BadModuleRSA. Cette classe permet de créer
 * un objet BadModuleRSA qui ne fait rien. Il est utilisé
 * pouvoir tester l'attaque de Wiener
 * 
 * @author MAXIME DUMON, ROMAIN MACUREAU
 * @version 1.0 06/10/08
 * @since JDK 1.6
 * @see <code>Primalite</code>, <code>ExponentiationModulaire</code>
 */
public class BadModuleRSA {

	/**
	 * Gets le modulo.
	 * 
	 * @return le modulo
	 */
	public BigInteger getModulo() {
		return modulo;
	}

	/**
	 * Sets le modulo.
	 * 
	 * @param modulo le nouveau modulo
	 */
	public void setModulo(BigInteger modulo) {
		this.modulo = modulo;
	}

	/**
	 * Gets la cle publique.
	 * 
	 * @return la cle publique
	 */
	public BigInteger getClePublique() {
		return clePublique;
	}

	/**
	 * Sets la cle publique.
	 * 
	 * @param clePublique la nouvelle cle publique
	 */
	public void setClePublique(BigInteger clePublique) {
		this.clePublique = clePublique;
	}

	/**
	 * Gets p.
	 * 
	 * @return p
	 */
	public BigInteger getP() {
		return p;
	}

	/**
	 * Sets p.
	 * 
	 * @param p le nouveau p
	 */
	public void setP(BigInteger p) {
		this.p = p;
	}

	/**
	 * Gets q.
	 * 
	 * @return q
	 */
	public BigInteger getQ() {
		return q;
	}

	/**
	 * Sets q.
	 * 
	 * @param q le nouveau q
	 */
	public void setQ(BigInteger q) {
		this.q = q;
	}

	/** Le modulo. */
	private BigInteger modulo;
	
	/** Le cle publique. */
	private BigInteger clePublique;
	
	/** p. */
	private BigInteger p;
	
	/** q. */
	private BigInteger q;
	
	/**
	 * Instanties un nouveau module rsa.
	 * 
	 * @param nbBits le nombre de bits du module
	 */
	public BadModuleRSA (int nbBits) {}
	
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
	public BigInteger dechiffrer(BigInteger chiffre, BigInteger modulo, BigInteger cleSecrete) {
		BigInteger clair;
		clair = ExponentiationModulaire.getResultat(cleSecrete, chiffre, modulo);
		return clair;
	}
}
