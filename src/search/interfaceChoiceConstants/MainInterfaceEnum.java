package search.interfaceChoiceConstants;

public enum MainInterfaceEnum {
    FIND_PERSON(1),
    PRINT_ALL(2),
    EXIT(0);

    private int choice;

    private MainInterfaceEnum(int choice) {
        this.choice = choice;
    }

    public int getChoice() {
        return this.choice;
    }
}
