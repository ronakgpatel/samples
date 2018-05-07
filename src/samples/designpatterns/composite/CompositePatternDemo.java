package samples.designpatterns.composite;

import java.util.stream.IntStream;

public class CompositePatternDemo {
	public static void main(String[] args) {

		final Classroom classRoom = new ClassroomImpl();

		IntStream.range(1, 11).mapToObj(String::valueOf).map(str -> new Student(str, str)).forEach(classRoom::add);
		System.out.println(classRoom);
	}
}
