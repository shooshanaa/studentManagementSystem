package Course;

import users.Teacher;

import java.util.UUID;

public class Course {

    private final UUID id;
    private String name;
    private Teacher teacher;

    public Course() {
        this.id = UUID.randomUUID();
    }

    public Course(String name, Teacher teacher) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.teacher = teacher;
    }

    public Course(UUID id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return  "uuid=" + id +
                ", name = " + name + '\'' +
                ", teacher =" + teacher;
    }
}
