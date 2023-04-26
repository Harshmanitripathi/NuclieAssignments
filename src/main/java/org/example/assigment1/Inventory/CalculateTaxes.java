package org.example.assigment1.Inventory;

import java.text.DecimalFormat;

public class CalculateTaxes {
//    objectForReducingToTwoDecimalPlaces object of class DecimalFormat is used to convert double value to 2 decimal places
    private static final DecimalFormat objectForReducingToTwoDecimalPlaces = new DecimalFormat("0.00");
    public static double calculateTax(String typeOfItem, double priceOfItem, int quantityOfITem) {
        double priceWithAddedTax=0.00;
        if (typeOfItem.equalsIgnoreCase("Raw")){
            priceWithAddedTax = priceOfItem * quantityOfITem;
            priceWithAddedTax = (priceWithAddedTax * 1.125);
        }
        else if (typeOfItem.equalsIgnoreCase("Manufactured")){
            priceWithAddedTax = priceOfItem * quantityOfITem;
            priceWithAddedTax = ((priceWithAddedTax * .125) + priceWithAddedTax)*1.02;
        }
        else if (typeOfItem.equalsIgnoreCase("Imported")){
            priceWithAddedTax = priceOfItem * quantityOfITem;
            priceWithAddedTax = priceWithAddedTax * 1.10;
            if (priceWithAddedTax <=100){
                priceWithAddedTax += 5;
            }
            else if (priceWithAddedTax >100 && priceWithAddedTax <= 200) {
                priceWithAddedTax += 10;
            }
            else {
                priceWithAddedTax = (priceWithAddedTax * 1.05);
            }

        }
        return Double.parseDouble(objectForReducingToTwoDecimalPlaces.format(priceWithAddedTax));
    }
}
