package search.initializer;

import search.userInterfaces.InterfaceController;
import search.userInterfaces.MainInterface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProgramInitializer {
    private final Scanner scanner;
    private final InterfaceController interfaceController;
    private final ArrayList<String> personCollection;
    private final String filePath;

    public ProgramInitializer(String filePath) {
        this.scanner = new Scanner(System.in);
        this.personCollection = new ArrayList<>();
        this.interfaceController = new InterfaceController();
        this.filePath = filePath;
    }

    public void executeInitializer() {
        this.initializeListOfPeople();
        MainInterface mainInterface = this.createMainInterface();

        this.startProgram(mainInterface);
    }

    public void startProgram(MainInterface mainInterface) {
        this.interfaceController.setSuperInterface(mainInterface);
        this.interfaceController.executeInterface();
    }

    public MainInterface createMainInterface() {
        return new MainInterface(this.scanner, this.interfaceController, this.personCollection);
    }

    public void initializeListOfPeople() {

        try (Stream<String> stream = Files.lines(Paths.get(this.filePath))) {
            this.personCollection.addAll(
                    stream
                            .map(String::toLowerCase)
                            .toList()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
