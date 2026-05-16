public class PriorityQueueStructure {
    private PatientRecord[] heap;
    private int size;

    public PriorityQueueStructure(int capacity) {
        heap = new PatientRecord[capacity];
        size = 0;
    }

    public void insertRecord(PatientRecord record) {
        if (size == heap.length) {
            resize();
        }

        heap[size] = record;
        heapifyUp(size);
        size++;
    }

    public PatientRecord searchRecord(int recordID) {
        for (int i = 0; i < size; i++) {
            if (heap[i].getRecordID() == recordID) {
                return heap[i];
            }
        }

        return null;
    }

    public boolean deleteRecord(int recordID) {
        for (int i = 0; i < size; i++) {
            if (heap[i].getRecordID() == recordID) {
                heap[i] = heap[size - 1];
                heap[size - 1] = null;
                size--;

                heapifyDown(i);
                return true;
            }
        }

        return false;
    }

    public void traverseRecords() {
        for (int i = 0; i < size; i++) {
            PatientRecord record = heap[i];
        }
    }

    public PatientRecord processNextPatient() {
        if (size == 0) {
            return null;
        }

        PatientRecord highestPriority = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        heapifyDown(0);

        return highestPriority;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            if (hasHigherPriority(heap[index], heap[parentIndex])) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int highest = index;

            if (leftChild < size && hasHigherPriority(heap[leftChild], heap[highest])) {
                highest = leftChild;
            }

            if (rightChild < size && hasHigherPriority(heap[rightChild], heap[highest])) {
                highest = rightChild;
            }

            if (highest != index) {
                swap(index, highest);
                index = highest;
            } else {
                break;
            }
        }
    }

    private boolean hasHigherPriority(PatientRecord a, PatientRecord b) {
        if (a.isEmergency() && !b.isEmergency()) {
            return true;
        }

        if (!a.isEmergency() && b.isEmergency()) {
            return false;
        }

        return a.getRecordID() < b.getRecordID();
    }

    private void swap(int i, int j) {
        PatientRecord temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void resize() {
        PatientRecord[] newHeap = new PatientRecord[heap.length * 2];

        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }

        heap = newHeap;
    }

    public int getSize() {
        return size;
    }
}
