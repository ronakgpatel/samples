package samples.designpatterns.command;

public class CommandDemo {
	public static void main(String[] args) {
		Project project = new JavaProject("LocalProject");
		BuildProject buildProject = new BuildProject(project);
		CancelBuild cancelBuild = new CancelBuild(buildProject);
		buildProject.perform();
		cancelBuild.perform();

	}
}
