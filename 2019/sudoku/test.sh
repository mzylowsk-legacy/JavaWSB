#!/bin/bash

expected=(1 0 2 1 1 2 2 1)
passes=0

for i in 0 1 2 3 4 5 6 7
do
   cp sudoku_tests/${i}.txt sudoku.txt
   java -jar dist/sudoku.jar
   code=$?
   if [ "$code" -eq "${expected[$i]}" ]; then
	echo "TEST no ${i}: PASS"
	passes=$((passes+1))
   else
	echo "TEST no ${i}: FAIL! $code != ${expected[$i]}"
   fi
done
echo ${passes} passes from, ${#expected[*]} tests
