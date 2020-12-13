package addressbooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
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
					System.out.println("Enter an option to edit:\n" + "1.phone number\n" + "2.address\n" + "3.quit");
					int value = s3.nextInt();
					Scanner s4 = new Scanner(System.in);
					switch (value) {
					case 1:
						System.out.println("Enter new phonenumber: ");
						long phonenumber = s4.nextLong();
						contact.setPhone(phonenumber);
						System.out.println(contact.toString());
						break;
					case 2:
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
					case 3:
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

		public static void main(String args[]) {
		Scanner s2 = new Scanner(System.in);
		AddressBook addressbook = new AddressBook();
		int value = 1;
		while (value == 1) {
			System.out.println("Enter 0: to Quit1\n"+ "1:add contacts\n"+ "2.edit contacts ");
			int choice = s2.nextInt();
			switch (choice) {
			case 0:
				value=0;
				break;
			case 1:
				addressbook.addNewContact();
				break;
			case 2:
				addressbook.editContact();
				break;
			default:
				System.out.println("You Entered wrong Option");
			}
		}
	}
}
