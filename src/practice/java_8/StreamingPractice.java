package practice.java_8;

import others.MasterPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamingPractice {
    static class Employee{
        String name;
        int id;
        String city;

        public Employee(String name, int id, String city) {
            this.name = name;
            this.id = id;
            this.city = city;
        }
    }
    public static void main(String[] args) {
        List<Employee> employees=createData();
        String searchKey="Ofa";
        List<Employee> filteredEmp= employees.stream().filter(e->e.name.toLowerCase().contains(searchKey.toLowerCase())).collect(Collectors.toList());

        printResult(filteredEmp);
    }

    private static void printResult(List<Employee> filteredEmp) {
        filteredEmp.forEach(employee -> {
            System.out.println(employee.name+"-"+employee.id+"-"+employee.city);
        });
    }

    private static List<Employee> createData() {
        List<Employee> employees=new ArrayList<>();
        employees.add(new Employee("Omar",34,"Frisco"));
        employees.add(new Employee("Ofar",30,"Dallas"));
        employees.add(new Employee("Omer",32,"SFO"));
        employees.add(new Employee("Ommarr",24,"Dallas"));
        employees.add(new Employee("Ofer",34,"Plano"));
        employees.add(new Employee("Omor",54,"Irving"));
        employees.add(new Employee("Anik",44,"Chicago"));
        employees.add(new Employee("Onek",34,"NY"));
        employees.add(new Employee("Om",34,"Seattle"));
        return employees;
    }
}
