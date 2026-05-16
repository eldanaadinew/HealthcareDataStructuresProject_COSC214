public class HashStructure {
    private Node[] table;
    private int size;

    private class Node {
        PatientRecord data;
        Node next;

        Node(PatientRecord data) {
            this.data = data;
            this.next = null;
        }
    }

    public HashStructure(int capacity) {
        table = new Node[capacity];
        size = 0;
    }

    private int hash(int recordID) {
        return Math.abs(recordID) % table.length;
    }

    public void insertRecord(PatientRecord record) {
        int index = hash(record.getRecordID());
        Node newNode = new Node(record);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
    }

    public PatientRecord searchRecord(int recordID) {
        int index = hash(recordID);
        Node current = table[index];

        while (current != null) {
            if (current.data.getRecordID() == recordID) {
                return current.data;
            }

            current = current.next;
        }

        return null;
    }

    public boolean deleteRecord(int recordID) {
        int index = hash(recordID);
        Node current = table[index];

        if (current == null) {
            return false;
        }

        if (current.data.getRecordID() == recordID) {
            table[index] = current.next;
            size--;
            return true;
        }

        while (current.next != null) {
            if (current.next.data.getRecordID() == recordID) {
                current.next = current.next.next;
                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void traverseRecords() {
        for (int i = 0; i < table.length; i++) {
            Node current = table[i];

            while (current != null) {
                PatientRecord record = current.data;
                current = current.next;
            }
        }
    }

    public int getSize() {
        return size;
    }
}
