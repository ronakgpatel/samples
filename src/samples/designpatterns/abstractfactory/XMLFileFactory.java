package samples.designpatterns.abstractfactory;

public class XMLFileFactory implements FileFactory {
	public static XMLFileFactory INSTANCE = new XMLFileFactory();
	private XMLFileFactory() {

	}

	public StoreFile createFile(int version) {
		return new XMLFile(version);
	}

}
