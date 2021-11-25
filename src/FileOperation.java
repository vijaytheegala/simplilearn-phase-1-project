import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

public class FileOperation{

	private String fileName;
	
	public FileOperation() {
		
	}
	
	public FileOperation(String fileNam) {
		this.fileName = fileNam;
	}

	public void addFile() {
		Scanner s = new Scanner(System.in);
		FileOutputStream fos = null;
		try {
			File file = new File(System.getProperty("user.dir")+"\\src\\resource");
			boolean mkDir = file.mkdir();
			if(mkDir) {
				System.out.println("Directory is created...");
			}
			else {
				System.out.println("Directory is already created...");
			}
			fos = new FileOutputStream(file+"\\"+fileName, true);
	        System.out.println("When you give >e and press enter, your file writing process will be end.");
	        System.out.println("Now press enter to write a file...");
	        s.nextLine();
	        String fileStr = null;
	        s.useDelimiter(">e");
	        while(true) {
	        	fileStr = s.next();
	        	fos.write(fileStr.getBytes());
	        	break;
	        }
	        System.out.println("File is written successfully...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void serachFile() {
		File file = new File(System.getProperty("user.dir")+"\\src\\resource\\");
		File fileList[] = file.listFiles();
		boolean flag = false;
		for(File getFileName : fileList) {
			if(getFileName.getName().equals(fileName)) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("File is available");
		}
		else {
			System.out.println("File is not found");
		}
	}

	public void deleteFile() {
		File file = new File(System.getProperty("user.dir")+"\\src\\resource\\");
		File fileList[] = file.listFiles();
		boolean flag = false;
		for(File getFileName : fileList) {
			if(getFileName.getName().equals(fileName)) {
				getFileName.delete();
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("File is deleted successfully");
		}
		else {
			System.out.println("File is not found");
		}
	}

	public void retrieveFileName() {
		File file = new File(System.getProperty("user.dir")+"\\src\\resource");
		String fileNames[] = null;
		if(file.isDirectory()) {
			fileNames = file.list();
		}
		else {
			System.out.println("Not a directory");
		}
		System.out.println("****************** All the Files ******************");
		//Arrays.sort(fileNames);
		fileNames = sortFileInAscendingOrd(fileNames);
		for(String fileName : fileNames) {
			System.out.println(fileName);
		}
	}

	private String[] sortFileInAscendingOrd(String fileNames[]) {
		for(int i=0; i<fileNames.length; i++) {
			for(int j=0; j<fileNames.length; j++) {
				if(fileNames[j].compareToIgnoreCase(fileNames[i])>0) {
					String temp = fileNames[j];
					fileNames[j] = fileNames[i];
					fileNames[i] = temp;
				}
			}
		}
		return fileNames;
	}
}
