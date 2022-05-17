package search.userInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchInterface implements SuperInterface {
    private final Scanner scanner;
    private final ArrayList<String> personCollection;

    public SearchInterface(Scanner scanner, ArrayList<String> personCollection) {
        this.scanner = scanner;
        this.personCollection = personCollection;
    }

    @Override
    public void startInterface() {
        System.out.println("\nEnter a name or email to search all suitable people.");
        this.searchPeople(scanner.nextLine());
    }

    public void searchPeople(String query) {
        List<String> tmpList = this.personCollection.stream()
                .filter(line -> line.contains(query))
                .toList();

        System.out.println(this.findTmpListSize(tmpList));

        tmpList
                .forEach(System.out::println);
        System.out.print("\n");
    }

    public String findTmpListSize(List<String> tmpList) {
        if (tmpList.isEmpty()) {
           return "\nNo people were found for your query!\n";
        } else if (tmpList.size() == 1) {
            return "\nThe following person was found for your query:\n";
        } else {
            return "\nThe following " + tmpList.size() + " people were found for your query:\n";
        }
    }
}
