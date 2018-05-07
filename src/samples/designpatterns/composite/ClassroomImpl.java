package samples.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This is the composite implementation of 
 * interface @link  {@link Classroom} interface.
 * Note that here is must contain reference to all
 * those objects which it contains(e.g. Students).
 * It also should provide the standard methods for
 * add or removing the elements.
 *
 */
public class ClassroomImpl implements Classroom {

	private List<Student> _listOfStudents;

	public ClassroomImpl() {
		_listOfStudents = new ArrayList<>();
	}

	@Override
	public void add(Student s) {
		Objects.requireNonNull(s);
		_listOfStudents.add(s);

	}

	@Override
	public void remove(Student s) {
		_listOfStudents.remove(s);

	}

	@Override
	public List<Student> getAll() {
		return _listOfStudents;
	}

	@Override
	public String toString() {
		return "ClassroomImpl [_listOfStudents=" + _listOfStudents + "]";
	}

}
