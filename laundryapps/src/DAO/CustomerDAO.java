package DAO;

import java.util.List;

import model.Customer;


public interface CustomerDAO {
	void save(Customer customer);
    List<Customer> show();
    void update(Customer customer);
    void delete(int id);
	void delete(String id);

}