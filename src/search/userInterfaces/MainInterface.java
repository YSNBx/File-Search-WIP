package search.userInterfaces;

import search.interfaceChoiceConstants.MainInterfaceEnum;

import java.util.ArrayList;
import java.util.Scanner;

public class MainInterface implements SuperInterface {
    private Scanner scanner;
    private InterfaceController interfaceController;
    private ArrayList<String> personCollection;

    public MainInterface(Scanner scanner, InterfaceController interfaceController, ArrayList<String> personCollection) {
        this.scanner = scanner;
        this.interfaceController = interfaceController;
        this.personCollection = personCollection;
    }

    @Override
    public void startInterface() {
        while (true) {
            this.printOptions();
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == MainInterfaceEnum.EXIT.getChoice()) {
                System.out.println("\nBye!");
                break;
            }
            this.evaluateChoice(choice);
        }
    }

    public void printOptions() {
        System.out.println(
                "=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit"
        );
    }

    public void evaluateChoice(int choice) {
        if (choice == MainInterfaceEnum.FIND_PERSON.getChoice()) {
            this.setSearchInterface();
        } else if (choice == MainInterfaceEnum.PRINT_ALL.getChoice()) {
            this.printAllPeople();
        } else {
            System.out.println("\nIncorrect option! Try again.");
        }
    }

    public void printAllPeople() {
        System.out.println("\n=== List of people ===");
        this.personCollection
                .forEach(System.out::println);
        System.out.print("\n");
    }

    public void setSearchInterface() {
        this.interfaceController.setSuperInterface(new SearchInterface(this.scanner, this.personCollection));
        this.interfaceController.executeInterface();
    }
}
