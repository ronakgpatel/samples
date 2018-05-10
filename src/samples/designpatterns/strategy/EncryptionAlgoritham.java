package samples.designpatterns.strategy;

public interface EncryptionAlgoritham {
	public byte[] encrypt(byte[] data);
}
