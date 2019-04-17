#!/bin/bash

tests=(tests
tiny_both
tiny_positive
tiny_negative)

passes=0

for i in $(seq ${#tests[*]} $END)
do
    test=${tests[${i}]}
    if [[ ! -z "$test" ]]; then
	cp tests/${test}/lista.txt lista.txt
	cat tests/${test}/input.txt | java -jar jar.jar > output.txt
	cat output.txt | grep -E 'TAK|NIE|Nie|Tak' > fixed_output.txt && rm output.txt
	tr '[:lower:]' '[:upper:]' < fixed_output.txt > output.txt && rm fixed_output.txt
	diff -w tests/${test}/expected_output.txt output.txt
	code=$?
	if [ "$code" -eq "0" ]; then
	    echo "TEST ${test}: PASS"
	    passes=$((passes+1))
	else
	    echo "TEST ${test}: FAIL"
	fi
        rm lista.txt
        rm output.txt
    fi
done
echo ${passes} tests passes
