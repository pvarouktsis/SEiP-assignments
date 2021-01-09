#!/bin/bash

# Initialization of variables
TEST_FILE='verify_outputs.csv'

# Produce outputs.csv
java -jar ./../seip2020_practical_assignments/sourcecodeanalyzer/target/sourcecodeanalyzer-1.0-SNAPSHOT-jar-with-dependencies.jar \
./../seip2020_practical_assignments/sourcecodeanalyzer/src/test/resources/TestClass.java \
regex \
local \
outputs \
csv

# Produce manually verify_outputs.csv
echo "LOC,NOC,NOM," > $TEST_FILE
echo "21,3,3," >> $TEST_FILE
echo "Manually test file created successfully"
echo ""

# Test
if ["$(diff outputs.csv $TEST_FILE)" == ""]
then
  echo "[PASSED] Integration Test of Source Code Analyzer"
else
  echo "[FAILED] Integration Test of Source Code Analyzer"
fi

# Delete produced files
rm outputs.csv
rm $TEST_FILE
