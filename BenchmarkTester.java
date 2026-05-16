public class BenchmarkTester {
    private static final int TEST_RUNS = 3;

    public static void runBenchmarks(PatientRecord[] records) {
        int datasetSize = records.length;

        System.out.println("\n=======================================");
        System.out.println("BENCHMARK RESULTS FOR " + datasetSize + " RECORDS");
        System.out.println("Average time over " + TEST_RUNS + " runs");
        System.out.println("=======================================");

        benchmarkDynamicArray(records);
        benchmarkLinkedList(records);
        benchmarkHashStructure(records);
        benchmarkPriorityQueue(records);
    }

    private static void benchmarkDynamicArray(PatientRecord[] records) {
        long insertTotal = 0;
        long searchTotal = 0;
        long deleteTotal = 0;
        long traverseTotal = 0;

        for (int run = 0; run < TEST_RUNS; run++) {
            DynamicArrayStructure structure = new DynamicArrayStructure();

            long start = System.nanoTime();
            for (PatientRecord record : records) {
                structure.insertRecord(record);
            }
            long end = System.nanoTime();
            insertTotal += end - start;

            int searchID = records[records.length / 2].getRecordID();

            start = System.nanoTime();
            structure.searchRecord(searchID);
            end = System.nanoTime();
            searchTotal += end - start;

            start = System.nanoTime();
            structure.traverseRecords();
            end = System.nanoTime();
            traverseTotal += end - start;

            start = System.nanoTime();
            structure.deleteRecord(searchID);
            end = System.nanoTime();
            deleteTotal += end - start;
        }

        printResults("Dynamic Array", insertTotal, searchTotal, deleteTotal, traverseTotal);
    }

    private static void benchmarkLinkedList(PatientRecord[] records) {
        long insertTotal = 0;
        long searchTotal = 0;
        long deleteTotal = 0;
        long traverseTotal = 0;

        for (int run = 0; run < TEST_RUNS; run++) {
            LinkedListStructure structure = new LinkedListStructure();

            long start = System.nanoTime();
            for (PatientRecord record : records) {
                structure.insertRecord(record);
            }
            long end = System.nanoTime();
            insertTotal += end - start;

            int searchID = records[records.length / 2].getRecordID();

            start = System.nanoTime();
            structure.searchRecord(searchID);
            end = System.nanoTime();
            searchTotal += end - start;

            start = System.nanoTime();
            structure.traverseRecords();
            end = System.nanoTime();
            traverseTotal += end - start;

            start = System.nanoTime();
            structure.deleteRecord(searchID);
            end = System.nanoTime();
            deleteTotal += end - start;
        }

        printResults("Linked List", insertTotal, searchTotal, deleteTotal, traverseTotal);
    }

    private static void benchmarkHashStructure(PatientRecord[] records) {
        long insertTotal = 0;
        long searchTotal = 0;
        long deleteTotal = 0;
        long traverseTotal = 0;

        for (int run = 0; run < TEST_RUNS; run++) {
            HashStructure structure = new HashStructure(records.length * 2);

            long start = System.nanoTime();
            for (PatientRecord record : records) {
                structure.insertRecord(record);
            }
            long end = System.nanoTime();
            insertTotal += end - start;

            int searchID = records[records.length / 2].getRecordID();

            start = System.nanoTime();
            structure.searchRecord(searchID);
            end = System.nanoTime();
            searchTotal += end - start;

            start = System.nanoTime();
            structure.traverseRecords();
            end = System.nanoTime();
            traverseTotal += end - start;

            start = System.nanoTime();
            structure.deleteRecord(searchID);
            end = System.nanoTime();
            deleteTotal += end - start;
        }

        printResults("Hash-Based Structure", insertTotal, searchTotal, deleteTotal, traverseTotal);
    }

    private static void benchmarkPriorityQueue(PatientRecord[] records) {
        long insertTotal = 0;
        long searchTotal = 0;
        long deleteTotal = 0;
        long traverseTotal = 0;

        for (int run = 0; run < TEST_RUNS; run++) {
            PriorityQueueStructure structure = new PriorityQueueStructure(records.length);

            long start = System.nanoTime();
            for (PatientRecord record : records) {
                structure.insertRecord(record);
            }
            long end = System.nanoTime();
            insertTotal += end - start;

            int searchID = records[records.length / 2].getRecordID();

            start = System.nanoTime();
            structure.searchRecord(searchID);
            end = System.nanoTime();
            searchTotal += end - start;

            start = System.nanoTime();
            structure.traverseRecords();
            end = System.nanoTime();
            traverseTotal += end - start;

            start = System.nanoTime();
            structure.deleteRecord(searchID);
            end = System.nanoTime();
            deleteTotal += end - start;
        }

        printResults("Priority Queue", insertTotal, searchTotal, deleteTotal, traverseTotal);
    }

    private static void printResults(String structureName, long insertTotal,
                                     long searchTotal, long deleteTotal, long traverseTotal) {
        System.out.println("\n" + structureName);
        System.out.println("Insert Time:   " + insertTotal / TEST_RUNS + " ns");
        System.out.println("Search Time:   " + searchTotal / TEST_RUNS + " ns");
        System.out.println("Delete Time:   " + deleteTotal / TEST_RUNS + " ns");
        System.out.println("Traverse Time: " + traverseTotal / TEST_RUNS + " ns");
    }
}
