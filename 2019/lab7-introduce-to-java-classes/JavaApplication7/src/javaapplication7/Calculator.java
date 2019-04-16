/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

/**
 *
 * @author czarodziej
 */
public class Calculator {
    
    private int result;
    private int a;
    private int b;
    private String character;
    private String calculationName;
    
    Calculator() {
        
    }
    
    public void setValues(int value1, int value2) {
        this.a = value1;
        this.b = value2;
    }
    
    public void setCalculation(String character) {
        this.character = character;
        this.setcalculationName();
    }
    
    private void addValues() {
        this.result = this.a + this.b;
    }
    
    private void diffValues() {
        this.result = this.a - this.b;
    }
    
    private void mulValues() {
        this.result = this.a * this.b;
    }
    
    private void setcalculationName() {
        if (this.character == "+") {
            this.calculationName = "dodawanie";
        }
        if (this.character == "-") {
            this.calculationName = "odejmowanie";
        }
        if (this.character == "*") {
            this.calculationName = "mnożenie";
        }
    }
    
    private void printCaulculator() {
        ResultManager rm = new ResultManager(this.result, this.calculationName);
    }
    
    public void calculate() {
        if (this.character == "+") {
            this.addValues();
        }
        if (this.character == "-") {
            this.diffValues();
        }
        if (this.character == "*") {
            this.mulValues();
        }
        this.printCaulculator();
    }
}
