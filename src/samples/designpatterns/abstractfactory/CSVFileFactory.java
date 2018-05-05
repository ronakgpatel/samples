package samples.designpatterns.abstractfactory;

public class CSVFileFactory implements FileFactory {

	public static CSVFileFactory INSTANCE = new CSVFileFactory();
	private CSVFileFactory() {

	}
	
	@Override
	public StoreFile createFile(int version) {
		return new CSVFile(version);
	}

}
