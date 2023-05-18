package Application.src;

public class ParttimeEmployee extends Employee {
    private double hours;
    private double hourlyRate;

    


    public ParttimeEmployee(String name, int id, int day, int month, int year, double hours, double hourlyRate) {
        super(name, id, day, month, year);
        this.hours = hours;
        this.hourlyRate = hourlyRate;
    }

    

    public double getHours() {
        return hours;
    }



    public void setHours(double hours) {
        this.hours = hours;
    }



    public double getHourlyRate() {
        return hourlyRate;
    }



    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }



    public double getSalary() {
        return hours * hourlyRate;
    }



    @Override
    public String toString() {
        return super.toString()+"ParttimeEmployee [hours=" + hours + ", hourlyRate=" + hourlyRate + "]";
    }

    
}