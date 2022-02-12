package telran.io.service;

import telran.view.InputOutput;

public interface DirectoryFilesCopy {
	void displayDirectoryContent(InputOutput io, int maxDepth, String directoryPath);
	long copyFiles(String pathFileSrc, String pathFileDest, boolean flOverwrite);
}
