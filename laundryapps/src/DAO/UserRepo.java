package DAO;

import java.util.ArrayList;
import java.util.List;
import model.user;

public class UserRepo {
    private List<user> userList;

    public UserRepo() {
        userList = new ArrayList<>();
    }

    public List<user> show() {
        return userList;
    }

    public void save(user user) {
        user.setId(String.valueOf(userList.size() + 1)); // Simple ID generation
        userList.add(user);
    }

    public void update(user user) {
        for (user u : userList) {
            if (u.getId().equals(user.getId())) {
                u.setNama(user.getNama());
                u.setUsername(user.getUsername());
                u.setPassword(user.getPassword());
                break;
            }
        }
    }

    public void delete(String id) {
        userList.removeIf(u -> u.getId().equals(id));
    }
}