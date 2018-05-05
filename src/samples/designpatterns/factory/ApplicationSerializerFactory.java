package samples.designpatterns.factory;

import java.util.Objects;

public class ApplicationSerializerFactory implements SerlizationFactory {

	private static SerlizationFactory INSTANCE = new ApplicationSerializerFactory();

	private ApplicationSerializerFactory() {
	}

	public static SerlizationFactory getInstance() {
		return INSTANCE;
	}

	public static class NetworkSerializer implements Serializer {
		@Override
		public void serialize(Object data) {
			System.out.println("Serializing over network");
		}
	}

	public static class DBSerializer implements Serializer {
		@Override
		public void serialize(Object data) {
			System.out.println("Serializing in Database");
		}
	}

	@Override
	public Serializer getSerializer(String type) {
		Objects.requireNonNull(type);
		switch (type) {
		case "Netowrk":
			return new NetworkSerializer();//Any new NetworkSerializer can be replaced in single place
		case "DB":
			return new DBSerializer();
		default:
			throw new UnsupportedOperationException(type + " serialization is not supported yet.");
		}
	}

}
