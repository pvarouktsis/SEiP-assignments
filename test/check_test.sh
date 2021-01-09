if cat test_outputs.txt | grep "FAILED"; then
  rm test_outputs.txt;
  exit 1; 
else 
  rm test_outputs.txt; 
  echo "Process terminated successfully";
fi
