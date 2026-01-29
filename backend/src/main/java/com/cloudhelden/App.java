package com.cloudhelden;

/**
 * GitHub Actions Demo - Backend Application
 */
public class App {

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("GitHub Actions Demo - Backend");
        System.out.println("=================================");
        System.out.println();

        // Demo: Greet
        String greeting = greet("GitHub Actions");
        System.out.println(greeting);

        // Demo: Calculate
        int sum = add(5, 3);
        System.out.println("5 + 3 = " + sum);

        // Demo: Check Even
        boolean isEven = isEven(42);
        System.out.println("Is 42 even? " + isEven);

        System.out.println();
        System.out.println("✓ Backend running successfully!");
    }

    /**
     * Greet a person by name
     */
    public static String greet(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hello, Stranger!";
        }
        return "Hello, " + name + "! Welcome to CI/CD! 🚀";
    }

    /**
     * Add two numbers
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * Check if number is even
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Multiply two numbers
     */
    public static int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Get application version
     */
    public static String getVersion() {
        return "1.0.0";
    }
}
