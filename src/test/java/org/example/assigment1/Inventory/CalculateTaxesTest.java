package org.example.assigment1.Inventory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTaxesTest {

    @Test
    void checkForTaxOfRaw() {
        double checkForTax = Double.parseDouble(CalculateTaxes.calculateTax("Raw",5,10));
        assertEquals(5.62, checkForTax);
        String checkForTax1 = CalculateTaxes.calculateTax("xyz",5,10);
        assertEquals("xyz is not belonging to any type of item", checkForTax1);
        double checkForTax2 = Double.parseDouble(CalculateTaxes.calculateTax("Raw",10,20));
        assertEquals(11.25, checkForTax2);
    }
    @Test
    void checkForTaxOfManufactured() {
        double checkForTax = Double.parseDouble(CalculateTaxes.calculateTax("Manufactured", 10, 2));
        assertEquals(11.47, checkForTax);
        String checkForTax1 = CalculateTaxes.calculateTax("xyz", 10, 2);
        assertEquals("xyz is not belonging to any type of item", checkForTax1);
        double checkForTax2 = Double.parseDouble(CalculateTaxes.calculateTax("Manufactured", 20, 1));
        assertEquals(22.95, checkForTax2);
    }
    @Test
    void checkForImported(){
        double checkForImportedTPriceGreaterthan100LessThan200 = Double.parseDouble(CalculateTaxes.calculateTax("Imported", 100, 1));
        assertEquals(120,checkForImportedTPriceGreaterthan100LessThan200);
        double checkForImportedTPriceLessthan100 = Double.parseDouble(CalculateTaxes.calculateTax("Imported", 20, 2));
        assertEquals(27,checkForImportedTPriceLessthan100);
        double checkForImportedTPriceGreaterthan200 = Double.parseDouble(CalculateTaxes.calculateTax("Imported" , 200, 2));
        assertEquals(231,checkForImportedTPriceGreaterthan200);
    }


}