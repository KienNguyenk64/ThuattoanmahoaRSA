import java.math.BigInteger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RSA person1 = new RSA();
        RSA person2 = new RSA();

        person1.intialize();
        person2.intialize();

        BigInteger message = new BigInteger("23052021");
        BigInteger cipher = person1.encrypt(message,person2.getN());

        BigInteger decrypted = person2.decrypt(cipher);
        System.out.println(message);
        System.out.println(decrypted);
    }
}