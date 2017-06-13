package connexion;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

class AES {
	private Cipher ecipher;
	private Cipher dcipher;

	AES(SecretKey key) {
		try {
			ecipher = Cipher.getInstance("AES");
			dcipher = Cipher.getInstance("AES");
			ecipher.init(Cipher.ENCRYPT_MODE, key);
			dcipher.init(Cipher.DECRYPT_MODE, key);
		} catch (Exception e) {
		}
	}

	public String encrypt(String str) {
		try {
			byte[] utf8 = str.getBytes("UTF-8");
			byte[] enc = ecipher.doFinal(utf8);

			return new sun.misc.BASE64Encoder().encode(enc);
		} catch (Exception e) {
		}
		return null;
	}
}
