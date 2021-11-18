package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int N = scanner.nextInt();

        for (int i=1; i<=N; i++) {

            System.out.println("Employee #" + i + ":");
            System.out.print("Id: ");
            Integer id = scanner.nextInt();
            while(position(list, id)) {
                System.out.println("Id already taken! Try again: ");
                id = scanner.nextInt();
            }

            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Salary: R$ ");
            Double salary = scanner.nextDouble();

            Employee emp = new Employee(id, name, salary);

            list.add(emp);
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int idSalary = scanner.nextInt();
        Integer pos = position(list, idSalary);
        System.out.println();

        if (pos == null) {
            System.out.print("This id doesn't exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percent = scanner.nextDouble();
            list.get(pos).increaseSalary(percent);
        }

        System.out.println();
        System.out.println("List of employees: ");

        for(Employee emp : list) {
            System.out.println(emp);
        }
    }

    public static Integer position(List<Employee> list, int id){
        for (int i=0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }
}
