package samples.designpatterns.factory;

public interface SerlizationFactory {
	Serializer getSerializer(String type);
}
