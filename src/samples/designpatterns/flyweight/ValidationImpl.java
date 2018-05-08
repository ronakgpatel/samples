package samples.designpatterns.flyweight;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValidationImpl implements Validator {
	private List<Object> dataForValidation;

	public ValidationImpl(int version) {
		dataForValidation = IntStream.range(0, 10_000_000).mapToObj(String::valueOf)
				.collect(Collectors.toList());
		System.out.println("Validator with version : " + version + " created successfully.");
	}

	@Override
	public boolean validate(Data<?> externalData) {
		return dataForValidation.containsAll(externalData.getData());
	}

}
