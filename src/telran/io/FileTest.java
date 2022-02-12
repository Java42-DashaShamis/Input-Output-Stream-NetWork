package telran.io;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Arrays;
class FileTest {
	File nodeFile = new File("file.txt");
	File nodeDir = new File("dir1/dir2");
	@BeforeEach
	void setUp() throws Exception {
		nodeFile.delete();
		nodeDir.delete();
	}

	@Test
	void testInitial( ) throws IOException {
		
		assertFalse(nodeFile.exists());
		assertFalse(nodeDir.exists());
		nodeFile.createNewFile();
		nodeDir.mkdirs();
		assertTrue(nodeFile.exists());
		assertTrue(nodeDir.exists());
		assertTrue(nodeFile.isFile());
		assertTrue(nodeDir.isDirectory());
		File nodeFile1 = new File("dir1/file1.txt");
		nodeFile1.createNewFile();
		File nodeDir1 = new File("dir1");
		System.out.println(nodeDir1.getName());
		Arrays.stream(nodeDir1.listFiles()).forEach(n -> System.out.printf("  %s: %s\n"
				,n.getName(), n.isDirectory() ? "dir" : "file"));
		
		
	}
	
	@Test
	void copyTest() throws IOException {
		InputStream is = new FileInputStream("srcFile.txt");
		File destFile = new File("destFile.txt");
		System.out.printf("file %s exists : %s\n", destFile.getName(), destFile.exists());
		OutputStream os = new FileOutputStream("destFile");
		byte[] buffer = new byte[is.available()]; //only for small files
		is.read(buffer);
		os.write(buffer);
		is.close();
		os.close();
	}

}
