package com.newexample.model;

import com.newexample.entity.Employee;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CustomException extends Exception {
    private static final long serialVersionUID = 1L;

    public CustomException(String str) {
        super();
        System.out.println(str);
        EmployeeSystem.operations();
    }
}

public class EmployeeSystem {

    public static Map<Integer, Employee> map = new HashMap<>();

    public static void addEmployee(String name, int age, int id) {
        Employee emp = new Employee(name, age, id);
        //map.put(id, emp);
        operations();
    }

    public static void deleteEmployee(int EmpId) throws CustomException {
        if (map.containsKey(EmpId)) {
            map.remove(EmpId);
            System.out.println("Successfully Deleted from the List !!");
        } else {
            throw new CustomException("Not Found Exception");
        }
        operations();
    }

    public static void searchEmployee(int EmpId) throws CustomException {
        if (map.containsKey(EmpId)) {
            // Employee emp = map.get(EmpId);
            System.out.println("Employee Details: " + map.get(EmpId));
        } else {
            throw new CustomException("Not Found Exception");
        }
        operations();
    }

    public static void employeeList() {
        System.out.println(map.toString());
    }

    public static void operations() {
        System.out.println("******** Employee management system ********");
        System.out.println("1. Add Employee");
        System.out.println("2. Delete Employee");
        System.out.println("3. Search Employee");
        System.out.println("4. Employee List");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        if (userInput == 1) {
            System.out.println("Enter Employee Details (Name, age , Id):");
            Scanner scanner1 = new Scanner(System.in);
            String name = scanner1.next();
            int age = scanner1.nextInt();
            int id = scanner1.nextInt();

            if (!name.equals("") && age != 0 && id != 0) {
                addEmployee(name, age, id);
            }
        } else if (userInput == 2) {
            System.out.println("Enter Employee Id:");
            Scanner scanner2 = new Scanner(System.in);
            int EmpId = scanner2.nextInt();

            try {
                deleteEmployee(EmpId);
            } catch (CustomException e) {
                // e.printStackTrace();
            }
        } else if (userInput == 3) {
            System.out.println("Enter Employee Id:");
            Scanner scanner3 = new Scanner(System.in);
            int EmpId = scanner3.nextInt();

            try {
                searchEmployee(EmpId);
            } catch (CustomException e) {
                // e.printStackTrace();
            }
        } else if (userInput == 4) {
            employeeList();
        }
        operations();
    }

    public static void main(String[] args) {
        operations();
    }
}
