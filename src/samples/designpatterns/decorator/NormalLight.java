package samples.designpatterns.decorator;

/**
 *This is base class implementation for the
 *{@link Light} interface. There is no restriction
 *that this must be used for decoration. Any {@link Light}
 *implementation can be used.
 */
public class NormalLight implements Light {
	@Override
	public void glow() {
		System.out.print("Glowing");
	}
}
