package sold;

import java.util.*;

// create seller user
// create buyer user

/**
 * User Repository to manage users
 */
class UsersRepository {
    private static List<User> usersList = new ArrayList<User>();

    public static User createUser(int id, String name){
        User user = new User(id, name);
        usersList.add(user);
        return user;
    }

    public User getUser(int id) {
        for(User user: usersList) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User getUser(String name) {
        for(User user: usersList) {
            if(user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}
