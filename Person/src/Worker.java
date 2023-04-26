public class Worker extends Person
{
    public double hourlyPayRate;
    public double hoursWorked;
    public double overtimeHours;

    public Worker(String firstName, String lastName, String idString, String inputTitle, int yearOfBirth, double hourlyPayRate)
    {
        super(firstName, lastName, idString, inputTitle, yearOfBirth);
        this.hourlyPayRate = hourlyPayRate;
        this.hoursWorked = hoursWorked;
    }

    public String toString()
    {
        return this.getFirstName() + ", " + this.getLastName() + ", " + this.getIdString() + ", " + this.getInputTitle() + ", "
                + this.getYearOfBirth() + ", Hourly Pay of " + this.hourlyPayRate;
    }

    public double getHourlyPayRate()
    {
        return hourlyPayRate;
    }
    public void setHourlyPayRate(double hourlyPayRate)
    {
        this.hourlyPayRate = hourlyPayRate;
    }
    double calculateWeeklyPay(double hoursWorked)
    {
        double overtimePay = 0;
        double overtimeHours = hoursWorked - 40;

        if (hoursWorked > 40)
        {
            overtimePay = (this.hourlyPayRate * 1.5) * overtimeHours;
            hoursWorked = hoursWorked - overtimeHours;
        }
        return overtimePay + (hourlyPayRate * hoursWorked);
    }

    String displayWeeklyPay(double hoursWorked)
    {
        overtimeHours = hoursWorked - 40;

        if (hoursWorked <= 40)
        {
            return "Worked for " + hoursWorked + " hours. Paid " + calculateWeeklyPay(hoursWorked);
        }
        else
        {
            return "Worked for 40 hours and " + overtimeHours + " overtime hours. Paid " + calculateWeeklyPay(hoursWorked);
        }

    }

}
