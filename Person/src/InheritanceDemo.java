import java.util.ArrayList;
import java.util.Scanner;

public class InheritanceDemo {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<Worker> WorkerArray = new ArrayList<>();

        String firstName;
        String lastName;
        String idString;
        String inputTitle;
        int yearOfBirth;
        double hourlyPayRate;
        double annualSalary;

        System.out.println("Enter the hourly workers");

        for (int i = 0; i < 3; i++)
        {
            firstName = SafeInput.getNonZeroLenString(in, "Input first name");
            lastName = SafeInput.getNonZeroLenString(in, "Input last name");
            idString = SafeInput.getNonZeroLenString(in, "Enter Id");
            inputTitle = SafeInput.getNonZeroLenString(in, "Input title");
            yearOfBirth = SafeInput.getRangedInt(in, "Input year of birth ",1940,2000);
            hourlyPayRate = SafeInput.getDouble(in, "Enter the hourly pay rate");


            Worker WorkerInput = new Worker (firstName, lastName, idString, inputTitle, yearOfBirth, hourlyPayRate);

            WorkerArray.add(WorkerInput);

            System.out.println(WorkerArray);
        }

        System.out.println("Enter the salary workers");

        for (int i = 0; i < 3; i++)
        {
            firstName = SafeInput.getNonZeroLenString(in, "Input first name");
            lastName = SafeInput.getNonZeroLenString(in, "Input last name");
            idString = SafeInput.getNonZeroLenString(in, "Enter Id");
            inputTitle = SafeInput.getNonZeroLenString(in, "Input title");
            yearOfBirth = SafeInput.getRangedInt(in, "Input year of birth ",1940,2000);
            hourlyPayRate = 0;
            annualSalary = SafeInput.getDouble(in, "Input the annual salary");

            SalaryWorker salaryWorkerInput = new SalaryWorker (firstName, lastName, idString, inputTitle, yearOfBirth, hourlyPayRate, annualSalary);

            hourlyPayRate = salaryWorkerInput.getHourlyPayRate();

            WorkerArray.add(salaryWorkerInput);

            System.out.println(WorkerArray);
        }

        String stringFormat;
        stringFormat = String.format("%5s%20s%40s%50s%60s", "ID#", "Full Name", "Week 1", "Week 2","Week 3");
        System.out.println(stringFormat);

        for(int i = 0; i < WorkerArray.size(); i++)
        {
            stringFormat = String.format("%5s%20s%50s%60s%60s", WorkerArray.get(i).getIdString(), WorkerArray.get(i).fullName(),
                    WorkerArray.get(i).displayWeeklyPay(40), WorkerArray.get(i).displayWeeklyPay(50),
                    WorkerArray.get(i).displayWeeklyPay(40));

            System.out.println(stringFormat);
        }
    }
}