import dao.EmployeeDAO;
import model.Employee;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Employee Management ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    dao.addEmployee(new Employee(name, dept, salary));
                    break;
                case 2:
                    List<Employee> employees = dao.getAllEmployees();
                    for (Employee emp : employees) System.out.println(emp);
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New Department: ");
                    String newDept = sc.nextLine();
                    System.out.print("New Salary: ");
                    double newSalary = sc.nextDouble();
                    dao.updateEmployee(new Employee(newName, newDept, newSalary) {{ setId(updateId); }});
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteEmployee(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
