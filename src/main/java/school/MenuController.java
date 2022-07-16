package school;

import java.util.Scanner;

public class MenuController {
    Scanner scanner = new Scanner(System.in);

    public final SchoolController schoolController;

    public MenuController (SchoolController schoolController){
        this.schoolController = schoolController;

    }

    public void start(){
        this.showOptions();
        this.handleUserChoice();


    }

    private void handleUserChoice() {
        System.out.println("Choose an option: ");
        String userChoice = scanner.nextLine();

        switch (userChoice){
            case "1":
                // add
                break;
            case "2":
                // add
                break;
            case "3":
                // add
                break;
            case "4":
                // add
                break;
            case "5":
                // add
                break;
            case "6":
                // add
                break;



        }

    }

    private void showOptions() {
        System.out.println(
                "Welcome to Student Management System Application" +
                        "\n 1. Add new student" +
                        "\n 2. Edit student data" +
                        "\n 3. Delete student" +
                        "\n 4. Add new teacher" +
                        "\n 5. Edit teacher data" +
                        "\n 6. Delete teacher" +
                        "\n 7. Add new course" +
                        "\n 8. Edit course details" +
                        "\n 9. Delete course" +

                        "\n 10. Exit"
        );
    }

}
