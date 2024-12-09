package DAO;

import config.Database;
import model.Laundry;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaundryDAO {
    // Create
    public void insertLaundry(Laundry laundry) {
        String query = "INSERT INTO laundry (nama, jenis, jumlah) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement(query)) {
            stmt.setString(1, laundry.getNama());
            stmt.setString(2, laundry.getJenis());
            stmt.setInt(3, laundry.getJumlah());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public List<Laundry> getAllLaundry() {
        List<Laundry> laundryList = new ArrayList<>();
        String query = "SELECT * FROM laundry";
        try (Statement stmt = Database.getInstance().getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Laundry laundry = new Laundry(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("jenis"),
                    rs.getInt("jumlah")
                );
                laundryList.add(laundry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laundryList;
    }

    // Update
    public void updateLaundry(int id, Laundry laundry) {
        String query = "UPDATE laundry SET nama = ?, jenis = ?, jumlah = ? WHERE id = ?";
        try (PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement(query)) {
            stmt.setString(1, laundry.getNama());
            stmt.setString(2, laundry.getJenis());
            stmt.setInt(3, laundry.getJumlah());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteLaundry(int id) {
        String query = "DELETE FROM laundry WHERE id = ?";
        try (PreparedStatement stmt = Database.getInstance().getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}