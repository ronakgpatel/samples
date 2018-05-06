package samples.designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class VeryBigObject {
	private final String data;

	public VeryBigObject(String s) {
		this.data = s;
	}

	public VeryBigObject(VeryBigObject o) {
		this.data = o.data;
	}

	@Override
	public String toString() {
		return data;
	}
}

class DataHolder implements Cloneable {
	private List<VeryBigObject> dataFromDB = new ArrayList<>();

	public DataHolder() {
	}

	public void add(VeryBigObject a) {
		dataFromDB.add(a);
	}

	/**
	 * Copy constructor. Copy constructor is the idea of taking the type
	 * of the arguments that of the object. In this case, DataHolder.
	 * @param sourceData
	 */
	public DataHolder(DataHolder sourceData) {
		for (VeryBigObject obj : sourceData.dataFromDB) {
			dataFromDB.add(new VeryBigObject(obj));
		}
	}

	/**
	 * Method that clones the existing data into new data(deep cloning).
	 * Deep cloning would make sure that all the objects in the list
	 * are also cloned and copied in the new object. Therefore making
	 * sure that changes in the new object would not impact on the
	 * origial loaded data.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		DataHolder clonedData = new DataHolder();
		for (VeryBigObject obj : this.dataFromDB) {
			clonedData.dataFromDB.add(new VeryBigObject(obj));
		}
		return clonedData;
	}

	@Override
	public String toString() {
		return dataFromDB.toString();
	}
}

public class PrototypeDemo {
	private static DataHolder loadData() {
		// Load the data from database here.
		DataHolder data = new DataHolder();
		IntStream.rangeClosed(1, 5).mapToObj(String::valueOf).map(VeryBigObject::new).forEach(data::add);
		return data;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		DataHolder loadedData = loadData();
		System.out.println("Data Loaded : " + loadedData);
		DataHolder dataForModifiation = new DataHolder(loadedData);
		dataForModifiation.add(new VeryBigObject("Modified"));
		System.out.println("Modified Data : " + dataForModifiation);

		DataHolder clonedData = (DataHolder) loadedData.clone();
		clonedData.add(new VeryBigObject("ClonedData"));
		System.out.println("Cloned Data :  " + clonedData);
		System.out.println("Data Loaded : " + loadedData);
	}
}
