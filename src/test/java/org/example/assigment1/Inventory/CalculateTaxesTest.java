package org.example.assigment1.Inventory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTaxesTest {

    @Test
    void checkForTaxOfRaw() {
        double checkForTax = CalculateTaxes.calculateTax("Raw",5,10);
        assertEquals(56.25, checkForTax);
    }
    @Test
    void checkForTaxOfManufactured() {
        double checkForTax = CalculateTaxes.calculateTax("Manufactured", 10, 2);
        assertEquals(22.95, checkForTax);
    }
    @Test
    void checkForImported(){
        double checkForImportedTPriceGreaterthan100LessThan200 = CalculateTaxes.calculateTax("Imported", 100, 1);
        assertEquals(120,checkForImportedTPriceGreaterthan100LessThan200);
        double checkForImportedTPriceLessthan100 = CalculateTaxes.calculateTax("Imported", 20, 2);
        assertEquals(49,checkForImportedTPriceLessthan100);
        double checkForImportedTPriceGreaterthan200 = CalculateTaxes.calculateTax("Imported" , 200, 2);
        assertEquals(462,checkForImportedTPriceGreaterthan200);
    }
}