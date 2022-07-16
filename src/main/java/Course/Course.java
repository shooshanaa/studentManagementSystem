package Course;

import users.Teacher;

import java.util.UUID;

public class Course {

    private final UUID uuid;
    private String name;
    private Teacher teacher;

    public Course(String name, Teacher teacher) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.teacher = teacher;
    }

    public UUID getUuid() {
        return uuid;
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
        return  "uuid=" + uuid +
                ", name = " + name + '\'' +
                ", teacher =" + teacher;
    }
}
