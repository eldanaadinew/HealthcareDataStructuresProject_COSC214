public class LinkedListStructure {
    private Node head;
    private int size;

    private class Node {
        PatientRecord data;
        Node next;

        Node(PatientRecord data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListStructure() {
        head = null;
        size = 0;
    }

    public void insertRecord(PatientRecord record) {
        Node newNode = new Node(record);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
    }

    public PatientRecord searchRecord(int recordID) {
        Node current = head;

        while (current != null) {
            if (current.data.getRecordID() == recordID) {
                return current.data;
            }

            current = current.next;
        }

        return null;
    }

    public boolean deleteRecord(int recordID) {
        if (head == null) {
            return false;
        }

        if (head.data.getRecordID() == recordID) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;

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
        Node current = head;

        while (current != null) {
            PatientRecord record = current.data;
            current = current.next;
        }
    }

    public int getSize() {
        return size;
    }
}
