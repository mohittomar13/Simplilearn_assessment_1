package simplilearn.assessments;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {
	static final String ERROR_STRING = "SOME ERROR OCCURED..!!";
	static final String PATH_STRING = "D:\simplyJavaPlayground";

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int opt;
		do {
			displayMenu();
			System.out.println("     >> Choose from above options");
			opt = Integer.parseInt(scan.nextLine());
			switch (opt) {
			case 1:
				getAllFiles();
				break;
			case 2:
				addFile();
				break;
			case 3:
				deleteAllFiles();
				break;
			case 4:
				searchFiles();
				break;
			case 5:
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
		System.out.println("\t4. Search File");
		System.out.println("\t2. Add File");
		System.out.println("\t3. Delete File");
		System.out.println("\t5. Quit");
	}

	public static void addFile() throws IOException {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter file name");
			String fileName = scan.nextLine();
			System.out.println("Enter how many lines in the file");
			int linesCount = Integer.parseInt(scan.nextLine());
			FileWriter myWriter = new FileWriter(PATH_STRING + "\\" + fileName);
			for (int i = 1; i <= linesCount; i++) {
				System.out.println("Enter the file line");
				myWriter.write(scan.nextLine() + "\n");
			}
			System.out.println("File has been created successfully");
			myWriter.close();
			scan.close();

		} catch (Exception ex) {
			System.out.println("Some error has occured");
		}

	}

	public static void getAllFiles() {
		try {
			File folder = new File(PATH_STRING);
			File[] listOfFiles = folder.listFiles();
			if (listOfFiles.length == 0) {
				System.out.println("No Files Exist");
			} else {
				for (var l : listOfFiles) {
					System.out.println(l.getName());
				}
			}
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
