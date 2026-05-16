public class PatientRecord {
    private int recordID;
    private int age;
    private String gender;
    private String diagnosis;
    private String treatmentPlan;
    private double bmi;

    public PatientRecord(int recordID, int age, String gender, String diagnosis,
                         String treatmentPlan, double bmi) {
        this.recordID = recordID;
        this.age = age;
        this.gender = gender;
        this.diagnosis = diagnosis;
        this.treatmentPlan = treatmentPlan;
        this.bmi = bmi;
    }

    public int getRecordID() {
        return recordID;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }

    public double getBmi() {
        return bmi;
    }

    public boolean isEmergency() {
        return diagnosis.equalsIgnoreCase("Coronary Artery Disease")
                || diagnosis.equalsIgnoreCase("Hypertension")
                || treatmentPlan.equalsIgnoreCase("Surgery");
    }

    @Override
    public String toString() {
        return "PatientRecord{" +
                "recordID=" + recordID +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatmentPlan='" + treatmentPlan + '\'' +
                ", bmi=" + bmi +
                '}';
    }
}
