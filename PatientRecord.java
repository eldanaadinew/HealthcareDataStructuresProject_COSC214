public class PatientRecord {
    private int recordID;
    private int age;
    private String gender;
    private String medicalCondition;
    private String hospital;
    private String admissionType;
    private double billingAmount;

    public PatientRecord(int recordID, int age, String gender, String medicalCondition,
                         String hospital, String admissionType, double billingAmount) {
        this.recordID = recordID;
        this.age = age;
        this.gender = gender;
        this.medicalCondition = medicalCondition;
        this.hospital = hospital;
        this.admissionType = admissionType;
        this.billingAmount = billingAmount;
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

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public String getHospital() {
        return hospital;
    }

    public String getAdmissionType() {
        return admissionType;
    }

    public double getBillingAmount() {
        return billingAmount;
    }

    public boolean isEmergency() {
        return admissionType.equalsIgnoreCase("Emergency");
    }

    @Override
    public String toString() {
        return "PatientRecord{" +
                "recordID=" + recordID +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", medicalCondition='" + medicalCondition + '\'' +
                ", hospital='" + hospital + '\'' +
                ", admissionType='" + admissionType + '\'' +
                ", billingAmount=" + billingAmount +
                '}';
    }
}
