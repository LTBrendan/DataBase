package junit.connexion;

import static org.junit.Assert.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

import connexion.AES;

public class TestAES {
	@Test
	public void testEncrypt () {
		String toCrypt = "test";
		String uncrypt = "test";
		String mykey = "1234567891234567";
	    SecretKey key = new SecretKeySpec(mykey.getBytes(), "AES");
	    AES encrypter = new AES(key);
	    toCrypt = encrypter.encrypt(toCrypt);
	    assertFalse (toCrypt.equals(uncrypt));
	    assertTrue (toCrypt.equals(encrypter.encrypt("test")));
	    assertFalse (toCrypt.equals(encrypter.encrypt(null)));
	}
}
