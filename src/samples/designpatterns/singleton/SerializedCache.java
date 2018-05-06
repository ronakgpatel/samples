package samples.designpatterns.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializedCache implements Serializable {
	private static final long serialVersionUID = 1L;
	private SerializedCache() {
	}

	private static SerializedCache INSTANCE = new SerializedCache();

	public static SerializedCache getInstance() {
		return INSTANCE;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException {
		System.out.println("Reading object from serialized data");
		//Here either you can create an object and assign to INSTANCE
		// if you want to initialized the object with data from the InputStream
	}

	protected Object readResolve() {
		return getInstance();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		SerializedCache instanceOne = SerializedCache.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("cache.dat"));
		out.writeObject(instanceOne);
		out.close();

		// deserialize from file to object
		ObjectInput in = new ObjectInputStream(new FileInputStream("cache.dat"));
		SerializedCache instanceTwo = (SerializedCache) in.readObject();
		in.close();

		System.out.println("Serialized Cache(First) " + instanceOne.hashCode());
		System.out.println("Serialized Cache(Second) " + instanceTwo.hashCode());

	}
}
