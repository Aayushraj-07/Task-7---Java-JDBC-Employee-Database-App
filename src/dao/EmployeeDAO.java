package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import util.DBConnection;

public class EmployeeDAO {

    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO Employee (name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getDepartment());
            stmt.setDouble(3, emp.getSalary());
            stmt.executeUpdate();
            System.out.println("Employee added successfully!");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employee";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));
                employees.add(emp);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return employees;
    }

    public void updateEmployee(Employee emp) {
        String sql = "UPDATE Employee SET name=?, department=?, salary=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getDepartment());
            stmt.setDouble(3, emp.getSalary());
            stmt.setInt(4, emp.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Employee updated!");
            else System.out.println("Employee not found.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM Employee WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Employee deleted!");
            else System.out.println("Employee not found.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
