package search;

import search.initializer.ProgramInitializer;

public class Main {
    public static void main(String[] args) {

        //load file with --names.txt
        String filePath = args[0];
        ProgramInitializer initializer = new ProgramInitializer(filePath);
        initializer.executeInitializer();
    }
}
