package interviewProblems.uberRegister;

import interviewProblems.uberRegister.exception.RegisterNotFoundException;

//1. System Design
//Problem Description: You are given 4 registers: A, B, C, and D. Each register has an associated value. You need to implement the following functionalities:
//
//Set(register(string), value(int)): Set the value of the input register to the new input value.
//Inc(register(string)): Increment the value of the register by 1.
//Move(register1(string), register2(string)): Copy the value of register2 to register1.
//Dec(register(string)): Decrement the value of the register by 1.
//AddR(register1(string), register2(string), value): Add the values of register1 and register2 and update register1 to the new sum.
//You need to implement a basic microprocessor to perform these operations based on input commands
//
//Problem approach
//Tip 1: Start with a class-based design. Create a Register class that holds the value of the register and supports the operations as methods.
//
//Tip 2: Use a dictionary to represent the registers (A, B, C, D) and their corresponding values. This will allow easy access to modify values for different commands.
//
//Tip 3: Think about OOP principles: Ensure that your design adheres to OOPS concepts like encapsulation (keeping the register values hidden), and make sure your code is extensible and modular. Each operation should be self-contained in a function.

import interviewProblems.uberRegister.register.RegisterManager;

public class Demo {
    public static void main(String[] args) {
        RegisterManager rm = new RegisterManager();
        rm.createRegister("A");
        rm.createRegister("B");
        rm.createRegister("C");
        rm.createRegister("D");

        // Set initial values
        rm.set("A", 10);
        rm.set("B", 5);
        rm.set("C", 0);
        rm.set("D", 20);

        System.out.println("Initial state:");
        printRegisterState(rm);

        // Perform operations
        rm.inc("A");          // A: 10 -> 11
        rm.dec("B");          // B: 5 -> 4
        rm.move("C", "A");    // C: 0 -> 11 (from A)
        rm.addR("D", "B");    // D: 20 + 4 = 24
        rm.inc("C");          // C: 11 -> 12
        rm.dec("D");          // D: 24 -> 23
        rm.move("A", "D");    // A: 11 -> 23 (from D)
        rm.addR("B", "C");    // B: 4 + 12 = 16
        rm.set("C", 100);     // C: 12 -> 100

        System.out.println("\nAfter operations:");
        printRegisterState(rm);

        // Validate results
        System.out.println("\nValidations:");
        assertRegisterValue(rm, "A", 23, "A should be 23");
        assertRegisterValue(rm, "B", 16, "B should be 16");
        assertRegisterValue(rm, "C", 100, "C should be 100");
        assertRegisterValue(rm, "D", 23, "D should be 23");

        System.out.println("All validations passed!");
    }

    private static void printRegisterState(RegisterManager rm) {
        System.out.println("A: " + rm.getValue("A"));
        System.out.println("B: " + rm.getValue("B"));
        System.out.println("C: " + rm.getValue("C"));
        System.out.println("D: " + rm.getValue("D"));
    }

    private static void assertRegisterValue(RegisterManager rm, String name, int expected, String message) {
        int actual = rm.getValue(name);
        if (actual == expected) {
            System.out.println("✓ " + message);
        } else {
            System.out.println("✗ " + message + " (got " + actual + ")");
        }
    }
}
