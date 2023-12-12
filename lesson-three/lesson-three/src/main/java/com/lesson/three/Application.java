package com.lesson.three;

import com.lesson.three.factory.EmployeeFactory;
import com.lesson.three.model.Employee;
import com.lesson.three.model.Project;

import java.util.ArrayList;
import java.util.List;

public class Application {
	static List<Employee> employeeList = new ArrayList<>();
	public static void main(String[] args) {
		EmployeeFactory employeeFactory = new EmployeeFactory();
		employeeList = employeeFactory.getAllEmployee();

		List<String> distinctProjects = employeeFactory.getAllDistinctProjectsDescending();

		System.out.println("\nProyectos distintos (orden descendente):");
		for (String s : distinctProjects) {
			System.out.println(s);
		}

		List<String> projectsWithFirstName = employeeFactory.getEmployeesWithFirstNameStartingWith("A");
		System.out.println("\nProyectos que empiezan con A:");
		for (String s : projectsWithFirstName) {
			System.out.println(s);
		}

		List<Employee> employeesJoined = employeeFactory.getEmployeesJoinedInYear(2023);
		System.out.println("\nEmpleados que ingresaron el 2003:");
		for (Employee employee : employeesJoined) {
			System.out.println(employee.getFirstName() + " " + employee.getLastName());
		}

		List<Employee> employeesSorted = employeeFactory.getEmployeesSortedByFirstNameAndSalary();

		System.out.println("\nEmpleados ordenados por nombre y salario:");
		for (Employee employee : employeesSorted) {
			System.out.println(employee.getFirstName() + " " + employee.getLastName() + " - Salary: " + employee.getSalary());
		}

		System.out.println("\nSalario Minimo: " + employeeFactory.getMinimumSalary());

		List<Employee> employeesWithMinimumSalary = employeeFactory.getEmployeesWithMinimumSalary();

		System.out.println("\nEmpleados con salario minimo:");
		for (Employee employee : employeesWithMinimumSalary) {
			System.out.println(employee.getFirstName() + " " + employee.getLastName() + " - Salary: " + employee.getSalary());
		}

		System.out.println("\nTotal de laptops asignados: " + employeeFactory.getTotalLaptopsAssigned());


		List<Project> employeesProjectsManagedBy = employeeFactory.getProjectsManagedBy("Robert Downey Jr");

		System.out.println("\nProyectos en los cuales el Project Manager es Robert Downey Jr:");
		for (Project project : employeesProjectsManagedBy) {
			System.out.println(project);
		}

		System.out.println("\nTotal de Proyectos en los cuales el Project Manager es Robert Downey Jr: "
				+ employeeFactory.countProjectsManagedBy("Robert Downey Jr"));

		System.out.println("\nEmpleados con salario minimo:");
		for (Employee employee : employeesWithMinimumSalary) {
			System.out.println(employee.getFirstName() + " " + employee.getLastName() + " - Salary: " + employee.getSalary());
		}

		List<Employee> employeesWorkingWithProjectManager = employeeFactory.getEmployeesWorkingWithProjectManager("Robert Downey Jr");

		System.out.println("\nEmpleados en Proyectos en los cuales el Project Manager es Robert Downey Jr:");
		for (Employee employee : employeesWorkingWithProjectManager) {
			System.out.println(employee.getFirstName() + " " + employee.getLastName() + " - Salary: " + employee.getSalary());
		}
	}
}
