package model.connexion;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;


/**
 * This class has static methods used to encrypt user's passwords
 *
 */
public class AES {
	private Cipher ecipher;
	private Cipher dcipher;

	/**
	 * @param key the key used to encrypt passwords
	 */
	public AES(SecretKey key) {
		try {
			ecipher = Cipher.getInstance("AES");
			dcipher = Cipher.getInstance("AES");
			ecipher.init(Cipher.ENCRYPT_MODE, key);
			dcipher.init(Cipher.DECRYPT_MODE, key);
		} catch (Exception e) {
		}
	}

	/**
	 * This static method encrypt the string in parameter
	 * @param str the string to encrypt
	 * @return the string encrypted
	 */
	public String encrypt(String str) {
		try {
			byte[] utf8 = str.getBytes("UTF-8");
			byte[] enc = ecipher.doFinal(utf8);

			return new sun.misc.BASE64Encoder().encode(enc);
		} catch (Exception e) {
		}
		return null;
	}
	
	 /**
	  * This static method encrypt the string in parameter
	  * @param str the string to decrypt
	  * @return the decrypted string
	  */
	public String decrypt(String str) {
         try {
             byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
             byte[] utf8 = dcipher.doFinal(dec);
             return new String(utf8, "UTF-8");
         } catch (Exception e) {
         }
         return null;
     }
}
