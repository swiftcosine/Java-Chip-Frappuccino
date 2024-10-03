package patientinfo;
import java.util.Scanner;
public class PatientDriverApp {

    //display patient's info
    public static void displayPatient(Patient patient) {
        System.out.println("Patient info:");
        System.out.println(patient.toString());
    }

    //display the procedure's info
    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure.toString());
    }

    //calculate total charges for all procedures
    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getCharges() + p2.getCharges() + p3.getCharges();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Prompt for Patient details
        Patient patient = new Patient("Jay", "N.", "Andrews", 
                                      "3000 W Alameda Ave", "Burbank", "CA", "91505", 
                                      "(582) 651-8354", "Andreas E.", "(922) 793-3419");

        //Display patient's info
        displayPatient(patient);
        System.out.println();

        //Create Procedure objects by prompting user input
        Procedure[] procedures = new Procedure[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("ENTER DETAILS FOR PROCEDURE " + (i + 1) + ":");

            System.out.print("What was the procedure? ");
            String procedureName = scanner.nextLine();

            System.out.print("When was the procedure? ");
            String procedureDate = scanner.nextLine();

            System.out.print("What was the name of the practicioner? ");
            String practitionerName = scanner.nextLine();

            System.out.print("How much was the procedure? ");
            double charges = scanner.nextDouble();
            scanner.nextLine();  // Consume the newline character

            //Create new Procedure object using user's input
            procedures[i] = new Procedure(procedureName, procedureDate, practitionerName, charges);

            System.out.println();
        }

        //Display each procedure's details
        for (Procedure procedure : procedures) {
            displayProcedure(procedure);
            System.out.println();
        }

        //Calculate and display total charges for all procedures
        double totalCharges = calculateTotalCharges(procedures[0], procedures[1], procedures[2]);
        System.out.println("Total: $" + String.format("%,.2f", totalCharges));  // Format to two decimal places
        System.out.println();  // Print an empty line for spacing

        //Prompt user for programmer info
        System.out.println("What is the programmer's name?  ");
        String programmerName = scanner.nextLine();

        System.out.println("What is your M#? ");
        String mNumber = scanner.nextLine();

        System.out.println("What is the due date? ");
        String dueDate = scanner.nextLine();

        //Display programmer info
        System.out.println("Programmer: " + programmerName);
        System.out.println("M#: " + mNumber);
        System.out.println("Due Date: " + dueDate);
        System.out.println("\nThe program was developed by student " + programmerName + " on " + dueDate);

        scanner.close();
    }
}
