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
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
            
        calc.setValues(2,4);
        calc.setCalculation("+");
        calc.calculate();

        calc.setValues(5, 3);
        calc.calculate();

        calc.setCalculation("-");
        calc.calculate();
        
    }
}
