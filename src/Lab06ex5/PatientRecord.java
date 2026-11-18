package Lab06ex5;

public class PatientRecord {
    private String _ssn;
    protected String _medical_history;

    public PatientRecord(String ssn, String medicalHistory) {
        this._ssn = ssn;
        this._medical_history = medicalHistory;
    }

    public String getMaskedSsn() {
        return "***-**-" + this._ssn.substring(this._ssn.length() - 4);
    }

    public static void main(String[] args) {
        OutpatientRecord outpatient = new OutpatientRecord("123-45-6789", "Asthma", "2026-11-20");
        InpatientRecord inpatient = new InpatientRecord("987-65-4321", "Appendicitis", "Room 402");

        outpatient.displayRecord();
        System.out.println();
        inpatient.displayRecord();
    }
}

class OutpatientRecord extends PatientRecord {
    private String appointmentDate;

    public OutpatientRecord(String ssn, String medicalHistory, String appointmentDate) {
        super(ssn, medicalHistory);
        this.appointmentDate = appointmentDate;
    }

    public void displayRecord() {
        System.out.println("Outpatient Record");
        System.out.println("Medical History (protected): " + this._medical_history);
        System.out.println("SSN via public getter (private in parent): " + getMaskedSsn());
        System.out.println("Appointment Date: " + this.appointmentDate);
    }
}

class InpatientRecord extends PatientRecord {
    private String roomNumber;

    public InpatientRecord(String ssn, String medicalHistory, String roomNumber) {
        super(ssn, medicalHistory);
        this.roomNumber = roomNumber;
    }

    public void displayRecord() {
        System.out.println("Inpatient Record");
        System.out.println("Medical History (protected): " + this._medical_history);
        System.out.println("SSN via public getter (private in parent): " + getMaskedSsn());
        System.out.println("Room Number: " + this.roomNumber);
    }
}
