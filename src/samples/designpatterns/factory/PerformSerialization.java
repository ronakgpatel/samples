package samples.designpatterns.factory;

import samples.designpatterns.factory.ApplicationSerializerFactory.DBSerializer;
import samples.designpatterns.factory.ApplicationSerializerFactory.NetworkSerializer;

public class PerformSerialization {

	public void doSerialization(Object data, String type) {
		// type parameter represents the type of the
		// serialization to be done. e.g. It can be
		// Network,File,DB,XML or any other supported mechanism

		if ("Network".equals(type)) {
			Serializer nwSerializer = new NetworkSerializer();
			nwSerializer.serialize("send it!");
		} else if ("DB".equals(type)) {
			Serializer dbSerializer = new DBSerializer();
			dbSerializer.serialize("save it!");
		}

	}

	public void doSerialization1(Object data, String type) {
		// type parameter represents the type of the
		// serialization to be done. e.g. It can be
		// Network,File,DB,XML or any other supported mechanism

		SerlizationFactory factory = ApplicationSerializerFactory.getInstance();

		Serializer nwSerializer = factory.getSerializer("Network");
		nwSerializer.serialize("send it!");

		Serializer dbSerializer = factory.getSerializer("DB");
		dbSerializer.serialize("save it!");

	}

}
