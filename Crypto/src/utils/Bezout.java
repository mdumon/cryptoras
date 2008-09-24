package utils;

import java.math.BigInteger;

import cryptobjets.BezoutGCD;

/**
 * Class Bezout
 * 
 * @author Romain Macureau
 * @version 0.1 24/09/08
 * @since JDK 1.6
 */
public class Bezout {
	
	/**
	 * Pour A et B donnés, trouve pgcd(A,B) et U et V tels que pgcd(A,B)=A*U+B*V
	 * 
	 * @param A et B
	 * 
	 * @return un objet BezoutGCD contenant le pgcd ainsi que U et V
	 */
	public static BezoutGCD calc(BigInteger a, BigInteger b) {
		BigInteger d,q,u,v,w,x,y,z,aBis,bBis;
		aBis = a;
		bBis = b;
		u = BigInteger.ONE;
		v = BigInteger.ZERO;
		w = BigInteger.ZERO;
		x = BigInteger.ONE;
		y = BigInteger.ZERO;
		
		if (b.compareTo(BigInteger.ZERO) < 0)
			y = BigInteger.ONE;
		
		while (b.compareTo(BigInteger.ZERO) != 0) {
			q = a.divide(b);
			z = u;
			u = w;
			w = z.subtract(q.multiply(w));
			z = v;
			v = x;
			x = z.subtract(q.multiply(x));
			z = a;
			a = b;
			b = z.subtract(q.multiply(b));
		}
		
		if (y.compareTo(BigInteger.ONE) == 0) {
			u = u.negate();
			v = v.negate();
		}
		
		d = aBis.multiply(u).add(bBis.multiply(v));
		
		return new BezoutGCD(d,u,v);
	}
}
