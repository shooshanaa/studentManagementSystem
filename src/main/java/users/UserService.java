package users;

import java.util.ArrayList;

public class UserService {

    private User activeUser;

    private final ArrayList<User> teachers = new ArrayList<>();
    private final ArrayList<User> students = new ArrayList<User>();
    private final ArrayList<User> users = new ArrayList<>();

    public String createUser (User user) throws Exception {
        if (this.verifyUserData(user))
        {
            this.users.add(user);
            return "User added successfully";

        }

        return "Problems adding user";
    }

    private boolean verifyUserData(User user) throws InvalidUserException {
        if(user.getName().isEmpty() || user.getName().length()<2){
            throw new InvalidUserException("Username not valid");
        }
        if(user.getUserName().isEmpty()) {
            throw new InvalidUserException("Please provide username");
        }
            if(user.getPassword().isEmpty()) {
                throw new InvalidUserException("Please provide password");
            }

        return true;
    }



    public String editUserData(User user) {
        boolean updateSuccessful = false;

        for (User currentUser : this.users) {
            if (user.getId().equals(currentUser.getId())) {
                currentUser.setName(currentUser.getName());
                currentUser.setPassword(user.getPassword());

                updateSuccessful = true;
                break;
            }
        }
        return updateSuccessful ?
                "User " + user.getName() + " updates successful" : "problem occurred during update";
    }

    public String deleteUser() {
        this.users.remove(user);
        return "User deleted successfully";

    }

    public ArrayList<User> getAllUsers(){
        return users;
    }



    public ArrayList<User> getAllTeachers() {

      return teachers;
   }


    public ArrayList<User> getAllStudents(User user){
        //String [] allStudents = new String[0];

           if(user.getUserType()==UserTypes.STUDENT) {
               this.students.add(user);
           }


        return students;
    }

    public User findUserByUserName(String userName) throws Exception {
        for(User currentUser: this.users){
            if(currentUser.getUserName().equals(userName))
                return currentUser;
        }
        throw new InvalidUserException("User " + userName + " not found!");
    }

    public void setActiveUser(User activeUser, String password) throws InvalidUserException {
        if(!activeUser.verifyPassword(password)){
            throw new InvalidUserException("User password incorrect!");
        }
        this.activeUser = activeUser;
    }


}
