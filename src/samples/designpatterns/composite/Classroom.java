package samples.designpatterns.composite;

import java.util.List;

public interface Classroom {
	public void add(Student s);

	public void remove(Student s);

	public List<Student> getAll();
}
