package samples.designpatterns.command;

import java.util.concurrent.TimeUnit;

public class BuildProject implements Action {

	private final Project project;
	private Thread executorThread;

	public BuildProject(Project project) {
		this.project = project;
	}

	@Override
	public void perform() {
		// Build the project with dependencies here.
		if (project.getDependents() == null)
			return;

		Runnable r = new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Building Dependencies..");
					BuildProject.this.project.getDependents().stream()
							.forEach(Project::build);
					System.out.println("Building Depdendeices completed");

					TimeUnit.SECONDS.sleep(5);

					BuildProject.this.project.build();
				} catch (InterruptedException e) {

					System.err.println("Task cancelled");
				}
			}
		};
		this.executorThread = new Thread(r);
		this.executorThread.start();

	}

	@Override
	public void cancel() {
		this.executorThread.interrupt();
	}

	@Override
	public String toString() {
		return this.project.toString();
	}

}
