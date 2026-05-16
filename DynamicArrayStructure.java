public class DynamicArrayStructure {
    private PatientRecord[] records;
    private int size;

    public DynamicArrayStructure() {
        records = new PatientRecord[10];
        size = 0;
    }

    public void insertRecord(PatientRecord record) {
        if (size == records.length) {
            resize();
        }

        records[size] = record;
        size++;
    }

    public PatientRecord searchRecord(int recordID) {
        for (int i = 0; i < size; i++) {
            if (records[i].getRecordID() == recordID) {
                return records[i];
            }
        }

        return null;
    }

    public boolean deleteRecord(int recordID) {
        for (int i = 0; i < size; i++) {
            if (records[i].getRecordID() == recordID) {
                for (int j = i; j < size - 1; j++) {
                    records[j] = records[j + 1];
                }

                records[size - 1] = null;
                size--;
                return true;
            }
        }

        return false;
    }

    public void traverseRecords() {
        for (int i = 0; i < size; i++) {
            PatientRecord record = records[i];
        }
    }

    private void resize() {
        PatientRecord[] newRecords = new PatientRecord[records.length * 2];

        for (int i = 0; i < records.length; i++) {
            newRecords[i] = records[i];
        }

        records = newRecords;
    }

    public int getSize() {
        return size;
    }
}
