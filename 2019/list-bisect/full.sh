#!/bin/bash

tests=(tests
corner_no_search
corner_single_false
corner_single_true
corner_huge_list_one_search
corner_huge_list_one_search_with_duplicates
medium_with_duplicates
medium_without_duplicates
huge_list_many_search)

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
