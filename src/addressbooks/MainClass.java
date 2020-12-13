package addressbooks;

import java.util.Scanner;

public class MainClass {
	private static Scanner s;

	public static void main(String[] args) {
		AddressBookManager addressbookmanager = new AddressBookManager();
		int value = 1;
		while (value == 1) {
			System.out.println(
					"Enter one of the following option to perform oeration on Address:\n" + "1.New Address Book\n"
							+ "2.Open Address Book\n" + "3.Save Address Book\n" + "4.Saveas Address Book\n" + "5.Quit");
			s = new Scanner(System.in);
			int num = s.nextInt();
			switch (num) {
			case 1:
				addressbookmanager.newAddressBook();
				break;

			case 2:
				addressbookmanager.openAddressBook();
				break;

			case 3:
				addressbookmanager.saveAddressBook();
				break;

			case 4:
				addressbookmanager.saveAsAddressBook();
				break;
			case 5:
				value = 0;
				break;
			default:
				System.out.println("Entered Wrong option");
				break;
			}
		}
	}
}
