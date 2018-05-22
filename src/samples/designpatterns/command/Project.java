package samples.designpatterns.command;

import java.util.List;

public interface Project {
	List<Project> getDependents();
	void build();
}
