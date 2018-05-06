package samples.designpatterns.decorator;

public class DecoratorDemo {
	public static void main(String[] args) {
		Light light = new NormalLight();
		RedLightDecorator redLightDecorator = new RedLightDecorator(light);
		redLightDecorator.glow();
		HeadLightDecorator headLightDecorator = new HeadLightDecorator(light);
		headLightDecorator.glow();
		HeadLightDecorator redHeadLightDecoratior = new HeadLightDecorator(redLightDecorator);
		redHeadLightDecoratior.glow();
	}
}
