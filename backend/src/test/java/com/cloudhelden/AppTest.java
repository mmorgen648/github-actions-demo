package com.cloudhelden;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die App-Klasse
 */
class AppTest {

    @Test
    @DisplayName("Test greet with valid name")
    void testGreetWithName() {
        String result = App.greet("GitHub Actions");
        assertEquals("Hello, GitHub Actions! Welcome to CI/CD! 🚀", result);
    }

    @Test
    @DisplayName("Test greet with empty name")
    void testGreetEmpty() {
        String result = App.greet("");
        assertEquals("Hello, Stranger!", result);
    }

    @Test
    @DisplayName("Test greet with null")
    void testGreetNull() {
        String result = App.greet(null);
        assertEquals("Hello, Stranger!", result);
    }

    @Test
    @DisplayName("Test add positive numbers")
    void testAdd() {
        int result = App.add(5, 3);
        assertEquals(8, result);
    }

    @Test
    @DisplayName("Test add with zero")
    void testAddZero() {
        int result = App.add(10, 0);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("Test add negative numbers")
    void testAddNegative() {
        int result = App.add(-5, -3);
        assertEquals(-8, result);
    }

    @Test
    @DisplayName("Test isEven with even number")
    void testIsEven() {
        assertTrue(App.isEven(42));
        assertTrue(App.isEven(0));
        assertTrue(App.isEven(-4));
    }

    @Test
    @DisplayName("Test isEven with odd number")
    void testIsOdd() {
        assertFalse(App.isEven(43));
        assertFalse(App.isEven(1));
        assertFalse(App.isEven(-3));
    }

    @Test
    @DisplayName("Test multiply")
    void testMultiply() {
        assertEquals(15, App.multiply(3, 5));
        assertEquals(0, App.multiply(5, 0));
        assertEquals(-12, App.multiply(3, -4));
    }

    @Test
    @DisplayName("Test version")
    void testVersion() {
        String version = App.getVersion();
        assertNotNull(version);
        assertTrue(version.matches("\\d+\\.\\d+\\.\\d+"));
    }
}
