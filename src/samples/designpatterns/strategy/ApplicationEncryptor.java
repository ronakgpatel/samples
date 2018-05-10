package samples.designpatterns.strategy;

public class ApplicationEncryptor {
	public byte[] encrypt(byte[] data, EncryptionAlgoritham algo) {
		return algo.encrypt(data);
	}
}
