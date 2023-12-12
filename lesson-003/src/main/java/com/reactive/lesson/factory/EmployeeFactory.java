package com.reactive.lesson.factory;

import com.reactive.lesson.model.Employee;
import com.reactive.lesson.model.Project;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeFactory {
    List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployee(){
        Project delta = new Project("Delta Model", "Login", "Robert Downey Jr");
        Project beta = new Project("Beta Enhancement", "Authentication", "Chris");
        Project twoFactorAuth = new Project("Two Factor Authentication", "Authentication", "MSD");
        Project commonUI = new Project("Common UI", "UI", "Robert Downey Jr");
        Project pegasus = new Project("Pegasus Model", "Data", "Vikram");
        Project customerOnboarding = new Project("Customer Onboarding", "Ads", "Vedha");
        Project verification = new Project("Source Verification", "Data", "Pablo");
        Project removeUsers = new Project("Remove Invalid User", "Proxy", "Jeetu");
        Project siteReliability = new Project("Site Reliability", "Admin", "Zaheer Khan");
        Project dataTransition = new Project("Data Transition", "Data", "Atif Aslam");
        Project twoPhaseDeployment =new Project("Two Phase Deployment", "Deployment", "Shaktiman");

        employees.add(new Employee("2020Emp0234", "María Luisa", "Pastor", 900000, 1, Arrays.asList(delta, beta)));
        employees.add(new Employee("2012Emp1923", "Cristián", "Martín", 3500000, 3, Arrays.asList(pegasus, customerOnboarding, beta, siteReliability)));
        employees.add(new Employee("2017Emp0721", "Rosalinda", "Reyes", 1800000, 3, Arrays.asList(twoFactorAuth, beta, commonUI)));
        employees.add(new Employee("2017Emp00031", "Yéssica", "Rivero", 2200000, 2, Arrays.asList(delta, twoFactorAuth)));
        employees.add(new Employee("2013Emp0872", "Maite", "Cortés", 2200000, 3, Arrays.asList(pegasus, delta, removeUsers, dataTransition)));
        employees.add(new Employee("2022Emp0087", "Pepito", "Lopez", 900000, 1, List.of(twoFactorAuth)));
        employees.add(new Employee("2019Emp0050", "Vicenta", "Estévez", 1300000, 1, Arrays.asList(removeUsers, commonUI)));
        employees.add(new Employee("2023Emp0934", "Agapito", "Abel", 1100000, 1, List.of(pegasus)));
        employees.add(new Employee("2023Emp1033", "Faustino", "Garcia", 1200000, 0, List.of(delta)));
        employees.add(new Employee("2015Emp0009", "Socorro", "Contreras", 2600000, 2, Arrays.asList(verification, removeUsers, twoPhaseDeployment)));

        return employees;
    }

    public List<String> getAllDistinctProjectsDescending() {
        List<String> distinctProjects = employees.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .map(Project::getName)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return distinctProjects;
    }

    public List<String> getEmployeesWithFirstNameStartingWith(String prefix) {
        List<String> employeesWithFirstNameStartingWithA = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith(prefix))
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .collect(Collectors.toList());

        return employeesWithFirstNameStartingWithA;
    }

    public List<Employee> getEmployeesJoinedInYear(int year) {
        return employees.stream()
                .filter(employee -> getYearFromEmployeeId(employee.getId()) == year)
                .collect(Collectors.toList());
    }

    private int getYearFromEmployeeId(String employeeId) {
        return Integer.parseInt(employeeId.substring(0, 4));
    }

    public List<Employee> getEmployeesSortedByFirstNameAndSalary() {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getFirstName)
                        .thenComparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

    public int getMinimumSalary() {
        Optional<Integer> minSalary = employees.stream()
                .map(Employee::getSalary)
                .min(Integer::compare);

        return minSalary.orElse(0);
    }

    public List<Employee> getEmployeesWithMinimumSalary() {
        return employees.stream()
                        .filter(employee -> employee.getSalary() == getMinimumSalary())
                        .toList();
    }
    public int getTotalLaptopsAssigned() {
        return employees.stream()
                .mapToInt(Employee::getTotalLaptopsAssigned)
                .sum();
    }

    public long countProjectsManagedBy(String projectManager) {
        return employees.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .filter(project -> projectManager.equals(project.getProjectManager()))
                .count();
    }

    public List<Project> getProjectsManagedBy(String projectManager) {
        return employees.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .filter(project -> projectManager.equals(project.getProjectManager()))
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesWorkingWithProjectManager(String projectManager) {
        return employees.stream()
                .filter(employee -> employee.getProjects().stream()
                        .anyMatch(project -> projectManager.equals(project.getProjectManager())))
                .toList();
    }

}
