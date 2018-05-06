package samples.designpatterns.decorator;

public class HeadLightDecorator implements Light {
	private Light baseLight;

	public HeadLightDecorator(Light light) {
		this.baseLight = light;
	}

	@Override
	public void glow() {
		System.out.print("Double ");
		baseLight.glow();
		System.out.println();
	}
}
