
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadInput {

	private Scanner scan;
	private static ReadInput read = null;
	private boolean alreadyClosed;

	private ReadInput() {
		alreadyClosed = false;
		scan = new Scanner(System.in);
	}

	public static ReadInput getInstance() {
		if(read == null) {
			read = new ReadInput();
		}
		return read;
	}

	public int nexttInt() throws AlreadyClosedExceptioin {
		if(!alreadyClosed) {
			return scan.nextInt();
		}
		throw new AlreadyClosedExceptioin("Inputstream is closed");
	}

	public String next() {
		if(!alreadyClosed) {
			return scan.next();
		}
		try {
			throw new AlreadyClosedExceptioin("Inputstream is closed");
		} catch (AlreadyClosedExceptioin e) {
			e.printStackTrace();
		}
		return null;
	}

	public void close() {
		alreadyClosed = true;
		scan.close();
	}

	public void makeReadInputNull() {
		read = null;
	}
}
