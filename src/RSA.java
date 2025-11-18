import java.math.BigInteger;
import java.util.Random;

public class RSA {
    public static final int VERSION = 1024;

    public static final BigInteger E = new BigInteger("65537");

    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger phiN;
    private BigInteger d;

    public void intialize(){
        p = BigInteger.probablePrime(VERSION / 2 ,new Random());
        q = BigInteger.probablePrime(VERSION / 2 ,new Random());
        n  = p.multiply(q);
        phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        d = E.modInverse(phiN);

    }

    public BigInteger encrypt (BigInteger message ,BigInteger partnerN){
        return message.modPow(E,partnerN);
    }

    public BigInteger decrypt (BigInteger cipher){
        return cipher.modPow(d,n);
    }
    public BigInteger getN() {
        return n;
    }
}
