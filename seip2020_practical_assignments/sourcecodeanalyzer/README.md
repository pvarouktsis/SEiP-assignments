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
![uml_diagram](../../.github/UML_source_code_analyzer.svg)

## Patterns
- ### Facade Pattern  
- ### Factory Pattern
- ### Strategy Pattern 
- ### Bridge Pattern (as canditate)
