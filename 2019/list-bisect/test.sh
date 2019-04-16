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
	cat output.txt | grep -E 'TAK|NIE' > fixed_output.txt && rm output.txt
	diff -w tests/${test}/expected_output.txt fixed_output.txt
	code=$?
	if [ "$code" -eq "0" ]; then
	    echo "TEST ${test}: PASS"
	    passes=$((passes+1))
	else
	    echo "TEST ${test}: FAIL"
	fi
    fi
done
echo ${passes} tests passes
