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
                String[] values = line.split(",");

                try {
                    int recordID = Integer.parseInt(values[0].trim());
                    int age = Integer.parseInt(values[1].trim());
                    String gender = values[2].trim();
                    double bmi = Double.parseDouble(values[6].trim());
                    String diagnosis = values[7].trim();
                    String treatmentPlan = values[8].trim();

                    records[count] = new PatientRecord(
                            recordID,
                            age,
                            gender,
                            diagnosis,
                            treatmentPlan,
                            bmi
                    );

                    count++;

                } catch (Exception e) {
                    System.out.println("Skipping invalid row: " + line);
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
}
