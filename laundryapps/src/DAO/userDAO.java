package DAO;

import java.util.List;
import model.user;

public interface userDAO {
    public void save(user user);
    public List<user> show();
    public void update(user user);
    public void delete(int id);
}