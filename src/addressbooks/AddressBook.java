package addressbooks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook implements InAddressBook {
	List<Contacts> ContactsList = new ArrayList<>();

	public void addNewContact() {
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter firstname of the person: ");
		String firstname = s1.nextLine();
		System.out.println("Enter lastname of the person: ");
		String lastname = s1.nextLine();
		System.out.println("Enter the city name of the person:");
		String city = s1.nextLine();
		System.out.println("Enter the state of the person");
		String state = s1.nextLine();
		System.out.println("Enter phone number of the person");
		long phone = s1.nextLong();
		System.out.println("Ente the zip code of the person");
		int zip = s1.nextInt();
		Contacts contacts = new Contacts(firstname, lastname, city, state, phone, zip);
		ContactsList.add(contacts);
	}

	public void editContact() {
		int num = 0;
		Scanner s3 = new Scanner(System.in);
		System.out.println("Enter first name  of a person to edit details:");
		String name = s3.next();
		for (Contacts contact : ContactsList) {
			if (name.equalsIgnoreCase(contact.firstName)) {
				while (num == 0) {
					System.out.println(
							"Enter an option to edit:\n" + "1.Name\n " + "2.phone number\n" + "3.address\n" + "4.quit");
					int value = s3.nextInt();
					Scanner s4 = new Scanner(System.in);
					switch (value) {
					case 1:
						System.out.println("Enter new firstname: ");
						String firstname = s4.next();
						contact.setFirstName(firstname);
						System.out.println("Enter new lastname: ");
						String lastname = s4.next();
						contact.setFirstName(lastname);
						System.out.println(contact.toString());
					case 2:
						System.out.println("Enter new phonenumber: ");
						long phonenumber = s4.nextLong();
						contact.setPhone(phonenumber);
						System.out.println(contact.toString());
						break;
					case 3:
						System.out.println("Enter new city: ");
						String city = s4.nextLine();
						contact.setCity(city);
						System.out.println("Enter new state:");
						String state = s4.nextLine();
						contact.setState(state);
						System.out.println("Enter new zip code:");
						int zip = s4.nextInt();
						contact.setZip(zip);
						break;
					case 4:
						num = 1;
						break;
					default:
						System.out.println("wrong option entered");
						break;
					}
				}
			}
		}
	}

	public void deleteContact() {
		Scanner s3 = new Scanner(System.in);
		int num = 1;
		for (Contacts contact : ContactsList) {
			System.out.println(contact.toString());
		}
		System.out.println("Enter first name of a person to delete person:");
		String name = s3.next();
		for (Contacts contact : ContactsList) {
			if (name.equalsIgnoreCase(contact.firstName)) {
				Scanner s4 = new Scanner(System.in);
				System.out.println("enter 1 to confirm delete: ");
				int confirmation = s4.nextInt();
				if (confirmation == 1) {
					ContactsList.remove(contact);
					break;
				} else
					break;
			}
		}
	}

	public void writeToFile() {
		File file = new File("D:\\javacsvfiles");
		String[] filenamesD = file.list();
		if (filenamesD == null)
			System.out.println("File with the name does not exists");
		else {
			for (int i = 0; i < filenamesD.length; i++) {
				String filename = filenamesD[i];
				System.out.println(filename);
			}
		}
		System.out.println("Enter the file name, data to be saved in: ");
		Scanner input = new Scanner(System.in);
		String filename = input.nextLine();
		BufferedReader filereader = null;
		try {
			filereader = new BufferedReader(new FileReader("D:\\javacsvfiles\\" + filename + ".csv"));
			String line = "";

			while ((line = filereader.readLine()) != null) {
				for (Contacts cell : ContactsList) {
					System.out.print(cell + "\t");
					System.out.println();
				}
			}
		} catch (Exception e) {
			System.out.print(e);
		}
		try {
			filereader.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		FileWriter file_writer = null;
		BufferedWriter filebuffer = null;
		PrintWriter fileprinter = null;
		try {
			file_writer = new FileWriter("D:\\javacsvfiles\\" + filename + ".csv", true);
			filebuffer = new BufferedWriter(file_writer);
			fileprinter = new PrintWriter(filebuffer);
			for (Contacts cell : ContactsList) {
				fileprinter.print(cell.getFirstName());
				fileprinter.print(",");
				fileprinter.print(cell.getLastName());
				fileprinter.print(",");
				fileprinter.print(cell.getPhone());
				fileprinter.print(",");
				fileprinter.print(cell.getZip());
				fileprinter.print(",");
				fileprinter.print(cell.getCity());
				fileprinter.print(",");
				fileprinter.print(cell.getState());
				fileprinter.print(",");
				fileprinter.println();
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				file_writer.flush();
				filebuffer.flush();
				fileprinter.flush();
				file_writer.close();
				filebuffer.close();
				fileprinter.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
