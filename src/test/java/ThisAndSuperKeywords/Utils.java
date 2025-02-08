package ThisAndSuperKeywords;

public class Utils extends Page {
    int driver; // class variable
    public Utils(int driver) { //  instance variable
        super(driver); //  super should all be the first line of method
        this.driver = driver;
    }
    public int printData() {
        return driver;
    }
}
