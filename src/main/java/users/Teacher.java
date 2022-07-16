package users;

import java.util.UUID;

public class Teacher {
    private String name;
    private UUID uuid;

    public Teacher(String name) {
        this.name = name;
        this.uuid = UUID.randomUUID();
    }
}
