package simplilearn.assessments;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {
	static final String ERROR_STRING = "SOME ERROR OCCURED..!!";
	static final String PATH_STRING = "D:\\simplyJavaPlayground";

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int opt;
		do {
			displayMenu();
			System.out.println("     >> Choose from above options");
			opt = Integer.parseInt(scan.nextLine());
			switch (opt) {
			case 1:
				listFiles();
				break;
			case 2:
				searchFiles();
				break;
			case 3:
				addFile();
				break;
			case 4:
				deleteAllFiles();
				break;
			case 5:
				System.out.println("Program exited..!!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid selection...!!");
			}
		} while (opt > 0);
		scan.close();
	}

	public static void displayMenu() {
		System.out.println("*************************************");
		System.out.println("       Welcome to LOCKEDME App");
		System.out.println("\t   by MOHIT TOMAR");
		System.out.println("*************************************");
		System.out.println("\t1. List Files");
		System.out.println("\t2. Search File");
		System.out.println("\t3. Add File");
		System.out.println("\t4. Delete File");
		System.out.println("\t5. Quit");
	}

	public static void addFile() throws IOException {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter file name");
			String fileName = scan.nextLine();
			File file = new File(fileName);
			if (file.createNewFile()) {
				System.out.println("File has been created successfully");
			} else {
				System.out.println("File exists already");
			}
			scan.close();

		} catch (Exception ex) {
			System.out.println("Some error has occured");
		}

	}

	public static void listFiles() {
		try {
			File folder = new File(PATH_STRING);
			File[] listOfFiles = folder.listFiles();
			System.out.println("\t------- FILES START ------- ");
			if (listOfFiles.length == 0) {
				System.out.println("No Files Exist");
			} else {
				for (var l : listOfFiles) {
					System.out.println("\t\t" + l.getName());
				}
			}
			System.out.println("\t-------- FILES END --------\n");
		} catch (Exception Ex) {
			System.out.println(ERROR_STRING);
		}

	}

	public static void searchFiles() {
		Scanner obj = new Scanner(System.in);
		try {
			String fileName;
			System.out.println("Enter the file name to be Searched");
			fileName = obj.nextLine();

			File folder = new File(PATH_STRING);
			File[] listOfFiles = folder.listFiles();
			LinkedList<String> filenames = new LinkedList<String>();

			for (var l : listOfFiles) {
				filenames.add(l.getName());
			}
			if (filenames.contains(fileName)) {
				System.out.println("File is available");
			} else {
				System.out.println("File is not available");
			}

		} catch (Exception Ex) {
			System.out.println(ERROR_STRING);
		} finally {
			obj.close();
		}
	}

	public static void deleteAllFiles() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the file name to be deleted");
			String fileName = sc.nextLine();
			File file = new File(PATH_STRING + "\\" + fileName);
			if (file.exists()) {
				file.delete();
				System.out.println("File delelted Successfully ");

			} else {
				System.out.println("File does not exists");
			}

		} catch (Exception Ex) {
			System.out.println(ERROR_STRING);
		} finally {
			sc.close();
		}
	}
}
