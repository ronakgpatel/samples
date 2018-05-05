package samples.designpatterns.abstractfactory;

public class CSVFile implements StoreFile {
	public CSVFile(int version) {
		System.out.println("CSV File Created with version : "+ version);
	}
}
