package patientinfo;

public class Procedure {
    private String procedureName, procedureDate, nameOfPractitioner;
    private double charges;

    //No-arg constructor
    public Procedure() {}

    //Constructor
    public Procedure(String procedureName, String procedureDate, String nameOfPractitioner, double charges) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.nameOfPractitioner = nameOfPractitioner;
        this.charges = charges;
    }

    //Accessors
    public String getProcedureName() { return procedureName; }
    public String getProcedureDate() { return procedureDate; }
    public String getNameOfPractitioner() { return nameOfPractitioner; }
    public double getCharges() { return charges; }

    //Mutators
    public void setProcedureName(String procedureName) { this.procedureName = procedureName; }
    public void setProcedureDate(String procedureDate) { this.procedureDate = procedureDate; }
    public void setNameOfPractitioner(String nameOfPractitioner) { this.nameOfPractitioner = nameOfPractitioner; }
    public void setCharges(double charges) { this.charges = charges; }

    //toString method to display procedure info
    public String toString() {
        return "Procedure: " + procedureName + "\n" +
               "\tDate: " + procedureDate + "\n" +
               "\tPractitioner: " + nameOfPractitioner + "\n" +
               "\tCharges: $" + String.format("%.2f", charges);
    }
}

