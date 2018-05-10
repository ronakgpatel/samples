package samples.designpatterns.strategy;

import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ExternalEncryptionAlgo implements EncryptionAlgoritham {

	private final byte[] key;

	public ExternalEncryptionAlgo(String key) {
		Objects.requireNonNull(key);
		this.key = key.getBytes();
	}

	@Override
	public byte[] encrypt(byte[] data) {
		try {
			return encryptData(data);
		} catch (Exception e) {
			return null;
		}
	}

	private byte[] encryptData(byte[] plainText) throws Exception {
		SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);

		return cipher.doFinal(plainText);
	}

}
