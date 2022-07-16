package Course;

import java.util.ArrayList;

public class CourseService {
    private final ArrayList<Course> courses = new ArrayList<>();

    public String addCourse(Course course) {
       try{
        if (this.validateCourse(course)) {
            this.courses.add(course);
            return "Course successfully added";
        }
    } catch (Exception exception) {
        return exception.getMessage();
    }
        return "There was a problem adding course";
}

    private boolean validateCourse(Course course) throws Exception {
        if(course.getName().isEmpty()|| course.getName()== null){
            throw new Exception("Please provide name field");
        }
        if (course.getTeacher() == null) {
            throw new Exception("Please enter the name of the teacher");
        }
        return true;
    }

    public ArrayList<Course> getAllCourses() {
        return courses;
    }
}
