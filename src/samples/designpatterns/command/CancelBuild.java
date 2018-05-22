package samples.designpatterns.command;

public class CancelBuild implements Action {

	private BuildProject buildProjectAction;

	public CancelBuild(BuildProject buildProject) {
		this.buildProjectAction = buildProject;
	}

	@Override
	public void perform() {
		buildProjectAction.cancel();
	}

	@Override
	public void cancel() {
		buildProjectAction.perform();
	}

}
