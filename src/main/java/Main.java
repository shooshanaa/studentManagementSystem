import school.MenuController;
import school.SchoolController;

public class Main {
    public static void main(String[] args) {
        SchoolController schoolController = new SchoolController();

        MenuController menuController = new MenuController(schoolController);

        menuController.start();


    }
}
