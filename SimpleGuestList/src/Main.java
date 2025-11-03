import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);
    //Store all guests
    static String[] guests = new String[10];

    public static void main(String[] args) {
        insertTestNames();
        do {
            displayGuests();
            displayMenu();
            int option = getOption();

            if (option == 5) {
                System.out.println("Exiting the library program.......");
                break;
            }
            else if (option == 4) {
                removeGuest();
            }
            else if (option == 1) {
                addGuest();
            }
            else if (option == 2) {
                renameGuests();
            }
            else if (option == 3) {
                insertGuest();
            }
        }
        while (true);
    }

    public static void displayGuests() {
        System.out.println();
        System.out.println();
        System.out.println(" - Guests List -");
        boolean isEmpty = true;
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {
                System.out.println(i + 1 + " " + guests[i]);
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println("The Guest List Is Empty");
        }

        String[] temp = new String[guests.length];
        int ti = 0;
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {
                temp[ti] = guests[i];
                ti++;
            }
        }
        guests = temp;
    }

    public static void displayMenu() {
        System.out.println();
        System.out.println(" - Menu -");
        System.out.println("1 - Add guests");
        System.out.println("2 - Rename a guest");
        System.out.println("3 - Insert a guest");
        System.out.println("4 - Remove guests");
        System.out.println("5 - Exit");
    }

    public static int getOption() {
        System.out.println("\nChoose Option: ");
        int userOption = userInput.nextInt();
        userInput.nextLine();
        return userOption;
    }

    public static void addGuest() {
        System.out.println("Please type Name & Surname of the guest:\n");

        for (int i = 0; i < guests.length; i++) {
            if (guests[i] == null) {
                System.out.println("Guest Name: ");
                String name = userInput.nextLine();
                guests[i] = name;
                System.out.println(name + " was added successfully\n");
                break;
            }
        }
    }

    public static void renameGuests(){
        System.out.println("\nProvide the guest's number");
        int guestNumber = userInput.nextInt();
        userInput.nextLine();

        if(guestNumber >= 1 && guestNumber <= guests.length && guests[guestNumber - 1] != null){
            System.out.println("New Name: ");
            String newName = userInput.nextLine();

            guests[guestNumber - 1] = newName;
        }
        else {
            System.out.println("Error: There is no guest with that number.");
        }
    }
    public static void removeGuest() {

        System.out.println("\nWhich guest do you want to remove:\n");
        int guestNumber = userInput.nextInt();

        if(guestNumber >= 1 && guestNumber <= guests.length && guests[guestNumber - 1] != null){
            guests [guestNumber - 1] = null;

            String[] temp = new String[guests.length];
            int ti = 0;
            for (int i = 0; i < guests.length; i++) {
                if (guests[i] != null) {
                    temp[ti] = guests[i];
                    ti++;
                }
            }
            guests = temp;
            System.out.println("Error: There is no guest with that number.");
        }
    }

    public static void insertGuest(){
        System.out.println("\nProvide the guest's number");
        int guestNumber = userInput.nextInt();
        userInput.nextLine();

        if(guestNumber >= 1 && guestNumber <= guests.length && guests[guestNumber - 1] != null){
            System.out.println("New Name: ");
            String newName = userInput.nextLine();

            for (int i = guests.length -1; i > guestNumber - 1; i--){
                guests[i] = guests[i - 1];
            }
            guests[guestNumber - 1] = newName;
        }
        else {
            System.out.println("Error: There is no guest with that number.");
        }
    }

    public static void insertTestNames(){
        guests[0] = "Lisa";
        guests[1] = "John";
        guests[2] = "Alex";
        guests[3] = "Alice";
        guests[4] = "Jacob";
    }
}
