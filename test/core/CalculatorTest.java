/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author edangulo
 */
public class CalculatorTest {
    
    @Test
    public void testCalculator() throws Throwable {
        // Given
        int[] memorySizes = {-9, 52, 14, 0, -861, 7493};
        
        // When
        Calculator[] calculators = new Calculator[memorySizes.length];
        for (int i = 0; i < memorySizes.length; i++) {
            calculators[i] = new Calculator(memorySizes[i]);
        }
        
        // Then
        for (int i = 0; i < calculators.length; i++) {
            assertEquals(Math.abs(memorySizes[i]), calculators[i].getMemorySize());
        }
    } 
    
    @Test
    public void testAdd() throws Throwable {
        // Given
        Calculator calculator = new Calculator(6);
        double[] adder1 = {0, Double.MIN_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN};
        double[] adder2 = {0, Double.MIN_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN};
        
        // When
        double[] results = new double[adder1.length * adder2.length];
        for (int i = 0; i < adder1.length; i++) {
            for (int j = 0; j < adder2.length; j++) {
                results[adder2.length * i + j] = calculator.add(adder1[i], adder2[j]);
            }
        }
        
        // Then
        assertEquals(0, results[0], 0);
        assertEquals(Double.MIN_VALUE, results[1], 0);
        assertEquals(Double.MAX_VALUE, results[2], 0);
        assertEquals(Double.NEGATIVE_INFINITY, results[3], 0);
        assertEquals(Double.POSITIVE_INFINITY, results[4], 0);
        assertEquals(Double.NaN, results[5], 0);
        
        assertEquals(Double.MIN_VALUE, results[6], 0);
        assertEquals(2 * Double.MIN_VALUE, results[7], 0);
        assertEquals(Double.MAX_VALUE, results[8], 0.01);
        assertEquals(Double.NEGATIVE_INFINITY, results[9], 0);
        assertEquals(Double.POSITIVE_INFINITY, results[10], 0);
        assertEquals(Double.NaN, results[11], 0);
        
        assertEquals(Double.MAX_VALUE, results[12], 0);
        assertEquals(Double.MAX_VALUE, results[13], 0.01);
        assertEquals(2 * Double.MAX_VALUE, results[14], 0);
        assertEquals(Double.NEGATIVE_INFINITY, results[15], 0);
        assertEquals(Double.POSITIVE_INFINITY, results[16], 0);
        assertEquals(Double.NaN, results[17], 0);
        
        assertEquals(Double.NEGATIVE_INFINITY, results[18], 0);
        assertEquals(Double.NEGATIVE_INFINITY, results[19], 0);
        assertEquals(Double.NEGATIVE_INFINITY, results[20], 0);
        assertEquals(Double.NEGATIVE_INFINITY, results[21], 0);
        assertEquals(Double.NaN, results[22], 0);
        assertEquals(Double.NaN, results[23], 0);
        
        assertEquals(Double.POSITIVE_INFINITY, results[24], 0);
        assertEquals(Double.POSITIVE_INFINITY, results[25], 0);
        assertEquals(Double.POSITIVE_INFINITY, results[26], 0);
        assertEquals(Double.NaN, results[27], 0);
        assertEquals(Double.POSITIVE_INFINITY, results[28], 0);
        assertEquals(Double.NaN, results[29], 0);
        
        assertEquals(Double.NaN, results[30], 0);
        assertEquals(Double.NaN, results[31], 0);
        assertEquals(Double.NaN, results[32], 0);
        assertEquals(Double.NaN, results[33], 0);
        assertEquals(Double.NaN, results[34], 0);
        assertEquals(Double.NaN, results[35], 0);
    }
    
    @Test
    public void testDivide() throws Throwable {
        // Given
        Calculator calculator = new Calculator(6);
        
        // When
        double a = -1589.54, b = 0.0;
        double result = calculator.divide(a, b);
        
        // Then
        assertTrue(Double.isInfinite(result));
    }
    
    @Test
    public void testSaveValue() throws Throwable {
        // Given
        Calculator calculator = new Calculator(6);
        
        // When
        double value = -6684.6841;
        calculator.saveValue(value, 10);
        
        // Then
        assertEquals(value, calculator.loadValue(10), 0);
    }
    
}
