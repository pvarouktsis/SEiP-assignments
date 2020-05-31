# Source Code Analyzer
A maven project that receives a Java source code file, analyzes it and exports its metrics. These metrics are:
- LOC (Lines of Code)
- NOM (Number of Methods)
- NOC (Number of Classes)

## Getting Started
### Prerequisites
Install [Java](https://www.oracle.com/java/technologies/javase-downloads.html) and [Maven](https://maven.apache.org/), if you haven't already done.

### Installation
- #### Clone
  ```git clone https://github.com/pvarouktsis/lab-assignment-2.git```
- #### Change Directory
  ```cd ./lab-assignments-2/seip2020_practical_assignments/```
- #### Build
  ```mvn package jacoco:report```
- #### Run
  ```
  java –jar ./target/sourcecodeanalyzer-1.0-SNAPSHOT-jar-with-dependencies.jar arg0 arg1 arg2 arg3 arg4
  ```    
  - arg0 = “JavaSourceCodeInputFile” (e.g. src/test/resources/TestClass.java)  
  - arg1 = “sourceCodeAnalyzerType” [regex|strcomp]  
  - arg2 = “SourceCodeLocationType” [local|web]  
  - arg3 = “OutputFilePath” (e.g. ../output_metrics_file)  
  - arg4 = “OutputFileType” [csv|json]
- #### Example
  ```
  java -jar ./target/sourcecodeanalyzer-1.0-SNAPSHOT-jar-with-dependencies.jar src/test/resources/TestClass.java regex local outputs csv
  ```

## Built with
- [Maven](https://maven.apache.org/) \- Dependency Management

## Version
- Source Code Analyzer 1.0.0

## Authors
- Panagiotis Varouktsis

&nbsp;
# Module's Architecture
## UML Diagram
![diagram](../../resources/UML_source_code_analyzer.svg)

## Patterns
- ### Facade Pattern  
  Facade pattern hides the functionality of the other classes and introduces a friendly interface as proposed from the assignment. The user/client can process a Java source code file by creating an Analyzer object, passing all the arguments, and then calling the execute() method to calculate the metrics and export them. Unfortunately, the user/client is limited to the functionalities of the methods implemented by the Facade class unless he can access the other classes directly, which in this case he can but reduces the code security.
 
  - Analyzer (Facade Class)
  - ExporterFactory
  - SourceFileReaderFactory
  - Metric
  
- ### Factory Pattern
  Factory pattern provides flexibility and separation of concerns between different implementations of classes. For example, ExporterFactory initializes/creates an Exporter either CSVExporter or JSONExporter and returns it without worrying about the instance of it.
  
  - ExporterFactory (Factory Class)
  - Exporter
  - CSVExporter
  - JSONExporter
  - SourceFileReaderFactory (Factory Class)
  - SourceFileReader
  - LocalFileReader
  - WebFileReader

- ### Strategy Pattern 
  Strategy patterns provides easy extendability for new implentations from classes or interfaces (e.g. Exporter).
  
  - Exporter (Interface) 
  - CSVExporter
  - JSONExporter
  - SourceFileReader (Interface)
  - LocalFileReader
  - WebFileReader
  - Metric (Interface)
  - LOCMetric
  - NOMMetric
  - NOCMetric
 
- ### Bridge Pattern
  Bridge pattern was also a candidate to implement the two types of methods defined by the SourceFileReader interface. More specifically it would have been implemented a new interface named FileReaderType which would have been inherited by two childs, StringFileReader and ListFileReader. Each one would have contained two methods to implement the operations for LocalFileReader and WebFileReader, respectively. Although this pattern would have increased the code flexibility and independency, it would have also added more complexity to the code.
