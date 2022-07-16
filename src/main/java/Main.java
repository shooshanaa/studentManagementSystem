import Course.CourseService;
import school.MenuController;
import school.SchoolController;
import users.User;
import users.UserService;

public class Main {
    public static void main(String[] args) {
        SchoolController schoolController = new SchoolController(
                new CourseService(),
                new UserService()
        );

        MenuController menuController = new MenuController(schoolController);
        UserService userService = new UserService();

        //menuController.start();

        schoolController.collectUserInfoAndRegisterUser();
        schoolController.collectUserInfoAndRegisterUser();
        schoolController.collectUserInfoAndRegisterUser();
        schoolController.collectUserInfoAndVerifyUser();
        userService.getAllUsers();
        userService.deleteUser();



       // schoolController.createCourse();
       // schoolController.viewCourses();


    }
}
