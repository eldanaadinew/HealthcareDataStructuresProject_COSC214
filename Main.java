public class Main {
    public static void main(String[] args) {
        String filePath = "healthcare_dataset.csv";

        System.out.println("Loading healthcare dataset...");

        PatientRecord[] smallDataset = CSVLoader.loadRecords(filePath, 1000);
        PatientRecord[] mediumDataset = CSVLoader.loadRecords(filePath, 5000);
        PatientRecord[] fullDataset = CSVLoader.loadRecords(filePath, 10000);

        System.out.println("Small dataset loaded: " + smallDataset.length + " records");
        System.out.println("Medium dataset loaded: " + mediumDataset.length + " records");
        System.out.println("Full dataset loaded: " + fullDataset.length + " records");

        BenchmarkTester.runBenchmarks(smallDataset);
        BenchmarkTester.runBenchmarks(mediumDataset);
        BenchmarkTester.runBenchmarks(fullDataset);

        runPriorityQueueSimulation(smallDataset);
    }

    private static void runPriorityQueueSimulation(PatientRecord[] records) {
        System.out.println("\n=======================================");
        System.out.println("PRIORITY QUEUE PATIENT ADMISSION SIMULATION");
        System.out.println("Emergency patients are processed before regular patients.");
        System.out.println("=======================================");

        PriorityQueueStructure admissionQueue = new PriorityQueueStructure(20);

        for (int i = 0; i < 10 && i < records.length; i++) {
            admissionQueue.insertRecord(records[i]);
        }

        System.out.println("\nProcessing first 10 patients by priority:");

        PatientRecord nextPatient;

        while ((nextPatient = admissionQueue.processNextPatient()) != null) {
            System.out.println(nextPatient);
        }
    }
}
