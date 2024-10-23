/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author edangulo
 */
public class Calculator {
    
    private double[] memory;
    
    public Calculator(int n) {
        this.memory = new double[Math.abs(n)];
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public double subtract(double a, double b) {
        return a - b;
    }
    
    public double multiply(double a, double b) {
        return a * b;
    }
    
    public double divide(double a, double b) {
        return a / b;
    }
    
    public double power(double a, double b) {
        return Math.pow(a, b);
    }
    
    public void saveValue(double value, int index) {
        this.memory[index] = value;
    }
    
    public double loadValue(int index) {
        return this.memory[index];
    }
    
    public void deleteValue(int index) {
        this.memory[index] = 0;
    }
    
    public int getMemorySize() {
        return this.memory.length;
    }
    
}
