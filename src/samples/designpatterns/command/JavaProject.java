package samples.designpatterns.command;

import java.util.Arrays;
import java.util.List;

public class JavaProject implements Project {

	private final String name;

	public JavaProject(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public List<Project> getDependents() {
		return Arrays.asList(new JavaProject("JavaAPI"),
				new JavaProject("JavaExtensions"));
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public void build() {
		System.out.println("Building.... " + name);
	}

}
