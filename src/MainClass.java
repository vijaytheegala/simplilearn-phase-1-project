import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws AlreadyClosedExceptioin {
		mainMenu();
	}

	public static void mainMenu() throws AlreadyClosedExceptioin {
		char c;
		int input = 0;
		Scanner sc = new Scanner(System.in);
		Scanner charScan = new Scanner(System.in);
		do {
			System.out.println("**************************************************");
			System.out.println("LockedMe.com");
			System.out.println("**************************************************");
			System.out.println("Developer Details");
			System.out.println("Developer Name: 	Milan H. Bhatt");
			System.out.println("Developer Email:	milan.bhatt@gmail.com");
			System.out.println();
			System.out.println("**************************************************");
			System.out.println();
			System.out.println("Main Menu");
			System.out.println("1. Retrieve File Names");
			System.out.println("2. File Operations");
			System.out.println("3. Exit");
			try {
				input = ReadInput.getInstance().nexttInt();
			}catch(InputMismatchException e) {
				System.out.println("This is not a valid input.");
			}
			
			switch(input) {
				case 1: 
						FileOperation fo = new FileOperation();
						fo.retrieveFileName();
						break;
					
				case 2: 
					FileOperationMenu fm = new FileOperationMenu();
					fm.showMenu();
					break;
					
				case 3:
					System.out.println("Application is closing...");
					System.exit(0);
					break;
						
				default:
					System.out.println("Please enter valid choice");
					ReadInput.getInstance().makeReadInputNull();
					break;
			}
			System.out.println();
			System.out.println("If you want to continue press Y/y, otherwise press any other character to exit");
			c = ReadInput.getInstance().next().charAt(0);
		}while(c == 'Y' || c == 'y');

	}
}