package telran.io.controller;

import telran.view.ConsoleInputOutput;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;

import java.io.File;
import java.util.ArrayList;

import telran.io.service.DirectoryFilesCopy;
import telran.io.service.DirectoryFilesCopyImpl;

public class DirectoryFilesCopyAppl {
	
	
	private static File nodeDir1 = new File("dir1");
	private static File nodeDir2 = new File("dir1/dir2");
	
	private static String dir = nodeDir1.getName();

	public static void main(String[] args) {
		nodeDir2.mkdirs();
		InputOutput io = new ConsoleInputOutput();
		DirectoryFilesCopy dfc = new DirectoryFilesCopyImpl();
		ArrayList<Item> items = DirectoryFrilesCopyActions.getItems(dfc);
		
		Menu menu = new Menu("File System", items);
		menu.perform(io);

	}

}
