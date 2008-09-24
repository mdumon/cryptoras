package tests;

import java.math.BigInteger;

import utils.Bezout;
import cryptobjets.BezoutGCD;

public class BezoutTestB {

	public static void main(String[] args) {
		BigInteger a,b;

		a = new BigInteger("738264876");
		b = new BigInteger("273263621");

		BezoutGCD res;
		res = Bezout.calc(a,b);
		
		System.out.println("pgcd = "+res.getD());
		System.out.println("u = "+res.getU());
		System.out.println("v = "+res.getV());
	}

}
