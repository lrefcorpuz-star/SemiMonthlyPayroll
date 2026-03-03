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

        // ===== FIRST CUTOFF: JUNE 1‑15 =====
        double hoursFirstPeriod = calculateWeeklyHours(scanner, "June 1‑15");

        System.out.print("\nEnter Hourly Rate: ");
        double hourlyRate = scanner.nextDouble();
        scanner.nextLine(); // clear buffer

        double grossSalaryFirstPeriod = hoursFirstPeriod * hourlyRate;

        // ===== SECOND CUTOFF: JUNE 16‑30 =====
        double hoursSecondPeriod = calculateWeeklyHours(scanner, "June 16‑30");
        double grossSalarySecondPeriod = hoursSecondPeriod * hourlyRate;

        // ===== TOTAL SEMI‑MONTHLY =====
        double totalGrossSalary = grossSalaryFirstPeriod + grossSalarySecondPeriod;

        // ===== DISPLAY RESULTS =====
        System.out.println("\n\n====================================");
        System.out.println("  SEMI-MONTHLY PAYROLL SUMMARY");
        System.out.println("====================================");

        System.out.println("\n--- EMPLOYEE INFORMATION ---");
        System.out.printf("Employee Number: %s%n", employeeNumber);
        System.out.printf("Employee Name: %s%n", employeeName);
        System.out.printf("Birthday: %s%n", birthday);

        System.out.println("\n--- CUTOFF PERIOD 1: JUNE 1‑15 ---");
        System.out.printf("Total Hours: %.2f%n", hoursFirstPeriod);
        System.out.printf("Gross Salary: ₱%.2f%n", grossSalaryFirstPeriod);

        System.out.println("\n--- CUTOFF PERIOD 2: JUNE 16‑30 ---");
        System.out.printf("Total Hours: %.2f%n", hoursSecondPeriod);
        System.out.printf("Gross Salary: ₱%.2f%n", grossSalarySecondPeriod);

        System.out.println("\n--- TOTAL SEMI‑MONTHLY (JUNE) ---");
        System.out.printf("Total Gross Salary: ₱%.2f%n", totalGrossSalary);
        System.out.println("====================================\n");

        scanner.close();
    }

    /**
     * Prompts the user for hours for each day of a week and returns the sum.
     * Includes basic validation (numeric, non‑negative).
     */
    private static double calculateWeeklyHours(Scanner scanner, String period) {
        System.out.printf("%nEntering hours for %s%n", period);
        String[] days = {
            "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday"
        };

        double totalHours = 0;
        for (String day : days) {
            System.out.print("Enter hours for " + day + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                System.out.print("Enter hours for " + day + ": ");
            }

            double hours = scanner.nextDouble();
            if (hours < 0) {
                System.out.println("Hours cannot be negative. Setting to 0.");
                hours = 0;
            }
            totalHours += hours;
        }
        // consume trailing newline before returning to caller
        scanner.nextLine();
        return totalHours;
    }
}