import java.text.DecimalFormat;

public class SalaryWorker extends Worker
{

    public double annualSalary;

    public SalaryWorker(String firstName, String lastName, String idString, String inputTitle, int yearOfBirth, double hourlyPayRate, double annualSalary)
    {
        super(firstName, lastName, idString, inputTitle, yearOfBirth, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    public String toString()
    {
        return this.getFirstName() + ", " + this.getLastName() + ", " + this.getIdString() + ", " + this.getInputTitle() + ", "
                + this.getYearOfBirth() + ", Hourly Pay of " + hourlyPayRate + ", and an annul salary of " + this.annualSalary;
    }

    public double getAnnualSalary()
    {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary)
    {
        this.annualSalary = annualSalary;
    }

    double calculateWeeklyPay(double hoursWorked)
    {
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(this.annualSalary / 52));
    }
    String displayWeeklyPay(double hoursWorked)
    {
        return "Worked " + hoursWorked + " hours, and paid " + calculateWeeklyPay(hoursWorked) + " a week.";
    }
}
