package samples.designpatterns.abstractfactory;

public class StoreFactory {

	private StoreFactory() {
	}

	public XMLFileFactory getXMLFileFactory() {
		return XMLFileFactory.INSTANCE;
	}

	public CSVFileFactory getCSVFileFactory() {
		return CSVFileFactory.INSTANCE;
	}

}
