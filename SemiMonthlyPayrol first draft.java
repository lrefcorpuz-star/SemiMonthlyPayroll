import java.util.Scanner;

public class SemiMonthlyPayroll {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ===== EMPLOYEE INFORMATION =====
        System.out.println("====================================");
        System.out.println("  SEMI-MONTHLY PAYROLL SYSTEM");
        System.out.println("====================================");

        System.out.print("\nEnter Employee Number: ");
        String employeeNumber = scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String employeeName = scanner.nextLine();

        System.out.print("Enter Birthday (MM/DD/YYYY): ");
        String birthday = scanner.nextLine();

        // ===== FIRST CUTOFF: JUNE 1-15 =====
        double hoursFirstPeriod = WeeklyHourTracker.calculateWeeklyHours("June 1-15");

        System.out.print("\nEnter Hourly Rate: ");
        double hourlyRate = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        // Calculate First Period
        double grossSalaryFirstPeriod = hoursFirstPeriod * hourlyRate;

        // ===== SECOND CUTOFF: JUNE 16-30 =====
        double hoursSecondPeriod = WeeklyHourTracker.calculateWeeklyHours("June 16-30");

        // Calculate Second Period
        double grossSalarySecondPeriod = hoursSecondPeriod * hourlyRate;

        // ===== TOTAL SEMI-MONTHLY =====
        double totalGrossSalary = grossSalaryFirstPeriod + grossSalarySecondPeriod;

        // ===== DISPLAY RESULTS =====
        System.out.println("\n\n====================================");
        System.out.println("  SEMI-MONTHLY PAYROLL SUMMARY");
        System.out.println("====================================");

        System.out.println("\n--- EMPLOYEE INFORMATION ---");
        System.out.printf("Employee Number: %s\n", employeeNumber);
        System.out.printf("Employee Name: %s\n", employeeName);
        System.out.printf("Birthday: %s\n", birthday);

        System.out.println("\n--- CUTOFF PERIOD 1: JUNE 1-15 ---");
        System.out.printf("Total Hours: %.2f\n", hoursFirstPeriod);
        System.out.printf("Gross Salary: ₱%.2f\n", grossSalaryFirstPeriod);

        System.out.println("\n--- CUTOFF PERIOD 2: JUNE 16-30 ---");
        System.out.printf("Total Hours: %.2f\n", hoursSecondPeriod);
        System.out.printf("Gross Salary: ₱%.2f\n", grossSalarySecondPeriod);

        System.out.println("\n--- TOTAL SEMI-MONTHLY (JUNE) ---");
        System.out.printf("Total Gross Salary: ₱%.2f\n", totalGrossSalary);
        System.out.println("====================================\n");

        scanner.close();
    }
}
