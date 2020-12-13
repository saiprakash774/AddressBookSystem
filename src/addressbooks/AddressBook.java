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

	public static void main(String args[]) {
		Scanner s2 = new Scanner(System.in);
		AddressBook addressbook = new AddressBook();
		int value=1;
		while(value==1) {
		System.out.println("Enter 1 to add contacts and 2 to Quit");
		int choice = s2.nextInt();
		switch (choice) {
		case 1:
				addressbook.addNewContact();
				break;
		case 2:	value=0;
				break;
		default:
				System.out.println("You Entered wrong Option");
		}
	}
}
}
