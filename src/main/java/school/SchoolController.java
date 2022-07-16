package school;

import Course.Course;
import Course.CourseService;
import users.Teacher;
import users.User;
import users.UserService;
import users.UserTypes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class SchoolController {
    JFrame frame;

    private final CourseService courseService;
    private final UserService userService;


    public SchoolController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
        frame = new JFrame();
    }

    public void createCourse(){
        try {
            Course course = new Course();
            course.setName(JOptionPane.showInputDialog(frame, "Enter name of course"));

            ArrayList<User> teachers = this.userService.getAllTeachers();
            String[] allTeachers = teachers.toArray(new String [0]);
            String courseTeacher = (String) JOptionPane.showInputDialog(
                    this.frame,
                    "Select the teacher",
                    "All teachers",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    teachers.toArray(),
                    teachers.toArray()[0]
                );



            JOptionPane.showMessageDialog(this.frame, this.courseService.addCourse(course));

        } catch (NullPointerException | NumberFormatException exception){
            JOptionPane.showMessageDialog(frame, "Problem occurred, try again");
        }

    }

    public void viewCourses(){
        String[] col = {"id", "name", "teacher"};

        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        this.courseService.getAllCourses().forEach(
                course -> tableModel.addRow(
                        new String[]{
                                String.valueOf(course.getId()),
                                course.getName(),
                                String.valueOf(course.getTeacher())
                                }
                )
        );

        displayTable(tableModel);
    }

    private void displayTable(DefaultTableModel tableModel){
        JTable table = new JTable(tableModel);

        frame.setLayout(new BorderLayout());
        frame.setSize(600,600);

        frame.add(new JScrollPane(table), BorderLayout.AFTER_LAST_LINE);
        frame.setVisible(true);
    }


    public void collectUserInfoAndRegisterUser(){
        try{
            String name = JOptionPane.showInputDialog("Enter your name");
            String userName = JOptionPane.showInputDialog("Enter your username");
            String password = JOptionPane.showInputDialog("Enter your password");

            UserTypes userType;
            if(JOptionPane.showConfirmDialog(frame, "Are You a teacher?")==1){
                userType = UserTypes.TEACHER;
            } else {
                userType = UserTypes.STUDENT;
            }

            userService.createUser(new User(name, userType, userName, password));


        } catch (Exception exception){
            JOptionPane.showMessageDialog(frame, exception.getMessage());
        }
    }

    public void collectUserInfoAndVerifyUser(){
        try{
            String userName= JOptionPane.showInputDialog("Enter your username");
            String password = JOptionPane.showInputDialog("Enter your password");

            User selectedUser = userService.findUserByUserName(userName);
            userService.setActiveUser(selectedUser, password);

            JOptionPane.showMessageDialog(frame, "Login successful");


        }catch (Exception exception){
            JOptionPane.showMessageDialog(frame, exception.getMessage());
        }
    }




}
