# Histogram Generator

**This is a Maven Project that receives a path as argument from the user of a .txt file which contains integer numbers, one number per line (eg. students' grades), and generates its Frequency Histogram based on [JFreeChart](http://www.jfree.org/jfreechart/).**
  
## Getting Started

### Prerequisites

First you have to install [Java](https://www.oracle.com/java/technologies/javase-downloads.html) and [Maven](https://maven.apache.org/) if you haven't already done.

### Installation

Clone the repository 
```git clone https://github.com/pvarouktsis/lab-assignment-2.git ```

Change to project's main directory where the first pom.xml is  
```cd ./lab-assignment-2/seip2020_practical_assignments/```

Build the package  
```mvn package```

Run HistogramGenerator as follows  
```java -jar gradeshistogram/target/gradeshistogram-1.0-SNAPSHOT-jar-with-dependencies.jar path/of/your/file.txt```

## Built with

- [Maven](https://maven.apache.org/) \- Dependency Management

## Version

- Histogram Generator 1.0.0

## Authors

- Panagiotis Varouktsis

