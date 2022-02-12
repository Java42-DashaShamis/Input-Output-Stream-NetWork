package telran.io.service;

import java.io.File;
import java.util.Arrays;

import telran.view.InputOutput;

public class DirectoryFilesCopyImpl implements DirectoryFilesCopy {
	
	private static int maxDepth;

	@Override
	public void displayDirectoryContent(InputOutput io, int maxDepth, String directoryPath) {
		this.maxDepth = maxDepth;
		File directoryNode = new File(directoryPath);
		/* V.R. It is redundant check.
		 * isDirectory() false in 2 cases:
		 *  1. Node doesn't exist
		 *  2. Node exists, but it isn't directory 
		 */
		if(directoryNode.exists()) {
			displayContent(io, maxDepth, directoryNode);
		}
	}

	private void displayContent(InputOutput io, int level, File directoryNode) {
		
		io.writeObjectLine(" ".repeat(maxDepth-level) + directoryNode.getName() + ":" + (directoryNode.isDirectory() ? "dir" : "file"));
		
		/* V.R. directoryNode is directory
		 * So listFiles() cannot return null.
		 */
		if(level!=0 && directoryNode.isDirectory() && directoryNode.listFiles()!=null) {
			Arrays.stream(directoryNode.listFiles()).forEach(n -> displayContent(io, level-1, n));
		}
	}

	@Override
	public long copyFiles(String pathFileSrc, String pathFileDest, boolean flOverwrite) {
		// TODO Auto-generated method stub
		return 0;
	}

}
