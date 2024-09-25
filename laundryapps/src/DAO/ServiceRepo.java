package DAO;

import java.util.ArrayList;
import java.util.List;

import model.Service;


public class ServiceRepo {
    private List<Service> serviceList;

    public ServiceRepo() {
    	serviceList = new ArrayList<>();
    }

    public List<Service> show() {
        return serviceList;
    }

    public void save(Service service) {
		service.setId(String.valueOf(service.size() + 1)); // Simple ID generation
    
		serviceList.add(service);
    }

    public void update(Service service) {
        for (Service u : serviceList) {
            if (u.getId().equals(service.getId())) {
                u.setJenis(service.getJenis());
                u.setSatuan(service.getSatuan());
                u.setHarga(service.getHarga());
                break;
            }
        }
    }

    public void delete(String id) {
        serviceList.removeIf(u -> u.getId().equals(id));
    }
}