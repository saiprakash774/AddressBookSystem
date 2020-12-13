package addressbooks;
import java.util.Scanner;
public class AddressBook {
	public static void main(String args[]) {
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
		System.out.println(contacts.toString());
	}

}
