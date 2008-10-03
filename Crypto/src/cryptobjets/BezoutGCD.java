package cryptobjets;

import java.math.BigInteger;

/**
 * Classe BezoutGCD.
 */
public class BezoutGCD {

	/** The d. */
	private BigInteger d;
	
	/** The u. */
	private BigInteger u;
	
	/** The v. */
	private BigInteger v;
	
	/**
	 * Instantiates a new bezout gcd.
	 * 
	 * @param d the d
	 * @param u the u
	 * @param v the v
	 */
	public BezoutGCD(BigInteger d, BigInteger u, BigInteger v) {
		this.d = d;
		this.u = u;
		this.v = v;
	}

	/**
	 * Gets the d.
	 * 
	 * @return the d
	 */
	public BigInteger getD() {
		return d;
	}

	/**
	 * Gets the u.
	 * 
	 * @return the u
	 */
	public BigInteger getU() {
		return u;
	}

	/**
	 * Gets the v.
	 * 
	 * @return the v
	 */
	public BigInteger getV() {
		return v;
	}
}
