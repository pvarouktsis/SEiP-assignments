# Histogram Generator

**This is a Maven Project that receives the path of a .txt file as argument from the user and generates its frequency histogram. The .txt file (e.g. grades.txt) must contain integer numbers, and only one number per line, otherwise there will be an error that will stop the process. The Project makes use of [JFreeChart](http://www.jfree.org/jfreechart/) to produce the final histogram chart.**
  
## Getting Started

### Prerequisites

Install [Java](https://www.oracle.com/java/technologies/javase-downloads.html) and [Maven](https://maven.apache.org/) if you haven't already done.

### Installation

Clone the repository  
```git clone https://github.com/pvarouktsis/lab-assignment-2.git ```

Change to project's main directory where the first pom.xml is  
```cd ./lab-assignment-2/seip2020_practical_assignments/```

Build the package  
```mvn package```

Run Histogram Generator as follows  
```java -jar gradeshistogram/target/gradeshistogram-1.0-SNAPSHOT-jar-with-dependencies.jar path/of/your/file.txt```

## Built with

- [Maven](https://maven.apache.org/) \- Dependency Management

## Version

- Histogram Generator 1.0.0

## Authors

- Panagiotis Varouktsis

