package lab.EmployeeManagement;

import java.util.Scanner;

abstract class Employee {
    String id;
    String name;

    public Employee() {}

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
    }

    void display() {
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
    }

    public abstract double calSalary();
}


class Lecturer extends Employee {
    public double calSalary() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter teaching hour: ");
        double teachingHours = scanner.nextDouble();
        double salary = teachingHours * 250000;
        return salary;
    }
}

class Officer extends Employee {
    public double calSalary() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter coefficients salary: ");
        double coefficientsSalary = scanner.nextDouble();
        double salary = coefficientsSalary * 1650000;
        return salary;
    }
}