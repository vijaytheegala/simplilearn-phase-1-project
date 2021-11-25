import java.util.InputMismatchException;
import java.util.Scanner;

public class FileOperationMenu {

	public void showMenu() throws AlreadyClosedExceptioin {
		System.out.println("****************************************File Operations****************************************");
		System.out.println("1. Create or Write File");
		System.out.println("2. Search File");
		System.out.println("3. Delete File");
		System.out.println("4. Back To Main Menu");
		
		int choice = 0;
		String fileName;
		Scanner s = new Scanner(System.in);
		try {
			choice = s.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("This is not a valid input.");
		}
		
		switch(choice) {
				case 1:
						System.out.println("Enter File Name :");
						fileName = s.next();
						FileOperation addFile = new FileOperation(fileName);
						addFile.addFile();
						break;
				case 2:
						System.out.println("Enter File Name :");
						fileName = s.next();
						FileOperation searchFile = new FileOperation(fileName);
						searchFile.serachFile();
						break;
				
				case 3:
						System.out.println("Enter File Name :");
						fileName = s.next();
						FileOperation deleteFile = new FileOperation(fileName);
						deleteFile.deleteFile();
						break;
						
				case 4:
						MainClass.mainMenu();
						break;
				
				default:
						System.out.println("Please Enter Valid Choice");
						break;
		}
	}
}
