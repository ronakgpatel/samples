package samples.designpatterns.decorator;

/**
 * Now, here is the decorator. 
 * Important Points :
 * 1. It implements {@link Light}
 * 2. It contains {@link Light} instance.
 * 
 * This is because, the {@link RedLightDecorator} must also
 * implement the contract for {@link Light}.
 * However, its not the actual implementation but just decoration. 
 * Therefore another {@link Light} 
 * instance as it instance variable is required which would be
 * decoared with this class.
 */
public class RedLightDecorator implements Light {

	private Light baseLight;

	public RedLightDecorator(Light light) {
		this.baseLight = light;
	}

	@Override
	public void glow() {
		System.out.print("Red ");
		baseLight.glow();
		System.out.println();
	}

}
