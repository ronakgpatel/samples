package samples.designpatterns.flyweight;

import java.util.concurrent.TimeUnit;

/**
 * Demo Class
 */
public class FlyweightPatternDemo {

	public static void main(String[] args) {
		validateDataForVersion(10, new MockedData(10));
		validateDataForVersion(10, new MockedData(10));
		validateDataForVersion(11, new MockedData(11));
		validateDataForVersion(10, new MockedData(10));

	}

	private static boolean validateDataForVersion(int version, Data<String> data) {
		long start = System.nanoTime();
		ValidationFactory factory = ValidationFactory.getInstance();
		Validator validator = factory.getValidator(version);
		boolean valid = validator.validate(data);
		System.out.println(
				"Time taken for Validation("+version+") : " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start) + " ms");
		return valid;
	}
}
