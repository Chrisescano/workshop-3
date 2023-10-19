package org.pluralsight;

public class Employee {
    private int employeeID;
    private double hoursWorked;
    private double payRate;
    private String name;

    public Employee(String name, int employeeID, double hoursWorked, double payRate) {
        this.name = name;
        this.employeeID = employeeID;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public double getGrossPay() {
        return hoursWorked * payRate;
    }

    /*-----Getter/Setter-----*/

    public int getEmployeeID() {
        return employeeID;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*-----Override-----*/

    @Override
    public String toString() {
        return "Employee{ID: "+ employeeID +" Name: " + name + " HoursWorked: " + hoursWorked + " PayRate: " + payRate + "}";
    }
}
