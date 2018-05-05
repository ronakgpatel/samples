package samples.designpatterns.abstractfactory;

public class XMLFile implements StoreFile {
	public XMLFile(int version) {
		System.out.println("XML File Created with version : "+ version);
	}
}
