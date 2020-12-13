package addressbooks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class AddressBookManager implements InAddressBookManager {
	public String filename;
	AddressBook addressbook = new AddressBook();

	public void newAddressBook() {
		System.out.println("Enter name of AddressBook: ");
		Scanner addressbookname = new Scanner(System.in);
		filename = addressbookname.nextLine();
		try {
			File file = new File("D:\\javacsvfiles\\" + filename + ".csv");
			if (file.createNewFile()) {
				System.out.println("AddressBook Created");
			} else {
				System.out.println("AddressBook Name already exists");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void openAddressBook() {

		Scanner s1 = new Scanner(System.in);
		Scanner addressbookobj = new Scanner(System.in);
		File file = new File("D:\\javacsvfiles");
		String[] filenames = file.list();
		if (filenames == null)
			System.out.println("File with name does not exists");
		else {
			for (int i = 0; i < filenames.length; i++) {
				String filename = filenames[i];
				System.out.println(filename);
			}
		}
		System.out.println("Enter name of AddressBook to open: ");
		String addressbookname = addressbookobj.next();
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:\\javacsvfiles\\" + filename + ".csv"));
			while ((line = br.readLine()) != null) {
				String[] s = line.split(",");
				System.out.println("FirstName:" + s[0] + "\nLastName:" + s[1] + "\nPhone:" + s[2] + "\nZipCode:" + s[3]
						+ "\nCity:" + s[4] + "\nState:" + s[5]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	
		int value = 1;
		while(value == 1) {
			System.out.println("Enter\n"+"0: to Quit\n" + "1:add contacts\n" + "2.edit contacts\n" + "3.delete contact");
			s1=new Scanner(System.in);
			int choice = s1.nextInt();
			switch (choice) {
			case 0:
				value = 0;
				break;
			case 1:
				addressbook.addNewContact();
				break;
			case 2:
				addressbook.editContact();
				break;
			case 3:
				addressbook.deleteContact();
			default:
				System.out.println("You Entered wrong Option");
				break;
			}
		}
	}
	

	public void saveAddressBook() {
		addressbook.writeToFile();
	}

	public void saveAsAddressBook() {
		addressbook.writeToFile();
		System.out.println("SuccessFully saved the Data");
		System.out.println("Enter the file-name to be renamed: ");
		Scanner ip = new Scanner(System.in);
		String fileoldname = ip.nextLine();
		File fileold = new File("D:\\javacsvfiles\\" + fileoldname + ".csv");
		System.out.println("Enter the new-name of the file: ");
		String filenewname = ip.nextLine();
		File filenew = new File("D:\\javacsvfiles\\" + filenewname + ".csv");
		boolean b = fileold.renameTo(filenew);
		if (b) {
			System.out.println("Saved to => " + filenew + " file");
		}
	}
}
