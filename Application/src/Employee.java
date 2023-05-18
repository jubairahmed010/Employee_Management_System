package Application.src;

import java.util.*;
 
 public class Employee implements Comparable<Employee> {

    private String name;
    private int id;
    private Calendar dateOfBirth;

    public Employee(String name, int id, int day, int month, int year) {
        this.name = name;
        this.id = id;
        this.dateOfBirth = Calendar.getInstance();
        this.dateOfBirth.set(year, month - 1, day);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public double getSalary() {
        return 0.0; // this method will be overridden in the subclasses
    }

 



    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", dateOfBirth=" + dateOfBirth.getTime()+ "]";
    }

    @Override
    public int compareTo(Employee other) {
        // compare based on salary(Ascending order)
        if (this.getSalary() < other.getSalary()) {
            return -1;
        } else if (this.getSalary() > other.getSalary()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getAge() {
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < dateOfBirth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }
    




   
}

