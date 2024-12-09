package controller;

import DAO.LaundryDAO;
import model.Laundry;
import java.util.List;

public class LaundryController {
    private LaundryDAO laundryDAO;

    public LaundryController() {
        this.laundryDAO = new LaundryDAO();
    }

    public void addLaundry(Laundry laundry) {
        laundryDAO.insertLaundry(laundry);
    }

    public List<Laundry> getAllLaundry() {
        return laundryDAO.getAllLaundry();
    }

    public void updateLaundry(int id, Laundry laundry) {
        laundryDAO.updateLaundry(id, laundry);
    }

    public void deleteLaundry(int id) {
    	laundryDAO.deleteLaundry(id);
    }
}