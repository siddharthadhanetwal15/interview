package com.oracle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dhanetwa on 6/24/2018.
 */
public class EmployeeHashMapTest {
    public static void main(String[] args) {
        Company company = new Company();
        company.setCompanyName("Oracle");
        Employee e1 = new Employee(10,"Sid", "Jaipur", company);
        Employee e2 = new Employee(20,"Babu", "Bangalore", company);
        Map<Integer, Employee> employeeMap = new HashMap<>();
        employeeMap.put(e1.getId(), e1);
        employeeMap.put(e2.getId(), e2);
        System.out.println(employeeMap.get(10));
    }
}

class Employee{
    Integer id;
    String name;
    String city;
    Company company;

    public Employee(Integer id, String name, String city, Company company) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.getId().toString() + " " +this.getName().toString() + " " +this.getCity().toString() + " " + this.company.toString();
    }
}
class Company{
    String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    @Override
    public String toString(){
        return this.companyName.toString();
    }
}