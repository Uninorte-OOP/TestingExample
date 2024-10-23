/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author edangulo
 */
public class CalculatorTest {
    
    @Test
    public void testCalculator() throws Throwable {
        // Given
        int[] memorySize = {-6, 97, 9, 12, -187, -1674};
        
        // When
        Calculator[] calculators = new Calculator[memorySize.length];
        for (int i = 0; i < memorySize.length; i++) {
            calculators[i] = new Calculator(memorySize[i]);
        }
        
        // Then
        for (int i = 0; i < memorySize.length; i++) {
            assertEquals(Math.abs(memorySize[i]), calculators[i].getMemorySize());
        }
    }
    
    @Test
    public void testAdd() throws Throwable {
        // Given
        Calculator calculator = new Calculator(-6);
        double[] adder1 = {Double.MIN_VALUE, 0, Double.MAX_VALUE};
        double[] adder2 = {Double.MIN_VALUE, 0, Double.MAX_VALUE};
        
        // When
        double[] results = new double[adder1.length * adder2.length];
        for (int i = 0; i < adder1.length; i++) {
            for (int j = 0; j < adder2.length; j++) {
                results[adder2.length * i + j] = calculator.add(adder1[i], adder2[j]);
            }
        }
        
        // Then
        assertEquals(1.0E-323, results[0], 0);
        assertEquals(Double.MIN_VALUE, results[1], 0);
        assertEquals(Double.MAX_VALUE, results[2], Double.MIN_VALUE);
        assertEquals(Double.MIN_VALUE, results[3], 0);
        assertEquals(0, results[4], 0);
        assertEquals(Double.MAX_VALUE, results[5], 0);
        assertEquals(Double.MAX_VALUE, results[6], Double.MIN_VALUE);
        assertEquals(Double.MAX_VALUE, results[7], 0);
        assertEquals(Double.POSITIVE_INFINITY, results[8], 0);
    }
    
    @Test
    public void testDivide() throws Throwable {
        // Given
        Calculator calculator = new Calculator(-6);
        
        // When
        double a = 15.5, b = 0.0;
        double result = calculator.divide(a, b);
        
        // Then
        assertEquals(Double.POSITIVE_INFINITY, result, 0);
    }
    
    @Test
    public void testSaveValue() {
        // Given
        Calculator calculator = new Calculator(-6);
        
        // When
        double a = 1597.62;
        calculator.saveValue(a, 10);
        
        // Then
        assertEquals(a, calculator.loadValue(10), 0);
    }
    
}
