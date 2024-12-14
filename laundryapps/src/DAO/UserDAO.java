package DAO;

import java.util.List;

import model.user;

public interface UserDAO {
	void save(user user);
	public List<user> show();
	public void delete (String id);
	public void update (user user);
	
}
