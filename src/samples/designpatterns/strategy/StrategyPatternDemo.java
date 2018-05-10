package samples.designpatterns.strategy;

public class StrategyPatternDemo {

	//Client Class
	public static void main(String[] args) {
		ApplicationEncryptor encryptor = new ApplicationEncryptor();
		final String data = "dataFromSource";
		final String strategy = args[1];
		encryptor.encrypt(data.getBytes(), getEncryptionAlgoritham(args[1]));
	}

	private static EncryptionAlgoritham getEncryptionAlgoritham(String strategy) {
		//Clients must have the prior knowlege of all the patterns available and
		//possible to configure
		final String externalKey = "EXTERNAL_KEY";
		if ("internal".equalsIgnoreCase(strategy))
			return new InteralEncryptionAlgo();
		else if ("external".equalsIgnoreCase(strategy))
			return new ExternalEncryptionAlgo(externalKey);
		throw new Error(strategy + " not supported");
	}

}
