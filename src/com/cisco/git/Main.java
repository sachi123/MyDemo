import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class Main {

	private static final String REMOTE_URL = "....git"; // a URL

	public static void main(String[] args) throws IOException, GitAPIException {

		File localPath = File.createTempFile("TestGitRepository", "");
		localPath.delete();

		System.out.println("Cloning from " + REMOTE_URL + " to " + localPath);
		Git.cloneRepository().setURI(REMOTE_URL).setDirectory(localPath).call();

		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		Repository repository = builder.setGitDir(localPath).readEnvironment()
				.findGitDir().build();

		Status status = new Git(repository).status().call();
		System.out.println("Added: " + status.getAdded());
		System.out.println("Changed: " + status.getChanged());
		System.out.println("Conflicting: " + status.getConflicting());
		System.out.println("ConflictingStageState: "
				+ status.getConflictingStageState());
		System.out.println("IgnoredNotInIndex: "
				+ status.getIgnoredNotInIndex());
		System.out.println("Missing: " + status.getMissing());
		System.out.println("Modified: " + status.getModified());
		System.out.println("Removed: " + status.getRemoved());
		System.out.println("Untracked: " + status.getUntracked());
		System.out.println("UntrackedFolders: " + status.getUntrackedFolders());

		repository.close();
	}

}