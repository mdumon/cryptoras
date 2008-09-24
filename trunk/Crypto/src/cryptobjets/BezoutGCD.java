package cryptobjets;

import java.math.BigInteger;

public class BezoutGCD {

	private BigInteger d;
	private BigInteger u;
	private BigInteger v;
	
	public BezoutGCD(BigInteger d, BigInteger u, BigInteger v) {
		this.d = d;
		this.u = u;
		this.v = v;
	}

	public BigInteger getD() {
		return d;
	}

	public BigInteger getU() {
		return u;
	}

	public BigInteger getV() {
		return v;
	}
}
