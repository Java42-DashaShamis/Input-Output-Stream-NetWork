package telran.io.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import telran.io.service.DirectoryFilesCopy;
import telran.view.InputOutput;
import telran.view.Item;

public class DirectoryFrilesCopyActions {
	private static DirectoryFilesCopy dfc;
	private static ArrayList<Item> items;
	
	private DirectoryFrilesCopyActions() {
		
	}
	public static ArrayList<Item> getItems(DirectoryFilesCopy dfc){
		DirectoryFrilesCopyActions.dfc = dfc;
		if (items == null) {
			items = new ArrayList<>(Arrays.asList(new Item[] {
				Item.of("Display directory content", DirectoryFrilesCopyActions::displayContent),
				Item.of("Copy directory content", DirectoryFrilesCopyActions::copyContent),
				Item.exit()
			})) ;
			
		}
		return items;
	}
	
	private static void displayContent(InputOutput io) {
		// V.R. maxDepth may be (due to requirements) also negative
		int maxdepth = io.readInt("Enter depth from 0");
		String directory = io.readStringPredicate("Enter directory path", "It is not a directory path", str -> new File(str).isDirectory());
		dfc.displayDirectoryContent(io, maxdepth, directory);
	}
	private static void copyContent(InputOutput io) {
		String pathFileSrc = io.readStringPredicate("Enter source file path", "It is not a file path", str -> new File(str).isFile()); 
		/* V.R. pathFileDest may present existing file or present not yet existing.
		 * It cannot be existing directory. So the predicate may look as following:
				str -> {
					File dest = new File(str);
					return dest.isFile() || !dest.exists();
				});
		 * 
		 */
		// 
		String pathFileDest = io.readStringPredicate("Enter destination file path", "It is not a file path", str -> new File(str).isFile()); 
		boolean flOverwrite = io.readString("Overwrite file (Y/N)?") == "Y" ? true : false;
		dfc.copyFiles(pathFileSrc, pathFileDest, flOverwrite);
	}
}
