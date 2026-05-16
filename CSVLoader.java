import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVLoader {

    public static PatientRecord[] loadRecords(String filePath, int maxRecords) {
        PatientRecord[] records = new PatientRecord[maxRecords];
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            br.readLine();

            while ((line = br.readLine()) != null && count < maxRecords) {
                String[] values = splitCSVLine(line);

                try {
                    int recordID = count + 1;
                    int age = Integer.parseInt(values[1].trim());
                    String gender = values[2].trim();
                    String medicalCondition = values[4].trim();
                    String hospital = values[7].trim();
                    double billingAmount = Double.parseDouble(values[9].trim());
                    String admissionType = values[11].trim();

                    records[count] = new PatientRecord(
                            recordID,
                            age,
                            gender,
                            medicalCondition,
                            hospital,
                            admissionType,
                            billingAmount
                    );

                    count++;

                } catch (Exception e) {
                    System.out.println("Skipping invalid row.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        PatientRecord[] finalRecords = new PatientRecord[count];

        for (int i = 0; i < count; i++) {
            finalRecords[i] = records[i];
        }

        return finalRecords;
    }

    private static String[] splitCSVLine(String line) {
        return line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
    }
}
