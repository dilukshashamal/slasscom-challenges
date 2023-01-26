import java.util.Scanner;

//salary calculation
public class Employee {
    private static float basicSalary;
    public static void main(String[] args) {
        basicSalary = calculateBasicSalary();

        Thread allowanceThread = new Thread(new AllowanceCalculator());
        allowanceThread.start();

        Thread epfThread = new Thread(new EPFCalculator());
        epfThread.start();

        try {
            allowanceThread.join();
            epfThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        float allowance = AllowanceCalculator.getAllowance();
        float epf = EPFCalculator.getEPF();
        float employerContribution = EPFCalculator.getEmployerContribution();

        float finalSalary = basicSalary + allowance - epf + employerContribution;
        System.out.println("Final Salary: " + finalSalary);
    }

    private static float calculateBasicSalary() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Per Day Payment:");
        float perDayPayment = sc.nextFloat();
        System.out.println("Enter No of Working Days:");
        int noOfDays = sc.nextInt();

        float basicSalary = perDayPayment * noOfDays;

        return basicSalary;
    }
    public static float getBasicSalary() {
        return basicSalary;
    }
}

//allowance Calculation
class AllowanceCalculator implements Runnable{
        private static float allowance;

        public void run(){
            float basicSalary = Employee.getBasicSalary();
            allowance = basicSalary*0.05f;
        }
        public static float getAllowance(){
            return allowance;
        }
    }

    //EPF Calculation
    class EPFCalculator implements Runnable{
        private static float epf;
        private static float employerContribution;

        public void run() {

            float basicSalary = Employee.getBasicSalary();
            float totalSalary = basicSalary + AllowanceCalculator.getAllowance();

            epf = totalSalary * 0.08f;

            employerContribution = totalSalary * 0.12f;
        }

        public static float getEPF() {
            return epf;
        }
        public static float getEmployerContribution() {
            return employerContribution;
        }
    }

