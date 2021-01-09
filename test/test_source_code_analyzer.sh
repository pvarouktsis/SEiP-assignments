#!/bin/bash

# Initialization of variables
SOURCE_FILE='./../seip2020_practical_assignments/sourcecodeanalyzer/src/test/resources/TestClass.java'
ANALYZER_TYPE='regex'
SOURCE_FILE_LOCATION='local'
ACTUAL_OUTPUT_FILEPATH='actual_outputs'
ACTUAL_OUTPUT_FILETYPE='csv'

ACTUAL_OUTPUTS=$ACTUAL_OUTPUT_FILEPATH'.'$ACTUAL_OUTPUT_FILETYPE
EXPECTED_OUTPUTS='expected_outputs.csv'

# Produce the actual_outputs.csv
java -jar ./../seip2020_practical_assignments/sourcecodeanalyzer/target/sourcecodeanalyzer-1.0-SNAPSHOT-jar-with-dependencies.jar \
$SOURCE_FILE \
$ANALYZER_TYPE \
$SOURCE_FILE_LOCATION \
$ACTUAL_OUTPUT_FILEPATH \
$ACTUAL_OUTPUT_FILETYPE

# Produce manually the expected_outputs.csv
echo "LOC,NOC,NOM," > $EXPECTED_OUTPUTS
echo "7,3,3," >> $EXPECTED_OUTPUTS

# Test
if [ "$(diff $ACTUAL_OUTPUTS $EXPECTED_OUTPUTS)" ]
then
  rm $ACTUAL_OUTPUTS
  rm $EXPECTED_OUTPUTS
  
  echo "[FAILED] Integration Test of Source Code Analyzer"
  exit 1
fi

rm $ACTUAL_OUTPUTS
rm $EXPECTED_OUTPUTS

echo "[PASSED] Integration Test of Source Code Analyzer"

