package Application.src;

public class FulltimeEmployee extends Employee {
    private double monthlySalary;

    

    public FulltimeEmployee(String name, int id, int day, int month, int year, double salary) {
        super(name, id, day, month, year);
        this.monthlySalary = salary;
    }

    public void setSalary(double salary) {
        this.monthlySalary = salary;
    }



    public double getSalary() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return super.toString()+"FulltimeEmployee [monthlySalary=" + monthlySalary + "]";
    }


    
}