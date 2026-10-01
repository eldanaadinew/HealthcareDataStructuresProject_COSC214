# Healthcare Data Structures Benchmark

A Java benchmarking project that compares common data structures for storing and processing healthcare-style patient records. The program loads CSV data, measures core operations across multiple dataset sizes, and simulates priority-based patient admission.

## Project coordination and delivery

**Project scope and deliverables:** Compared four data structures with 1,000, 5,000, and 10,000 records; delivered Java implementations, CSV processing, benchmarks, and an admission simulation.

**Quality assurance:** Repeated benchmark measurements three times and handled malformed records. The repository credits three contributors without specifying individual task ownership.


## Project coordination and delivery

Four data structures; benchmarks at 1,000, 5,000 and 10,000 records; three benchmark runs; documented comparative findings. This is a collaborative project with three listed contributors; individual responsibilities are not specified.

## Highlights

- Implements a dynamic array, linked list, hash table with separate chaining, and heap-based priority queue.
- Benchmarks insert, search, delete, and traversal operations with 1,000, 5,000, and 10,000 records.
- Averages each benchmark across three runs using `System.nanoTime()`.
- Prioritizes emergency patients in a hospital-admission simulation.
- Skips malformed CSV rows without stopping the full data load.

## Technologies

- Java
- Object-oriented programming
- Data structures and algorithms
- CSV file processing
- Performance benchmarking

## Project structure

| File | Purpose |
| --- | --- |
| `Main.java` | Loads datasets, runs benchmarks, and starts the admission simulation |
| `PatientRecord.java` | Models each patient record |
| `CSVLoader.java` | Parses records from the CSV dataset |
| `DynamicArrayStructure.java` | Resizable-array implementation |
| `LinkedListStructure.java` | Singly linked-list implementation |
| `HashStructure.java` | Hash table with separate chaining |
| `PriorityQueueStructure.java` | Heap-based priority queue |
| `BenchmarkTester.java` | Measures and reports operation times |

## Run locally

Requirements: Java Development Kit (JDK) 17 or newer.

```bash
javac *.java
java Main
```

Keep `healthcare_dataset.csv` in the repository root when running the program.

## Benchmark coverage

For each data structure, the program reports average nanosecond timing for:

- Inserting all records
- Searching for a record by ID
- Deleting a record by ID
- Traversing stored records

Results vary by computer and Java runtime, so the project is designed to compare relative behavior rather than claim fixed performance numbers.

## Contributors

- Eldana Adinew
- Nzubechukwu Onwere
- Jenel Owusu

## Resume project-management context (self-reported)

For job applications, Eldana describes leading a 4–6-member team over six weeks, tracking approximately 20–30 tasks in Jira and Trello, maintaining requirements and meeting notes in Confluence, and coordinating testing and presentation deliverables through Microsoft Teams. Eldana reports that deadlines were met and the project received an A. These coordination details and grades are self-reported and are not independently verified by the source files in this repository. Three contributors are named below; this list does not establish the total team size.
