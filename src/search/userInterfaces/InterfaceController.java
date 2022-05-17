package search.userInterfaces;

public class InterfaceController {
    private SuperInterface superInterface;

    public void executeInterface() {
        this.superInterface.startInterface();
    }

    public void setSuperInterface(SuperInterface superInterface) {
        this.superInterface = superInterface;
    }
}
