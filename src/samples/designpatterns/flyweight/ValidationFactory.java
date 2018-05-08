package samples.designpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ValidationFactory {

	private static final Map<Integer, Validator> validatorsMap = new HashMap<>();
	private static final ValidationFactory INSTANCE = new ValidationFactory();

	private ValidationFactory() {
	}

	public static ValidationFactory getInstance() {
		return INSTANCE;
	}

	public Validator getValidator(int version) {
		Validator validator = validatorsMap.get(version);
		if (validator == null) {
			validator = createValidator(version);
			validatorsMap.put(version, validator);
		}
		return validator;
	}

	private Validator createValidator(int version) {
		return new ValidationImpl(version);
	}

}
