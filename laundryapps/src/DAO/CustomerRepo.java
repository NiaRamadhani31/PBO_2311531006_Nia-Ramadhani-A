package DAO;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.user;


public class CustomerRepo {
    private List<Customer> customerList;

    public CustomerRepo() {
        customerList = new ArrayList<>();
    }

    public List<Customer> show() {
        return customerList;
    }

    public void save(Customer customer) {
		customer.setId(String.valueOf(customer.size() + 1)); // Simple ID generation
    
		customerList.add(customer);
    }

    public void update(Customer customer) {
        for (Customer u : customerList) {
            if (u.getId().equals(customer.getId())) {
                u.setNama(customer.getNama());
                u.setAlamat(customer.getAlamat());
                u.setNoHP(customer.getNoHP());
                break;
            }
        }
    }

    public void delete(String id) {
        customerList.removeIf(u -> u.getId().equals(id));
    }
}